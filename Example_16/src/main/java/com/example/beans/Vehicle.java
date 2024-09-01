package com.example.beans;

import com.example.services.VehicleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("vehicleBean")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class Vehicle
{

    private final VehicleServices vehicleServices;
    private String name = "Honda";

    @Autowired
    public Vehicle(VehicleServices vehicleServices)
    {
        this.vehicleServices = vehicleServices;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public VehicleServices getVehicleServices()
    {
        return vehicleServices;
    }

    public void printHello()
    {
        System.out.println(
                "Printing Hello from Component Vehicle Bean");
    }

    @Override
    public String toString()
    {
        return "Vehicle name is - " + name;
    }
}
