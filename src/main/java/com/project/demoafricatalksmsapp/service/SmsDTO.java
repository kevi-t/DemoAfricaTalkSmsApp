package com.project.demoafricatalksmsapp.service;

import lombok.Data;

@Data
public class SmsDTO {
    private String from;
    private String to;
    private String text;
    private String date;
    private String id;
}