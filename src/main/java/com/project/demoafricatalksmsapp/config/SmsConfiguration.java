package com.project.demoafricatalksmsapp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("africastalking")
@Data
public class SmsConfiguration {
    private String username;
    private String apiKey;

    public SmsConfiguration() {
    }
}