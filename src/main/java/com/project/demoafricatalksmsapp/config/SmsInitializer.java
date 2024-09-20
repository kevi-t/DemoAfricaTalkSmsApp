package com.project.demoafricatalksmsapp.config;

import com.africastalking.AfricasTalking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SmsInitializer {

    private final static Logger LOGGER = LoggerFactory.getLogger(SmsInitializer.class);

    @Autowired
    public SmsInitializer(SmsConfiguration smsConfiguration) {
        AfricasTalking.initialize(smsConfiguration.getUsername(), smsConfiguration.getApiKey());
        LOGGER.info("Africa's Talking initialized with API Key: {}", smsConfiguration.getApiKey());
    }
}