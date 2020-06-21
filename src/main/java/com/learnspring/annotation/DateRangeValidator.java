package com.learnspring.annotation;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

import lombok.extern.slf4j.Slf4j;

import static java.time.temporal.ChronoUnit.DAYS;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
@Slf4j
public class DateRangeValidator implements ConstraintValidator<ValidateDateRange, Object[]> {

	private long maxRange;
	@Override
	public void initialize(ValidateDateRange constraintAnnotation) {
		log.info( constraintAnnotation.message());
		this.maxRange = constraintAnnotation.maxRange();
		
	}

	@Override
	public boolean isValid(Object[] value, ConstraintValidatorContext context) {
		boolean valid = true;
		if (value[0] == null || value[1] == null) {
            return true;
        }

        if (!(value[0] instanceof LocalDate) || !(value[1] instanceof LocalDate)) {
            throw new IllegalArgumentException("Illegal method signature, expected two parameters of type LocalDate.");
        }
        
        LocalDate startDate = (LocalDate) value[0];
        LocalDate endDate = (LocalDate) value[1];
        
        long daysBetween = DAYS.between(startDate, endDate);
        
        if( daysBetween < 0 || daysBetween > maxRange ) {
        	context.disableDefaultConstraintViolation();
        	context.buildConstraintViolationWithTemplate(String.format(
        			"date difference between startDate: %s and endDate: %s is: %d days, "
        			+ "which is out of range between %d and %d", 
        			startDate, endDate, daysBetween, 0, maxRange)).addConstraintViolation();
        	valid = false;
        }
       
        return valid;
	}

}
