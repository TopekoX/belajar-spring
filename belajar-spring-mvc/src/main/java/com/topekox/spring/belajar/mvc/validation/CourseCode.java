package com.topekox.spring.belajar.mvc.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeContraintValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface CourseCode {

	// define default course code
	public String value() default "TOP";
	
	// define default error message
	public String message() default "must start with TOP";
	
	// define default group
	public Class<?>[] groups() default {};
	
	// define default payload
	public Class<? extends Payload>[] payload() default{};
}
