package com.example.demo.controller;

import com.example.demo.dao.*;
import com.example.demo.exceptions.ContactNotFoundException;
import com.example.demo.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static javax.swing.UIManager.getInt;

@RestController
@RequestMapping/*("/contact/{id}")*/
public class ContactController {

    @Autowired
    private ContactService contactService;

    @Autowired
    private ContactsDAOService contactsDAOService;

    @Autowired
    public MobPhoneDAOService mobPhoneDAOService;

    @Autowired
    public EmailDAOService emailDAOService;

    @Autowired
    public AddressDAOService addressDAOService;

    @GetMapping
    public Contact getContact (@PathVariable Long id) {
        /*List<Contact> contacts = contactsDAOService.getAllContactByContactId(id);
        model.addAttribute("contacts", contacts);*/
        try {
            return contactsDAOService.getContactById(id);
            //model.addAttribute("contact", contact);
        } catch (ContactNotFoundException e) {
            //model.addAttribute("message", e.getMessage());
            return null;
        }
        /*model.addAttribute(mobPhoneDAOService.getAllMobPhonesByContactId(id));
        model.addAllAttributes(emailDAOService.getAllEmailByContactId(id));
        model.addAllAttributes(addressDAOService.getAllAddressByContactId(id));*/
        //return contact;
    }

    @DeleteMapping
    public void deleteContact(@PathVariable Long id) {
        contactsDAOService.deleteContactById(id);
    }

    /*@PutMapping
    public void addContact(Contact contact) {
        contactsDAOService.addContact(contact);
    }*/

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createContact(@RequestBody Contact contact) {

            contactService.createContact(
                contact.getFirstName(),
                contact.getName(),
                contact.getEmail()
        );
    }

}
