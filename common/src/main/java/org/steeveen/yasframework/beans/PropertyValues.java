package org.steeveen.yasframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author steeveen
 * @date 2023/2/12 17:59
 */
public class PropertyValues {
    private  final List<PropertyValue> propertyValueList=new ArrayList<>();
    public void addPropertyValue(PropertyValue propertyValue){
        this.propertyValueList.add(propertyValue);
    }
    public PropertyValue[] getPropertyValues(){
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }
    public PropertyValue getPropertyValue(String name){
        /*TODO 使用线性查找，后期考虑是否可以使用map替换*/
        for (PropertyValue propertyValue : propertyValueList) {
            if (propertyValue.getName().equals(name)){
                return propertyValue;
            }
        }
        return null;
    }
}
