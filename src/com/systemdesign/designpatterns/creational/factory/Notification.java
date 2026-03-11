package com.systemdesign.designpatterns.creational.factory;

import com.systemdesign.designpatterns.creational.factory.model.NotificationRequest;

public interface Notification {
    void send(NotificationRequest request);
}
