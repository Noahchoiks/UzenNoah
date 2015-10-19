package net.g1project.com.validator.common;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class G1MaxLengthValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub

	}

}
