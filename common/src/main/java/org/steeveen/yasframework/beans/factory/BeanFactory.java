package org.steeveen.yasframework.beans.factory;

import org.steeveen.yasframework.beans.BeansException;

/**
 * 该类解决的问题：只定义一个工厂， 外部可以通过getBean从工厂中取东西
 */
public interface BeanFactory {
    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

}
