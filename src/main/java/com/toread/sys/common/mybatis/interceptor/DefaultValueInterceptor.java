package com.toread.sys.common.mybatis.interceptor;

import com.toread.sys.common.mybatis.Sequence;
import com.toread.sys.common.mybatis.annotation.CTime;
import com.toread.sys.common.mybatis.annotation.IDSequence;
import com.toread.sys.common.mybatis.annotation.UTime;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Properties;

/**
 * @author 黎志兵
 */
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class })
})
@Component
public class DefaultValueInterceptor implements Interceptor {
    protected   static  final  Sequence sequence = new Sequence();
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] objects = invocation.getArgs();
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        String commandType =  mappedStatement.getSqlCommandType().name();
        Object object = objects[1];
        BeanWrapper beanWrapper = new BeanWrapperImpl(object);
        PropertyDescriptor[] descriptors = beanWrapper.getPropertyDescriptors();
        if("INSERT".equals(commandType)){
            for (PropertyDescriptor descriptor : descriptors) {
                String filedName = descriptor.getName();
                if(!"class".equals(filedName)&&!"empty".equals(filedName)){
                    Object values = beanWrapper.getPropertyValue(filedName);
                    if(values!=null){continue;}
                    Field field=  FieldUtils.getField(object.getClass(), filedName, true);
                    IDSequence idSequence = field.getAnnotation(IDSequence.class);
                    UTime updateTime = field.getAnnotation(UTime.class);
                    CTime createTime  = field.getAnnotation(CTime.class);
                    if(idSequence!=null){
                        beanWrapper.setPropertyValue(filedName,sequence.nextId());
                    }else if(createTime!=null){
                        beanWrapper.setPropertyValue(filedName, Calendar.getInstance().getTime());
                    }else if(updateTime!=null){
                        beanWrapper.setPropertyValue(filedName, Calendar.getInstance().getTime());
                    }
                }
            }
        }else if("UPDATE".equals(commandType)){
            for (PropertyDescriptor descriptor : descriptors) {
                String filedName = descriptor.getName();
                Object values = beanWrapper.getPropertyValue(filedName);
                if(values!=null){continue;}
                if(!"class".equals(filedName)&&!"empty".equals(filedName)){
                    Field field=  FieldUtils.getField(object.getClass(), filedName, true);
                    UTime updateTime = field.getAnnotation(UTime.class);
                    if(updateTime!=null){
                        beanWrapper.setPropertyValue(filedName, Calendar.getInstance().getTime());
                    }
                }
            }
        }
        objects[1] = beanWrapper.getWrappedInstance();
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof Executor) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
