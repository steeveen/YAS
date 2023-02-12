package org.steeveen.yasframework.beans.factory.config;

/**
 * 暂时建模一个类型
 * @author steeveen
 * @date 2023/2/12 18:12
 */
public class BeanReference {
    /*该类型的实例的名称*/
    private String beanName;

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }
}
