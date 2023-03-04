package org.steeveen.yasframework.beans.factory.support;

import org.steeveen.yasframework.beans.BeansException;
import org.steeveen.yasframework.core.io.Resource;
import org.steeveen.yasframework.core.io.ResourceLoader;

/**
 * 从ResourceLoader中加载资源，并注册到BeanDefination中去
 *
 * @author steeveen
 * @date 2023/2/19 22:27
 */
public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();
    /*上述两个方法为数据来源与去路，由子类进行实现*/

    void loadBeanDefinition(Resource resource) throws BeansException;

    void loadBeanDefinition(Resource... resources) throws BeansException;

    void loadBeanDefinition(String location) throws BeansException;

}
