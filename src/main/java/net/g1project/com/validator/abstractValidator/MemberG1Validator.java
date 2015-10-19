package net.g1project.com.validator.abstractValidator;

import org.springframework.validation.Errors;

public class MemberG1Validator extends AbstractG1Validator {

	@Override
	void addValidate(Object target, Errors errors) {
		System.out.println("Add Validator");
	}

}
