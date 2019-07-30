package com.jmx.agent;

import com.jmx.broadcaster.HelloBroadcaster;
import com.jmx.handler.HelloHandler;
import com.jmx.listener.HelloListener;
import com.jmx.mbean.Person;
import com.sun.jdmk.comm.HtmlAdaptorServer;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class MainAgent {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

        Person person = new Person();
        ObjectName personName = new ObjectName("jmxPerson:name=person");
        mBeanServer.registerMBean(person, personName);

        // 广播类
        HelloBroadcaster broadcaster = new HelloBroadcaster();
        broadcaster.addNotificationListener(new HelloListener(), null, new HelloHandler());

        // 注册sayHello
        ObjectName helloName = new ObjectName("jmxSayHello:name=sayHello");
        mBeanServer.registerMBean(broadcaster, helloName);

        // 监听UI
        ObjectName adapterName = new ObjectName("helloAgent:name=htmladapter,port=8082");
        HtmlAdaptorServer adaptor = new HtmlAdaptorServer();
        mBeanServer.registerMBean(adaptor, adapterName);
        adaptor.start();
    }
}
