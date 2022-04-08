package com.topekox.spring.belajar.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeContraintValidator implements ConstraintValidator<CourseCode, String> {

	private String coursePrefix;

	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext context) {

		boolean result;

		if (theCode != null) {

			result = theCode.startsWith(coursePrefix);

		} else {
			result = true;
		}
		return result;
	}

	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();
	}

}
