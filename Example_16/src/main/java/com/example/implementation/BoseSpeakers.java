package com.example.implementation;

import com.example.interfaces.Speakers;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class BoseSpeakers implements Speakers
{

    public String makeSound()
    {
        return "Playing music with Bose speakers";
    }
}
