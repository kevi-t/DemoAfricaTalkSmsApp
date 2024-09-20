package com.project.demoafricatalksmsapp.service;

import com.africastalking.AfricasTalking;
import com.africastalking.SmsService;
import com.africastalking.sms.Recipient;
import com.project.demoafricatalksmsapp.config.SmsConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("africastalking")
public class AtSmsSender implements SmsSender {
    private static final Logger LOGGER = LoggerFactory.getLogger(AtSmsSender.class);
    private final SmsConfiguration smsConfiguration;

    @Autowired
    public AtSmsSender(SmsConfiguration smsConfiguration) {
        this.smsConfiguration = smsConfiguration;
    }

    @Override
    public void sendSms(SmsRequest smsRequest) {
        if (isPhoneNumberValid(smsRequest.getRecipients())) {
            try {
                String from = "Ecommerce_api";
                String message = smsRequest.getMessage();
                String[] recipients = smsRequest.getRecipients();

                SmsService sms = AfricasTalking.getService(AfricasTalking.SERVICE_SMS);
                List<Recipient> response = sms.send(message, from, recipients, true);

                for (Recipient recipient : response) {
                    System.out.println(recipient.number + " : " + recipient.status);
                }

                LOGGER.info("SMS sent: {}", smsRequest);
            } catch (Exception ex) {
                LOGGER.error("Error sending SMS", ex);
            }
        } else {
            LOGGER.warn("Invalid phone numbers");
        }
    }

    private boolean isPhoneNumberValid(String[] recipients) {
        // Implement your phone number validation logic here
        return true;
    }
}