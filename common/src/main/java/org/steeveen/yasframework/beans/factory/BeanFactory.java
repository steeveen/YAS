package org.steeveen.yasframework.beans.factory;

import org.steeveen.yasframework.beans.BeansException;

public interface BeanFactory {
    public Object getBean(String name) throws BeansException;


}
