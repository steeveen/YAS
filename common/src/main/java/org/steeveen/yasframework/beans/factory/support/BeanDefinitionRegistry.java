package org.steeveen.yasframework.beans.factory.support;

import org.steeveen.yasframework.beans.factory.config.BeanDefinition;

/**
 * @author steeveen
 * @date 2023/2/11
 */
public interface BeanDefinitionRegistry {
    void registryBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
