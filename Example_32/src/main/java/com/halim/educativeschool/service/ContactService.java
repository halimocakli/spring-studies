package com.halim.educativeschool.service;

import com.halim.educativeschool.constants.EducativeSchoolConstants;
import com.halim.educativeschool.model.Contact;
import com.halim.educativeschool.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ContactService
{
    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository)
    {
        this.contactRepository = contactRepository;
    }

    // Save Contact Details into DB
    public boolean saveMessageDetails(Contact contact)
    {
        boolean isSaved = false;

        contact.setStatus(EducativeSchoolConstants.OPEN);
        contact.setCreatedBy(EducativeSchoolConstants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());

        int result = contactRepository.saveContactMessage(contact);
        if (result > 0)
        {
            isSaved = true;
        }
        return isSaved;
    }

    public List<Contact> findMessagesWithOpenStatus()
    {
        List<Contact> contactMessages = contactRepository.findMessagesWithStatus(EducativeSchoolConstants.OPEN);
        return contactMessages;
    }

    public boolean updateMessageStatus(int contactId, String updatedBy)
    {
        boolean isUpdated = false;
        int result = contactRepository.updateMessageStatus(contactId, EducativeSchoolConstants.CLOSE, updatedBy);
        if (result > 0)
        {
            isUpdated = true;
        }
        return isUpdated;
    }
}
