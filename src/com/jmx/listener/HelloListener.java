package com.jmx.listener;

import com.jmx.handler.HelloHandler;

import javax.management.Notification;
import javax.management.NotificationListener;

public class HelloListener implements NotificationListener {
    @Override
    public void handleNotification(Notification notification, Object handback) {
        if (handback instanceof HelloHandler) {
            HelloHandler handler = (HelloHandler) handback;
            handler.printMessage(notification.getMessage());
        }
    }
}
