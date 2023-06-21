package com.ues21.fundacionsoles.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class StaticResourceConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/web/flow/css/**")
                .addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/web/flow/js/**")
                .addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("/web/flow/assets/**")
                .addResourceLocations("classpath:/static/assets/");
    }
}