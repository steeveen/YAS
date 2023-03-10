package org.steeveen.yasframework.beans.factory.support;

import org.steeveen.yasframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 单例注册的默认实现
 * 作用：对单例工厂提供一个基本的实现版本，即借助map实现功能
 * @author steeveen
 * @date 2023/2/11
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    @Override
    public void registrySingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
