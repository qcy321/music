package com.mu.config;

import com.mu.intercepter.CORSInterceptor;
import com.mu.intercepter.ResponseResultInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 注册拦截器
 */
@Component
public class RegisterInterceptorConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CORSInterceptor());
       // registry.addInterceptor(new ResponseResultInterceptor());
    }
}
