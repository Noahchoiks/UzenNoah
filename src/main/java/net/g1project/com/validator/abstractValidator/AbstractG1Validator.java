package net.g1project.com.validator.abstractValidator;

import java.beans.PropertyEditor;
import java.lang.reflect.Field;
import java.util.Map;

import net.g1project.com.constants.G1ValidationConstants;
import net.g1project.com.utils.ValidationUtils;
import net.g1project.com.vo.ValidateInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public abstract class AbstractG1Validator implements Validator {

	@Autowired
	private ValidationUtils validationUtils;

	private boolean useAddValidate;

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {
		defaultValidate(target, errors);
		if (useAddValidate) {
			addValidate(target, errors);
		}
	}

	private void defaultValidate(Object target, Errors errors) {
		Map<String, Object> validationMap = validationUtils
				.getValidateResultMap(target.getClass());
		for (String key : validationMap.keySet()) {
			ValidateInfoVO valiInfoVO = (ValidateInfoVO) validationMap.get(key);
			try {
				Field targetField = target.getClass().getDeclaredField(key);
				targetField.setAccessible(true);
				PropertyEditor propertyEditor = G1ValidationConstants.DEFAULT_EDITORS.get(targetField.getType());
				propertyEditor.setValue(targetField.get(target));
				System.out.println("==========================================");
				System.out.println("valiInfoVO.toString() : "+valiInfoVO.toString());
				System.out.println("propertyEditor.getAsText() : "+propertyEditor.getAsText());
				System.out.println("==========================================");
				
				
				
				
				
				
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}

		}
	}

	protected abstract void addValidate(Object target, Errors errors);

	public boolean isUseAddValidate() {
		return useAddValidate;
	}

	public void setUseAddValidate(boolean useAddValidate) {
		this.useAddValidate = useAddValidate;
	}


}
