package com.jmx.broadcaster;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class HelloBroadcaster extends NotificationBroadcasterSupport implements HelloBroadcasterMBean {

    private int seq = 0;

    @Override
    public void sayHello() {
        //通知名称；谁发起的通知；序列号；发起通知时间；发送的消息
        Notification notification = new Notification("sayHello", "hanh", ++seq,
                System.currentTimeMillis(), "hello,everyone!");
        sendNotification(notification);
    }
}
