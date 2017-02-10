package com.toread.sys.common.validator.constraintvalidators;

import com.toread.sys.common.enums.State;
import com.toread.sys.common.validator.constraints.ValidState;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author 黎志兵
 */
public class ValidStateValidator implements ConstraintValidator<ValidState, Integer> {
    private ValidState validState;

    @Override
    public void initialize(ValidState constraintAnnotation) {
        this.validState = constraintAnnotation;
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return State.getState(value) != null;
    }

}
