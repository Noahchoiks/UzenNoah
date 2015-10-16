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
	
	
	public ResponseEntity<Map<String, Object>> getValidDataToResponseEntity(String voName) {
		return new ResponseEntity<Map<String, Object>>(getValidateResultMap(voName), HttpStatus.OK);
	}

	private Map<String, Object> getValidateResultMap(String voName) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Class<?> clazz = getVOClazz(voName);
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			resultMap.put(field.getName(),
					getValiInfoVO(voName, field.getName()));
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
		if (StringUtils.isNotEmpty(value)) {
			switch (status) {
			case PATTERN:
				validateInfoVO.setPattern(value);
				break;
			case MAX_LENGTH:
				validateInfoVO.setMaxLength(Integer.valueOf(value));
				break;
			case MIN_LENGTH:
				validateInfoVO.setMinLength(Integer.valueOf(value));
				break;
			case MESSAGE:
				validateInfoVO.setMessage(value);
				break;
			case REQUIRED:
				validateInfoVO.setRequired(Boolean.valueOf(value));
				break;
			default:
				// ignore
				break;
			}
		}
	}

	private Class<?> getVOClazz(String voName) {
		try {
			return Class.forName(G1ValidationConstants.V_VO_PACKAGE
					+ G1ValidationConstants.V_DEPTH_SEPARATOR + voName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
