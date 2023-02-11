package org.steeveen.yasframework.beans.factory.support;

import org.steeveen.yasframework.beans.BeansException;
import org.steeveen.yasframework.beans.factory.BeanFactory;
import org.steeveen.yasframework.beans.factory.config.BeanDefinition;

/**
 * beanFactory的实现类，结合定义的单例结构，实现beanFactory的功能
 *
 * @author steeveen
 * @date 2023/2/11
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        return getBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    protected <T> T doGetBean(final String name, final Object[] args) throws BeansException {
        //如果从容器中可以获取bean，则返回bean
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }
        //获取不到对象时，根据BeanDefination进行创建，并加入容器中
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    /**
     * 如何根据bean定义创建bean，由子类实现
     *
     * @param beanDefinition
     * @return
     */
    protected abstract Object createBean(String name, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    /**
     * 具体如何根据bean名称获取bean定义，由子类去实现
     *
     * @param name
     * @return
     */
    protected abstract BeanDefinition getBeanDefinition(String name) throws BeansException;
}
