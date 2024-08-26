package com.example.config;

import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * The purpose of this @Configuration annotation inside the spring framework is this will let my IOC container to scan
 * all the content of this class because this is an indication to the spring framework that the developer has done some
 * changes which will result into creating beans. So whenever my spring framework find a class with the annotation at
 * the rate configuration during the startup or during the initialization of the IOC container, it will make sure it is
 * reading all the content of this class.
 */

@Configuration
public class ProjectConfig
{
    @Bean
    Vehicle vehicle()
    {
        var vehicle = new Vehicle();
        vehicle.setName("Toyota Corolla");
        return vehicle;
    }

    @Bean
    Integer vehicles()
    {
        return 5;
    }

    @Bean("Greetings1")
    String hello()
    {
        return "Hello World";
    }

    @Bean("Greetings2")
    String hello2()
    {
        return "Hello World 2";
    }
}
