package com.toread.sys.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.util.Assert;

import java.util.Map;

/**
 * @author 黎志兵
 */
public abstract class JsonConvertBeanUtils {
    /**
     * 对象转换
     * @param tClass
     * @param object
     * @param <T>
     * @return
     */
    public static  final  <T> T  mapToBean(Class<T> tClass, Object object){
        return JSON.parseObject(JSON.toJSONString(object),tClass);
    }
}
