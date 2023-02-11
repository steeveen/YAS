package org.steeveen.yasframework.beans.factory.support;

import org.steeveen.yasframework.beans.BeansException;
import org.steeveen.yasframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 在抽象BeanFactory上，实现创建bean的逻辑
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
    protected Object createBean(String name, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        //尝试通过Bean定义中的默认构造创建对象
        try {
            bean = createBeanInstance(name, beanDefinition, args);
        } catch (Exception e) {
            throw new BeansException("instantiation or bean failed", e);
        }
        //将创建出的对象存入单例池中
        registrySingleton(name, bean);
        return bean;
    }

    protected Object createBeanInstance(String name, BeanDefinition beanDefinition, Object[] args) throws BeansException {
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

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }
}
