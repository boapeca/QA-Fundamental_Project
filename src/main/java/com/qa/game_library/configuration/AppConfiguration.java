package com.qa.game_library.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@EnableWebMvc
public class AppConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler( "/js/**")
                .addResourceLocations("classpath:/static/js/");
    }

}