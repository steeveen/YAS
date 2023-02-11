package org.steeveen.yasframework.beans.factory.support;

import org.steeveen.yasframework.beans.BeansException;
import org.steeveen.yasframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author steeveen
 * @date 2023/2/11 23:22
 */
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
