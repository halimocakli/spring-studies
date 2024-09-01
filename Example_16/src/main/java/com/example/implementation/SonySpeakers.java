package com.example.implementation;

import com.example.interfaces.Speakers;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
@Primary
public class SonySpeakers implements Speakers
{

    public String makeSound()
    {
        return "Playing music with Sony speakers";
    }
}
