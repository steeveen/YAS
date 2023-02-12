package org.steeveen.yasframework.beans.factory.support;

import org.steeveen.yasframework.beans.BeansException;
import org.steeveen.yasframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 采用JDK的实例化策略
 * @author steeveen
 * @date 2023/2/11 23:25
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Class clazz = beanDefinition.getBeanClass();
        try{
            if (null!=ctor){
                //TODO 为什么不直接使用ctor呢
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            }else{
                return clazz.getDeclaredConstructor().newInstance(args);
            }
        } catch (NoSuchMethodException|InstantiationException|IllegalAccessException |InvocationTargetException e) {
            throw new BeansException("Failed to instantiate ['"+clazz.getName()+"']",e);
        }
    }
}
