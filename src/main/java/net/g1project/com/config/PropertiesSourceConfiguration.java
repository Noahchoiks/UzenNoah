package net.g1project.com.config;

import net.g1project.com.utils.ValidationUtils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class PropertiesSourceConfiguration {
	
	@Bean
	public ValidationUtils validationUtils(){
		ValidationUtils validationUtils = new ValidationUtils();
		validationUtils.setMessageSource(validationSource());		
		return validationUtils;	
	}
	
    @Bean
    public ReloadableResourceBundleMessageSource validationSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(60);
        messageSource.setBasename("classpath:validation/validation");
        return messageSource;
    }
}
