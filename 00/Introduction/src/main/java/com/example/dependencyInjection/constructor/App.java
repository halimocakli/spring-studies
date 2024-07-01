package com.example.dependencyInjection.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationConstructorInjection.xml");

        Car carInstance = (Car) context.getBean("myCar");
        carInstance.displayDetails();
    }
}
