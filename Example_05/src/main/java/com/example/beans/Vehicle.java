package com.example.beans;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Component
public class Vehicle
{
    private String name;
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void printHello()
    {
        System.out.println(
                "Printing Hello from Component Vehicle Bean");
    }
}
