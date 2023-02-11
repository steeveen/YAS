package org.steeveen.yasframework.test.bean;

import org.junit.Test;
import org.steeveen.yasframework.beans.BeansException;
import org.steeveen.yasframework.beans.factory.config.BeanDefinition;
import org.steeveen.yasframework.beans.factory.support.DefaultListableBeanFactory;
import org.steeveen.yasframework.test.bean.bean.UserService;

public class ApiTest {
    @Test
    public void test_beanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory() ;
        //将定义载入
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registryBeanDefinition("userService", beanDefinition);
        //从容器中获取对象
        UserService userService = (UserService) beanFactory.getBean("userService","steeveen");
        userService.queryUserInfo();
        //确保是单例
        UserService userService2 = (UserService) beanFactory.getBean("userService","steven");
        userService2.queryUserInfo();


    }
}
