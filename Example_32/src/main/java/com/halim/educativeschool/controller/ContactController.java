package com.halim.educativeschool.controller;

import com.halim.educativeschool.model.Contact;
import com.halim.educativeschool.service.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Slf4j
@Controller
public class ContactController
{
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService)
    {
        this.contactService = contactService;
    }

    @RequestMapping("/contact")
    public String displayContactPage(Model model)
    {
        model.addAttribute("contact", new Contact());
        return "contact.html";
    }

    @PostMapping(value = "/saveMessage")
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors)
    {
        if (errors.hasErrors())
        {
            log.error("Contact form validation failed due to : {}", errors.toString());
            return "contact.html";
        }
        contactService.saveMessageDetails(contact);
        return "redirect:/contact";
    }

    @RequestMapping("/displayMessages")
    public ModelAndView displayMessages(Model model)
    {
        List<Contact> contactMessages = contactService.findMessagesWithOpenStatus();
        ModelAndView modelAndView = new ModelAndView("messages.html");
        modelAndView.addObject("contactMessages", contactMessages);

        return modelAndView;
    }

    @RequestMapping(value = "/closeMessage", method = GET)
    public String closeMessage(@RequestParam int id, Authentication authentication)
    {
        contactService.updateMessageStatus(id, authentication.getName());
        return "redirect:/displayMessages";
    }

}
