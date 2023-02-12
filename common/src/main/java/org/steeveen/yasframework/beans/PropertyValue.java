package org.steeveen.yasframework.beans;

/**
 * @author steeveen
 * @date 2023/2/12 17:56
 */
public class PropertyValue {
    private final String name;
    private final Object value;
    /*final类型变量必须要在构造函数中初始化*/


    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
