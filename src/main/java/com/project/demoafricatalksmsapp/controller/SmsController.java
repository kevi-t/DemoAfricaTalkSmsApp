package com.project.demoafricatalksmsapp.controller;

import com.project.demoafricatalksmsapp.service.AtSmsService;
import com.project.demoafricatalksmsapp.service.SmsDTO;
import com.project.demoafricatalksmsapp.service.SmsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/sms")
@Validated
public class SmsController {
    private final AtSmsService atSmsService;

    @Autowired
    public SmsController(AtSmsService atSmsService) {
        this.atSmsService = atSmsService;
    }

    @PostMapping("/send")
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {
        atSmsService.sendSms(smsRequest);
    }

    @PostMapping("/incoming-messages")
    public String receiveSms(
            @RequestParam("from") String from,
            @RequestParam("to") String to,
            @RequestParam("text") String text,
            @RequestParam("date") String date,
            @RequestParam("id") String id
    ) {
        // Process the incoming SMS message
        System.out.println("Received SMS from: " + from);
        System.out.println("To: " + to);
        System.out.println("Message: " + text);
        System.out.println("Received on: " + date);
        System.out.println("Message ID: " + id);

        // Optional: Save message to the database or perform other actions

        // Respond with "OK" to acknowledge receipt
        return "OK";
    }
}