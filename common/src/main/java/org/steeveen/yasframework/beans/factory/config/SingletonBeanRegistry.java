package org.steeveen.yasframework.beans.factory.config;

/**
 * 获取或者注册单例的接口
 *
 * @author steeveen
 * @date 2023/2/11
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);

    void registrySingleton(String beanName, Object singletonObject);
}
