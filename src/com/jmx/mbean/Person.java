package com.jmx.mbean;


public class Person implements PersonMBean {

    private String name = "initName";

    private String age = "initAge";

    public String getName() {
        System.out.println("get name : " + name);
        return name;
    }

    public void setName(String name) {
        System.out.println("set name : " + name);
        this.name = name;
    }

    public String getAge() {
        System.out.println("get age : " + age);
        return age;
    }

    public void setAge(String age) {
        System.out.println("set age : " + age);
        this.age = age;
    }

}
