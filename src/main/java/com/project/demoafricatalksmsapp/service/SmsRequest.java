package com.project.demoafricatalksmsapp.service;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@Data
@NoArgsConstructor
public class SmsRequest {

    private String message;
    private String[] recipients;

    public SmsRequest(String message, String[] recipients) {
        this.message = message;
        this.recipients = recipients;
    }

    @Override
    public String toString() {
        return "SmsRequest [message=" + message + ", recipients=" + Arrays.toString(recipients) + "]";
    }
}