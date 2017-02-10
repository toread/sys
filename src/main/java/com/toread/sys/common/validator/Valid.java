package com.toread.sys.common.validator;

import com.toread.sys.common.spring.mvc.RestResult;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author 黎志兵
 */
@Component
public class Valid {
    @Autowired
    private Validator validator;

    public <T> void valid(T object, Class<?>... groups) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(object, groups);
        if (CollectionUtils.isEmpty(constraintViolations)) {
            return;
        }
        createFiledError(constraintViolations);
    }

    public <T> void validateProperty(T object, String propertyName, Class<?>... groups) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validateProperty(object, propertyName, groups);
        if (CollectionUtils.isEmpty(constraintViolations)) {
            return;
        }
        createFiledError(constraintViolations);
    }

    public <T> void validateNotNullProperty(T object, String... ignoreProperties) {
        BeanWrapper beanWrapper = new BeanWrapperImpl(object);
        List<String> ignoreList = (ignoreProperties != null ? Arrays.asList(ignoreProperties) : null);
        PropertyDescriptor[] propertyDescriptors = beanWrapper.getPropertyDescriptors();
        Set<ConstraintViolation<T>> constraintViolations = new HashSet<>();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            //拥有get和set方法才符合一个javabean对象
            Method writeMethod = propertyDescriptor.getWriteMethod();
            Method readMethod = propertyDescriptor.getReadMethod();
            if (writeMethod != null && readMethod != null
                    && (ignoreList == null || !ignoreList.contains(propertyDescriptor.getName()))
                    && tagTypeHasValue(beanWrapper, propertyDescriptor)) {
                constraintViolations.addAll(validator.validateProperty(object, propertyDescriptor.getName()));
            }
        }
        if (CollectionUtils.isEmpty(constraintViolations)) {
            return;
        }
        createFiledError(constraintViolations);
    }

    /**
     * 判断对象是否有值
     *
     * @param beanWrapper
     * @param propertyDescriptor
     * @return
     */
    protected boolean tagTypeHasValue(BeanWrapper beanWrapper, PropertyDescriptor propertyDescriptor) {
        return beanWrapper.getPropertyValue(propertyDescriptor.getName()) != null;
    }

    /**
     * 创建堆栈错误信息
     *
     * @param constraintViolations
     * @param <T>
     */
    protected <T> void createFiledError(Set<ConstraintViolation<T>> constraintViolations) {
        Collection<RestResult.FiledError> collection = new ArrayList<>();
        for (ConstraintViolation<T> constraintViolation : constraintViolations) {
            RestResult.FiledError filedError = new RestResult.FiledError();
            String msg = constraintViolation.getMessage();
            String propertyPath = constraintViolation.getPropertyPath().toString();
            filedError.setErrorMsg(msg);
            filedError.setFiledName(propertyPath);
            filedError.setObjectName(constraintViolation.getRootBeanClass().getSimpleName());
            collection.add(filedError);
        }
        throw new ArgumentNotValidException(collection);
    }
}
