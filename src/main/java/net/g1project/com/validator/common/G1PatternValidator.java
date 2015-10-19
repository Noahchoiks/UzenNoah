package net.g1project.com.validator.common;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class G1PatternValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		
		

	}

}
