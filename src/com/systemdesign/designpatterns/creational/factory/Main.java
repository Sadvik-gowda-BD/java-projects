package com.systemdesign.designpatterns.creational.factory;

import com.systemdesign.designpatterns.creational.factory.model.NotificationRequest;
import com.systemdesign.designpatterns.creational.factory.model.NotificationType;

public class Main {

    //The design we wrote actually uses Factory + Singleton + Strategy pattern together, which is very common in real
    // systems.
    public static void main(String[] args) {

        //Here we are not exposing object creation directly
        Notification emailNotification =
                NotificationFactory.getInstance().createNotification(NotificationType.EMAIL);
        Notification smsNotification =
                NotificationFactory.getInstance().createNotification(NotificationType.SMS);

        NotificationRequest request = new NotificationRequest("support@company.com", "user@gmail.com",
                "Your order has been delivered");

        emailNotification.send(request);

        NotificationRequest smsRequest = new NotificationRequest("1234", "1234",
                "Your order has been delivered");
        smsNotification.send(smsRequest);
    }
}