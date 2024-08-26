package com.example.implementation;

import com.example.interfaces.Speakers;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("BoseSpeakers")
public class BoseSpeakers implements Speakers {

    public String makeSound(){
        return "Playing music with Bose speakers";
    }

}
