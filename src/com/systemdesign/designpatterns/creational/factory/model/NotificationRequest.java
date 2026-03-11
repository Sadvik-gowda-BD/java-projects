package com.systemdesign.designpatterns.creational.factory.model;

public class NotificationRequest {

    private String from;
    private String to;
    private String message;

    public NotificationRequest(String from, String to, String message) {
        this.from = from;
        this.to = to;
        this.message = message;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getMessage() {
        return message;
    }
}
