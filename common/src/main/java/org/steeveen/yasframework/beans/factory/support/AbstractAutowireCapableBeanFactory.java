package org.steeveen.yasframework.beans.factory.support;

import org.steeveen.yasframework.beans.BeansException;
import org.steeveen.yasframework.beans.factory.config.BeanDefinition;

/**
 * 在抽象BeanFactory上，实现创建bean的逻辑
 *
 * @author steeveen
 * @date 2023/2/11
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        //尝试通过Bean定义中的默认构造创建对象
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("instantiation or bean failed", e);
        }
        //将创建出的对象存入单例池中
        registryStringleton(name, bean);
        return bean;
    }
}
