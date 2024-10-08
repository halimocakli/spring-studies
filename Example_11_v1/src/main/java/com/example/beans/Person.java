package com.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person
{

    private String name = "Lucy";

    @Autowired
    private Vehicle vehicle;

    // Aşağıdaki ifade ile olası bir NoSuchBeanDefinition hatasının önüne geçmiş oluyoruz
//    @Autowired(required = false)
//    private Vehicle vehicle;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Vehicle getVehicle()
    {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle)
    {
        this.vehicle = vehicle;
    }

}
