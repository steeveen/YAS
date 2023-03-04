package org.steeveen.yasframework.test;

import org.junit.Test;
import org.steeveen.yasframework.beans.BeansException;
import org.steeveen.yasframework.beans.PropertyValue;
import org.steeveen.yasframework.beans.PropertyValues;
import org.steeveen.yasframework.beans.factory.config.BeanDefinition;
import org.steeveen.yasframework.beans.factory.config.BeanReference;
import org.steeveen.yasframework.beans.factory.support.DefaultListableBeanFactory;
import org.steeveen.yasframework.test.bean.UserDao;
import org.steeveen.yasframework.test.bean.UserService;

public class ApiTest {
    @Test
    public void test_beanFactory() throws BeansException {
        /*1、获取容器*/
        DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory() ;
        /*2、先注册UserDao*/
        beanFactory.registryBeanDefinition("userDao",new BeanDefinition(UserDao.class));

        /*3、注册UserService*/
        PropertyValues propertyValues=new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId","user03"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registryBeanDefinition("userService",beanDefinition);

        UserService userService= (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();



    }
    

}
