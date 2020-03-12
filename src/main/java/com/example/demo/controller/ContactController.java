package com.example.demo.controller;

import com.example.demo.dao.AddressDAOService;
import com.example.demo.dao.ContactsDAOService;
import com.example.demo.dao.EmailDAOService;
import com.example.demo.dao.MobPhoneDAOService;
import com.example.demo.exceptions.ContactNotFoundException;
import com.example.demo.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/contact/{id}")
public class ContactController {

    @Autowired
    private ContactsDAOService contactsDAOService;

    @Autowired
    public MobPhoneDAOService mobPhoneDAOService;

    @Autowired
    public EmailDAOService emailDAOService;

    @Autowired
    public AddressDAOService addressDAOService;

    @GetMapping
    public String getHtml (@PathVariable Long id, Model model) {
        /*List<Contact> contacts = contactsDAOService.getAllContactByContactId(id);
        model.addAttribute("contacts", contacts);*/
        try {
            Contact contact = contactsDAOService.getContactById(id);
            model.addAttribute("contact", contact);
        } catch (ContactNotFoundException e) {
            model.addAttribute("message", e.getMessage());
            return "error";
        }
        /*model.addAttribute(mobPhoneDAOService.getAllMobPhonesByContactId(id));
        model.addAllAttributes(emailDAOService.getAllEmailByContactId(id));
        model.addAllAttributes(addressDAOService.getAllAddressByContactId(id));*/
        return "contact";
    }
}
