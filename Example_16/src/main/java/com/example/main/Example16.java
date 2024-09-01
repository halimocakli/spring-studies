package com.example.main;

import com.example.config.ProjectConfig;
import com.example.services.VehicleServices;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example16
{

    public static void main(String[] args)
    {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        VehicleServices vehicleServices1 = context.getBean(VehicleServices.class);
        VehicleServices vehicleServices2 = context.getBean("vehicleServices", VehicleServices.class);

        System.out.println("\n");

        System.out.println("Hashcode of the object vehicleServices1 : " + vehicleServices1.hashCode());
        System.out.println("Hashcode of the object vehicleServices2 : " + vehicleServices2.hashCode());

        System.out.println("\n");

        // Her ne kadar VehicleServices bean'inin Scope değeri Prototype olsa da, bağımlı olduğu bean'lerin
        // scope değeri Singleton olduğu için VehicleServices bean'i içerisindeki bağımlı olunan bean'ler
        // Singleton davranışı gösterir. Aşağıdaki uygulama çıktısı bu duruma ispat niteliğindedir.

        System.out.println("Hashcode of the object vehicleServices1's Speakers : " + vehicleServices1.getSpeakers().hashCode());
        System.out.println("Hashcode of the object vehicleServices1's Tyres : " + vehicleServices1.getTyres().hashCode());

        System.out.println("\n");

        System.out.println("Hashcode of the object vehicleServices2's Speakers : " + vehicleServices2.getSpeakers().hashCode());
        System.out.println("Hashcode of the object vehicleServices2's Tyres : " + vehicleServices2.getTyres().hashCode());

        System.out.println("\n");

        if (vehicleServices1 == vehicleServices2)
        {
            System.out.println("VehicleServices bean is a singleton scoped bean");
        }
        else
        {
            System.out.println("VehicleServices bean is a prototype scoped bean");
        }
    }
}
