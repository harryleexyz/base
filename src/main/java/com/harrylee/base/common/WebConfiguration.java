package com.harrylee.base.common;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author harrylee
 */
@Configuration
public class WebConfiguration {

    @Bean
    public FilterRegistrationBean filterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new UserFilter());
        registration.addUrlPatterns("/api/user/*");
        registration.setName("UserFilter");
        registration.setOrder(1);
        return registration;
    }
}
