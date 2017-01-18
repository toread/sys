package com.toread.sys.common.data;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.Assert;

import java.util.Collection;

/**
 * 用来处理铭感数据不返回,使得数据
 * @author 黎志兵
 */
public abstract class ShieldBeanProperty {
    public static final <T extends  Collection> T process(T data,String... properties){
        T t = BeanUtils.instantiate((Class<T>) data.getClass());
        for (Object o : data) {
            t.add(process(o,properties));
        }
        return t;
    }

    public  static  final <T> T process(T data,String... properties){
        Assert.notNull(data);
        BeanWrapper beanWrapper = new BeanWrapperImpl(data);
        for (String property : properties) {
            beanWrapper.setPropertyValue(property,null);
        }
        return (T) beanWrapper.getWrappedInstance();
    }
}
