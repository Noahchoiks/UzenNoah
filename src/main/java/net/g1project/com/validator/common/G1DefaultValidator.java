package net.g1project.com.validator.common;

import net.g1project.com.vo.ValidateInfoVO;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class G1DefaultValidator implements Validator {

	private String targetFieldName;
	private ValidateInfoVO validateInfo;
	
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {

	}

}
