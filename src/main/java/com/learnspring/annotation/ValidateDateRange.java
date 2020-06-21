package com.learnspring.annotation;

import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;

@Constraint(validatedBy = DateRangeValidator.class)
@Target({ ElementType.METHOD, ElementType.CONSTRUCTOR })
@Retention(RUNTIME)
@Documented
public @interface ValidateDateRange {
	String message() default "invalid date range";
	
	long maxRange() default 7L;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
    

}
