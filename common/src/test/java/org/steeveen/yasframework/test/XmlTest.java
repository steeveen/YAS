package org.steeveen.yasframework.test;

import org.junit.Test;
import org.steeveen.yasframework.beans.factory.support.DefaultListableBeanFactory;
import org.steeveen.yasframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.steeveen.yasframework.test.bean.UserService;

/**
 * @author steeveen
 * @date 2023/3/4 17:51
 */
public class XmlTest {
    @Test
    public void test_xml() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //为工厂指定配置reader
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinition("classpath:spring.xml");
        //测试注入的bean
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("test_xml result:" + result);
    }
}
