package com.halim.educativeschool.service;

import com.halim.educativeschool.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Slf4j
@Service
@ApplicationScope
public class ContactService
{
    private int counter = 0;

    public ContactService()
    {
        System.out.println("Contact Service Bean has been initialized.");
    }

    public boolean saveMessageDetails(Contact contact)
    {
        boolean isSaved = true;
        log.info(contact.toString());
        return isSaved;
    }

    public int getCounter()
    {
        return counter;
    }

    public void setCounter(int counter)
    {
        this.counter = counter;
    }
}
