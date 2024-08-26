package com.example.main;

import com.example.beans.Product;
import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example5
{

    public static void main(String[] args)
    {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Vehicle vehicle = context.getBean(Vehicle.class);
        Product product = context.getBean(Product.class);
        System.out.println("Component Vehicle name from Spring Context is: " + vehicle.getName());
        System.out.println("Component Product name from Spring Context is: " + product.getName());
        vehicle.printHello();
        product.printHello();

    }
}
