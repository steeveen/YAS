package org.steeveen.yasframework.beans.factory;

import org.steeveen.yasframework.beans.BeansException;

public interface BeanFactory {
    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;

}
