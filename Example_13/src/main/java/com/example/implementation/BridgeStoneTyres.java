package com.example.implementation;

import com.example.interfaces.Tyres;
import org.springframework.stereotype.Component;

@Component("BridgeStoneTyres")
public class BridgeStoneTyres implements Tyres
{

    public String rotate()
    {
        return "Vehicle moving with BridgeStone tyres";
    }
}
