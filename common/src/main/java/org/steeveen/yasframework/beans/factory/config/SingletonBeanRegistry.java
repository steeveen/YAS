package org.steeveen.yasframework.beans.factory.config;

/**
 * 获取或者注册单例的接口
 * 作用：抽象一个单例工厂，可以向其中写入单例、取出单例
 *
 * @author steeveen
 * @date 2023/2/11
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);

    void registrySingleton(String beanName, Object singletonObject);
}
