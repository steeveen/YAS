package org.steeveen.yasframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import org.steeveen.yasframework.beans.BeansException;
import org.steeveen.yasframework.beans.PropertyValue;
import org.steeveen.yasframework.beans.PropertyValues;
import org.steeveen.yasframework.beans.factory.config.BeanDefinition;
import org.steeveen.yasframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * 在抽象BeanFactory上，实现创建bean的逻辑
 * 实现了bean的创建逻辑，
 *  实例化：提供了两种实例化策略，JDK和cgLib
 *  填充属性
 * 但因为没有提供BeanDefination的读取方法，仍然是抽象的。
 *
 * @author steeveen
 * @date 2023/2/11
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    /*采用cglib生成目标类的代理类*/
//    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();
    /*直接使用jdk进行实例化*/
    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        //尝试通过Bean定义中的默认构造创建对象
        try {
            bean = createBeanInstance(beanName, beanDefinition, args);
            /*完成bean初始化后，对bean中的属性进行填充*/
            applyPropertyValues(beanName,bean,beanDefinition    );
        } catch (Exception e) {
            throw new BeansException("instantiation or bean failed", e);
        }
        //将创建出的对象存入单例池中
        registrySingleton(beanName, bean);
        return bean;
    }



    protected Object createBeanInstance(String name, BeanDefinition beanDefinition, Object[] args)  {
        Constructor constructorToUse = null;
        Class beanClass = beanDefinition.getBeanClass();
        /*从众多声明的构造函数中，找到符合传入参数的构造函数，*/
        //TODO 目前仅通过参数数量与构造函数的形参数量进行匹配
        Constructor[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, name, constructorToUse, args);
    }

    protected   void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) throws BeansException {
        try{
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                /*基本类型直接填充即可，如果是引用类型，则通过beanName从容器中查询，并填充，暂不考虑循环依赖等问题*/
                if (value instanceof BeanReference){
                    BeanReference beanReference= (BeanReference) value;
                    value=getBean(beanReference.getBeanName());
                }
                BeanUtil.setFieldValue(bean,name,value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values:"+beanName);
        }

    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }
}
