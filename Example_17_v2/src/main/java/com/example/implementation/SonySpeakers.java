package com.example.implementation;

import com.example.interfaces.Speakers;
import com.example.model.Song;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
@Primary
public class SonySpeakers implements Speakers
{
    public String makeSound(Song song)
    {
        return "Playing the song " + song.getTitle() + " by "
                + song.getSingerName() +
                " with Sony speakers";
    }
}
