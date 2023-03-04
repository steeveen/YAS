package org.steeveen.yasframework.beans.factory.support;

import org.steeveen.yasframework.beans.BeansException;
import org.steeveen.yasframework.beans.factory.config.BeanDefinition;

/**
 * 一个容器，仅仅提供bean定义的注册
 * @author steeveen
 * @date 2023/2/11
 */
public interface BeanDefinitionRegistry {
    /**
     * 注册bean对象
     * @param beanName bean名称
     * @param beanDefinition bean定义
     */
    void registryBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 根据名称获取BeanDefination
     * @param beanName bean名称
     * @return
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 判断beanName是否已经注册过
     * @param beanName bean名称
     * @return
     */
    boolean containsBeanDefinition(String beanName) ;

    /**
     * 获取所有已经注册了的bean名称
     * @return
     */
    String[] getBeanDefinitionNames();

}
