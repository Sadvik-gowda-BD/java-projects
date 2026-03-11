package com.systemdesign.designpatterns.creational.factory.impl;

import com.systemdesign.designpatterns.creational.factory.Notification;
import com.systemdesign.designpatterns.creational.factory.model.NotificationRequest;

public class EmailNotification implements Notification {

    @Override
    public void send(NotificationRequest request) {

        System.out.println("TODO: validate email and do email related work");
        System.out.println(
                "Sending EMAIL from " + request.getFrom() +
                        " to " + request.getTo() +
                        " message: " + request.getMessage()
        );
    }
}