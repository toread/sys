package com.toread.sys.common.validate;

import com.toread.sys.common.mvc.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * @author 黎志兵
 */
@Component
public class Valid {
    @Autowired
    private Validator validator;

    public <T> void valid(T object,Class<?>... groups){
        Set<ConstraintViolation<T>> constraintViolations =  validator.validate(object,groups);
        if(CollectionUtils.isEmpty(constraintViolations)){return;}
        createFiledError(constraintViolations);
    }

    public <T> void validateProperty(T object,String propertyName,Class<?>... groups){
        Set<ConstraintViolation<T>> constraintViolations =  validator.validateProperty(object,propertyName,groups);
        if(CollectionUtils.isEmpty(constraintViolations)){return;}
        createFiledError(constraintViolations);
    }

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
        throw  new ArgumentNotValidException(collection);
    }


}
