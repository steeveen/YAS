package org.steeveen.yasframework.beans.factory.support;

import org.steeveen.yasframework.beans.factory.config.BeanDefinition;

/**
 * 一个容器，仅仅提供bean定义的注册
 * @author steeveen
 * @date 2023/2/11
 */
public interface BeanDefinitionRegistry {
    void registryBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
