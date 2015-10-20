package net.g1project.com.validator.abstractValidator;

import java.beans.PropertyEditor;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.regex.Pattern;

import net.g1project.com.constants.G1ValidationConstants;
import net.g1project.com.utils.ValidationUtils;
import net.g1project.com.vo.ValidateInfoVO;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public abstract class AbstractG1Validator implements Validator {

	@Autowired
	private ValidationUtils validationUtils;

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {
		defaultValidate(target, errors);
		addValidate(target, errors);
	}

	private void defaultValidate(Object target, Errors errors) {
		Map<String, Object> validationMap = validationUtils.getValidateResultMap(target.getClass());
		for (String key : validationMap.keySet()) {
			ValidateInfoVO validInfoVO = (ValidateInfoVO) validationMap.get(key);
			try {
				Field targetField = target.getClass().getDeclaredField(key);
				targetField.setAccessible(true);
				PropertyEditor propertyEditor = G1ValidationConstants.DEFAULT_EDITORS
						.get(targetField.getType());
				propertyEditor.setValue(targetField.get(target));

				// Default Validate 
				if (StringUtils.isNotEmpty(validInfoVO.getPattern())) {
					Pattern pattern = Pattern.compile(validInfoVO.getPattern());
					if (!pattern.matcher(propertyEditor.getAsText()).matches()) {
						errors.rejectValue(key, null,
								validInfoVO.getPatternMessage());
					}
				}

				if (validInfoVO.isRequired()) {
					if (StringUtils.isEmpty(propertyEditor.getAsText())) {
						org.springframework.validation.ValidationUtils
								.rejectIfEmpty(errors, key, null,
										validInfoVO.getRequiredMessage());
					}
				}

				if (validInfoVO.getMaxLength() != 0) {
					if (propertyEditor.getAsText().length() > validInfoVO.getMaxLength()) {
						errors.rejectValue(key, null,
								validInfoVO.getMaxLengthMessage());
					}
				}

				if (validInfoVO.getMinLength() != 0) {
					if (propertyEditor.getAsText().length() < validInfoVO.getMinLength()) {
						errors.rejectValue(key, null,
								validInfoVO.getMinLengthMessage());
					}
				}

			} catch (NoSuchFieldException | SecurityException
					| IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	public abstract void addValidate(Object target, Errors errors);
}
