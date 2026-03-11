package com.systemdesign.designpatterns.creational.factory.impl;

import com.systemdesign.designpatterns.creational.factory.Notification;
import com.systemdesign.designpatterns.creational.factory.model.NotificationRequest;

public class SmsNotification implements Notification {

    @Override
    public void send(NotificationRequest request) {

        System.out.println("TODO: validate mobile number and do sms related work");
        System.out.println(
                "Sending SMS from " + request.getFrom() +
                        " to " + request.getTo() +
                        " message: " + request.getMessage()
        );
    }
}