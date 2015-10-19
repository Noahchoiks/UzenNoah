package net.g1project.com.validator.abstractValidator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public interface G1Validator extends Validator{

	abstract void addValidate(Object target, Errors errors);
}
