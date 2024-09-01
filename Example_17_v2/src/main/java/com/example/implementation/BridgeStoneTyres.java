package com.example.implementation;

import com.example.interfaces.Tyres;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class BridgeStoneTyres implements Tyres
{
    @Override
    public String rotate()
    {
        return "Vehicle moving with the help of BridgeStone tyres";
    }

    @Override
    public String stop()
    {
        return "Vehicle stopped with the help of BridgeStone tyres";
    }
}
