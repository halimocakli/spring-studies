package com.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "personBean")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class Person
{

    private final Vehicle vehicle;
    private String name = "Lucy";

    @Autowired
    public Person(Vehicle vehicle)
    {
        this.vehicle = vehicle;
    }

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
}
