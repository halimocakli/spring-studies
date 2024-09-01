package com.example.implementation;

import com.example.interfaces.Tyres;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
@Primary
public class MichelinTyres implements Tyres
{

    public String rotate()
    {
        return "Vehicle moving with Michelin tyres";
    }
}
