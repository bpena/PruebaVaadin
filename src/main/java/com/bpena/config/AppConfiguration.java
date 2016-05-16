package com.bpena.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Bernardo on 14/5/2016.
 */
@Configuration
@ComponentScan(basePackages = "com.bpena")
public class AppConfiguration {
    @Bean
    public VaadinUIProvider vaadinProvider() {
        return new VaadinUIProvider();
    }
}
