package org.steeveen.yasframework.beans.factory.support;

import org.steeveen.yasframework.beans.BeansException;
import org.steeveen.yasframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * 核心的bean工厂实现
 * @author steeveen
 * @time 2023/2/11
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {


    private Map<String, BeanDefinition> beanDefinitionMap=new HashMap<>();

    /**
     * 抽象工厂如何获取bean定义的到这里才开始实现
     * @param beanName
     * @return
     */
    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition==null){
            throw new BeansException("No bean named '"+beanName+"' is defined");
        }
        return beanDefinition;
    }

    @Override
    public void registryBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName,beanDefinition);
    }
}
