package net.g1project.com.utils;

import java.util.Locale;

import org.springframework.context.MessageSource;

public class ValidationUtils {

	public static final String VALIDATION_MESSAGE_KEY_SUFFIX = ".message";
	
	private MessageSource messageSource;

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public String getValidationRegex(String key, Object[] args) {
		return getPropertyValue(null, key, args);
	}
	
	public String getValidationMessage(String key, Object[] args) {
		key = key + VALIDATION_MESSAGE_KEY_SUFFIX;
		return getPropertyValue(null, key, args);
	}

	public String getPropertyValue(Locale locale, String key, Object[] args) {
		String value = null;
		try {
			value = this.messageSource.getMessage(key, args, locale);
		} catch (Exception e) {
			value = String.format("??%s??", new Object[] { key });
		}
		return value;
	}
}
