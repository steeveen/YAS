package org.steeveen.yasframework.beans.factory.support;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.steeveen.yasframework.beans.BeansException;
import org.steeveen.yasframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 通过cglib进行实例化的策略
 *
 * @author steeveen
 * @date 2023/2/11 23:37
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        /*不对父类中的任何方法做改动，且hashCode采用父类的hash算法*/
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (null == ctor) {
            return enhancer.create();
        }
        return enhancer.create(ctor.getParameterTypes(), args);
    }
}
