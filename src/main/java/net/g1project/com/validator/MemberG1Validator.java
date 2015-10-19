package net.g1project.com.validator;

import net.g1project.com.validator.abstractValidator.AbstractG1Validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class MemberG1Validator extends AbstractG1Validator {
	
	@Override
	protected void addValidate(Object target, Errors errors) {
		System.out.println("Add Validator");
	}
}
