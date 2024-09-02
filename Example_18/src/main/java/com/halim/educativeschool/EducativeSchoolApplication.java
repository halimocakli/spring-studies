package com.halim.educativeschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@SpringBootApplication
public class EducativeSchoolApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(EducativeSchoolApplication.class, args);
    }

}
