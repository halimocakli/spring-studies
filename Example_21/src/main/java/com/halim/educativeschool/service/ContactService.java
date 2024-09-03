package com.halim.educativeschool.service;

import com.halim.educativeschool.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ContactService
{
    // Save Contact Details into DB DEMO
    public boolean saveMessageDetails(Contact contact)
    {
        boolean isSaved = true;
        //TODO - Need to persist the data into the DB table
        log.info(contact.toString());
        return isSaved;
    }
}
