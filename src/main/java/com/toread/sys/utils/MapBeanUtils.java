package com.toread.sys.utils;

import com.toread.sys.common.spring.SpringContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.core.convert.ConversionService;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 黎志兵
 */
public abstract class MapBeanUtils {
    /**
     * 对象转换
     * @param object
     * @return
     */
    public static  final  Map<String,Object> beanToMap(Object object){
        Assert.notNull(object);
        BeanWrapper beanWrapper = new BeanWrapperImpl(object);
        PropertyDescriptor[] tag = beanWrapper.getPropertyDescriptors();
        Map<String,Object>  tagMap = new HashMap<>(tag.length-1);
        for (PropertyDescriptor propertyDescriptor : tag) {
            if(propertyDescriptor.getReadMethod()!=null&&propertyDescriptor.getWriteMethod()!=null){
                tagMap.put(propertyDescriptor.getName(),beanWrapper.getPropertyValue(propertyDescriptor.getName()));
            }
        }
        return tagMap;
    }

    /**
     * Map转对象
     */
    public static final <T> T mapToBean(Map<String,Object> maps,Class<T> t){
        Assert.notNull(maps);
        Set<String> keys = maps.keySet();
        T tagObject = BeanUtils.instantiate(t);
        if(CollectionUtils.isEmpty(keys)){
            return tagObject;
        }else{
            BeanWrapper beanWrapper = new BeanWrapperImpl(t);
            for (String key : keys) {
                PropertyDescriptor  propertyDescriptor = null;
                //如果不存在,底层抛出异常
                try{
                    propertyDescriptor = beanWrapper.getPropertyDescriptor(key);
                }catch (InvalidPropertyException e){
                    continue;
                }
                if(propertyDescriptor!=null&&maps.get(key)!=null){
                    Method writeMethod = propertyDescriptor.getWriteMethod();
                    ConversionService conversionService = SpringContext.getBean("customizationConversionService",ConversionService.class);
                    //如果是同类型相同直接转换
                    if(ClassUtils.isAssignable(writeMethod.getParameterTypes()[0], maps.get(key).getClass())){
                        beanWrapper.setPropertyValue(key,maps.get(key));
                    }else if(conversionService.canConvert(writeMethod.getParameterTypes()[0], maps.get(key).getClass())){
                        Object tagValue = conversionService.convert(maps.get(key),writeMethod.getParameterTypes()[0]);
                        beanWrapper.setPropertyValue(key,tagValue);
                    }
                }
            }
            T result = (T) beanWrapper.getWrappedInstance();
            return  result;
        }
    }
}
