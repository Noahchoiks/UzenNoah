package net.noah.com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "net.noah.com")
public class ApplicationConfigurerAdapter extends WebMvcConfigurerAdapter {
    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    // @Bean
    // public InternalResourceViewResolver viewResolver() {
    // InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    // resolver.setViewClass(JstlView.class);
    // resolver.setPrefix("/WEB-INF/views/layout/");
    // resolver.setSuffix(".jsp");
    // return resolver;
    // }
    //
    // @Override
    // public void addResourceHandlers(ResourceHandlerRegistry registry) {
    // registry.addResourceHandler("/static/**")
    // .addResourceLocations("/static/");
    // }
    //
    // @Override
    // public void addInterceptors(InterceptorRegistry registry) {
    // super.addInterceptors(registry);
    // }

}
