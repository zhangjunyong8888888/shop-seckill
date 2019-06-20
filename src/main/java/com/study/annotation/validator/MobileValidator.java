package com.study.annotation.validator;


import com.study.annotation.Mobile;
import com.study.utils.ValidatorUtil;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class MobileValidator implements ConstraintValidator<Mobile,String> {

    private boolean required;


    @Override
    public void initialize(Mobile constraintAnnotation) {
        this.required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(required || StringUtils.isNotBlank(value)){
            return ValidatorUtil.isMobile(value);
        }
        return true;
    }
}
