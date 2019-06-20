package com.study.annotation;


import com.study.annotation.validator.MobileValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


/**
 * 验证手机号格式
 */
@Documented
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = {MobileValidator.class})
public @interface Mobile {

    boolean required() default true;

    String message() default "手机号格式错误";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
