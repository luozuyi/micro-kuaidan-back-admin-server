package com.kuaidan.intercetpor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Bean
    public HandlerInterceptor getTokenInterceptor(){
        return new TokenInterceptor();
    }
    @Bean
    public HandlerInterceptor getLogoutInterceptor(){
        return new LogoutInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getTokenInterceptor()).addPathPatterns("/**/auth/**");
        registry.addInterceptor(getLogoutInterceptor()).addPathPatterns("/**/admins/logout");
    }


}