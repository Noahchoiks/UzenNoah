package net.g1project.com.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import net.g1project.com.constants.G1ValidationConstants;
import net.g1project.com.constants.G1ValidationConstants.Status;
import net.g1project.com.vo.ValidateInfoVO;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ValidationUtils {

	private MessageSource messageSource;

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public String getValidationProperties(String key, Object[] args) {
		return getPropertyValue(null, key, args);
	}

	public String getPropertyValue(Locale locale, String key, Object[] args) {
		String value = null;
		try {
			value = this.messageSource.getMessage(key, args, locale);
		} catch (Exception e) {
			value = "";
		}
		return value;
	}

	public ResponseEntity<Map<String, Object>> getValidDataToResponseEntity(
			Class<?> clazz) {
		return new ResponseEntity<Map<String, Object>>(
				getValidateResultMap(clazz), HttpStatus.OK);
	}

	public Map<String, Object> getValidateResultMap(Class<?> clazz) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			resultMap.put(field.getName(),getValiInfoVO(clazz.getSimpleName(), field.getName()));
		}
		return resultMap;
	}

	private ValidateInfoVO getValiInfoVO(String voName, String fieldName) {
		ValidateInfoVO validateInfoVO = new ValidateInfoVO();
		if (StringUtils.isNotEmpty(voName) && StringUtils.isNotEmpty(fieldName)) {
			StringBuilder keyBuilder;
			for (Status status : G1ValidationConstants.Status.values()) {
				keyBuilder = new StringBuilder();
				keyBuilder.append(voName);
				keyBuilder.append(G1ValidationConstants.V_DEPTH_SEPARATOR);
				keyBuilder.append(fieldName);
				keyBuilder.append(G1ValidationConstants.V_DEPTH_SEPARATOR);
				keyBuilder.append(status.getSuffix());
				setInfoDataByStatus(status, keyBuilder.toString(),
						validateInfoVO);
			}
		}
		return validateInfoVO;
	}

	private void setInfoDataByStatus(Status status, String key,
			ValidateInfoVO validateInfoVO) {

		String value = getValidationProperties(key, null);
		String valueMessage = getValidationProperties(key
				+ G1ValidationConstants.V_STATUS_MESSAGE_SUFFIX, null);
		if (StringUtils.isNotEmpty(value)) {
			switch (status) {
			case PATTERN:
				validateInfoVO.setPattern(value);
				validateInfoVO.setPatternMessage(valueMessage);
				break;
			case MAX_LENGTH:
				validateInfoVO.setMaxLength(Integer.valueOf(value));
				validateInfoVO.setMaxLengthMessage(valueMessage);
				break;
			case MIN_LENGTH:
				validateInfoVO.setMinLength(Integer.valueOf(value));
				validateInfoVO.setMinLengthMessage(valueMessage);
				break;
			case REQUIRED:
				validateInfoVO.setRequired(Boolean.valueOf(value));
				validateInfoVO.setRequiredMessage(valueMessage);
				break;
			default:
				// ignore
				break;
			}
		}
	}
}
