package net.noah.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class PropertiesSourceConfiguration {

    // @Bean
    // public ValidationUtils validationUtils(){
    // ValidationUtils validationUtils = new ValidationUtils();
    // validationUtils.setMessageSource(validationSource());
    // return validationUtils;
    // }

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(0);
        messageSource.setBasename("classpath:messages/message");
        return messageSource;
    }
}
