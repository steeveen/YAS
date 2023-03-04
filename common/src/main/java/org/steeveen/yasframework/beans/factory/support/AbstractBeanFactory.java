package org.steeveen.yasframework.beans.factory.support;

import org.steeveen.yasframework.beans.BeansException;
import org.steeveen.yasframework.beans.factory.BeanFactory;
import org.steeveen.yasframework.beans.factory.config.BeanDefinition;

/**
 * beanFactory的实现类，结合定义的单例结构，实现beanFactory的功能
 * 作用，对bean工厂做进一步的具象。这个工厂可以有很多种写法，但是结合spring的应用场景，一般只需要一个单例对象就可以了，所以这里可以借助之前构建的单例进行实现。
 * 当外界想要获取对象时，就从单例池中获取，如果单例池中没有，则创建、入池、再返回。那么一个对象要如何创建呢，这个要交由子类去实现了，子类实现createBean即可。
 * 同样，创建一个bean也需要一些基本信息，这个基本信息的加载也交由子类去实现。
 * 根据BeanDefination去构建。这个逻辑交由子类去实现getBeanDefinition.
 *
 * @author steeveen
 * @date 2023/2/11
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
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
