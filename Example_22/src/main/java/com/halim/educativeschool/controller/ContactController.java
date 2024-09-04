package com.halim.educativeschool.controller;

import com.halim.educativeschool.model.Contact;
import com.halim.educativeschool.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

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
    public String displayContactPage()
    {
        return "contact.html";
    }

    // private static Logger log = Logger.getLogger(ContactController.class.getName());

    // @RequestParam anotasyonu, UI uzerindeki bilgi ile backend server arasinda baglanti kurar.
    // Anotasyonun aldigi parametreler ile UI uzerinden bilgi gonderen deger isimlerinin ayni olmasi gerekiyor.
    //    @RequestMapping(value = "/saveMsg", method = POST)
    //    public ModelAndView saveMessage(@RequestParam String name, @RequestParam String mobileNum,
    //                                    @RequestParam String email, @RequestParam String subject, @RequestParam String message)
    //    {
    //        log.info("Name : " + name);
    //        log.info("Mobile Number : " + mobileNum);
    //        log.info("Email Address : " + email);
    //        log.info("Subject : " + subject);
    //        log.info("Message : " + message);
    //        return new ModelAndView("redirect:/contact");
    //    }

    @RequestMapping(value = "/saveMsg", method = POST)
    public ModelAndView saveMessage(Contact contact)
    {
        contactService.saveMessageDetails(contact);
        return new ModelAndView("redirect:/contact");
    }
}
