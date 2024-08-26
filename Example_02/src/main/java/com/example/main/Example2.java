package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example2
{

    public static void main(String[] args)
    {

        /*
        The var keyword was introduced in Java 10. Type inference is used in
        var keyword in which it detects automatically the datatype of a variable
        based on the surrounding context.
        * */
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        // Vehicle veh = context.getBean(Vehicle.class);
        Vehicle vehicle1 = context.getBean("vehicle1", Vehicle.class);
        System.out.println("Vehicle1 name from Spring Context is: " + vehicle1.getName());

        Vehicle vehicle2 = context.getBean("vehicle2", Vehicle.class);
        System.out.println("Vehicle2 name from Spring Context is: " + vehicle2.getName());

        Vehicle vehicle3 = context.getBean("vehicle3", Vehicle.class);
        System.out.println("Vehicle3 name from Spring Context is: " + vehicle3.getName());
    }
}
