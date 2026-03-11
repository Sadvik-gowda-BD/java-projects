package com.systemdesign.designpatterns.creational.factory;

import com.systemdesign.designpatterns.creational.factory.impl.EmailNotification;
import com.systemdesign.designpatterns.creational.factory.impl.SmsNotification;
import com.systemdesign.designpatterns.creational.factory.model.NotificationType;

import java.util.HashMap;
import java.util.Map;

public class NotificationFactory {

    private final Map<NotificationType, Notification> notificationMap;
    private static NotificationFactory INSTANCE;

    NotificationFactory() {
        this.notificationMap = new HashMap<>();
    }

    public static NotificationFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new NotificationFactory();
        }
        return INSTANCE;
    }

    public Notification createNotification(NotificationType type) {

        if (!notificationMap.containsKey(type)) {
            if (type == NotificationType.EMAIL) {
                notificationMap.put(NotificationType.EMAIL, new EmailNotification());
            } else if (type == NotificationType.SMS) {
                notificationMap.put(NotificationType.SMS, new SmsNotification());
            } else {
                throw new IllegalArgumentException("Invalid type");
            }
        }

        return notificationMap.get(type);
    }
}
