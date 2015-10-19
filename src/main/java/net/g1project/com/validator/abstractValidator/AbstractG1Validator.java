package net.g1project.com.validator.abstractValidator;

import java.util.Map;

import net.g1project.com.utils.ValidationUtils;
import net.g1project.com.vo.ValidateInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public abstract class AbstractG1Validator implements Validator{

	@Autowired
	private ValidationUtils validationUtils;

	private boolean useAddValidate;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		defaultValidate(target,errors);
		if (useAddValidate) {
			addValidate(target, errors);
		}
	}
	
	private void defaultValidate(Object target, Errors errors){
		Map<String, Object> validationMap = validationUtils.getValidateResultMap(target.getClass().getName());
		for (String key : validationMap.keySet()) {
			ValidateInfoVO valiInfoVO = (ValidateInfoVO) validationMap.get(key);
			System.out.println(valiInfoVO.toString());
		}
	}

	abstract void addValidate(Object target, Errors errors);

	public boolean isUseAddValidate() {
		return useAddValidate;
	}
	public void setUseAddValidate(boolean useAddValidate) {
		this.useAddValidate = useAddValidate;
	}
}
