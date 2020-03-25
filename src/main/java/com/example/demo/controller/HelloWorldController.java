package com.example.demo.controller;

import com.example.demo.dao.ContactsDAOService;
import com.example.demo.dao.EmailDAOService;
import com.example.demo.dao.MobPhoneDAOService;
import com.example.demo.dao.mapper.MobPhoneMapper;
import com.example.demo.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/contacts111")
public class HelloWorldController {

    @Autowired
    private ContactsDAOService contactsDAOService;

    @Autowired
    private MobPhoneDAOService mobPhoneDAOService;

    @Autowired
    private EmailDAOService emailDAOService;

    @GetMapping
    public String getHtml(Model model) {
        List<Contact> contacts = contactsDAOService.getAllContacts();
        model.addAttribute("contacts", contacts);
        /*System.out.println(id);*/

        /*model.addAttribute("phones", mobPhoneDAOService.getAllMobPhonesByContactId(id));*/
        /*model.addAttribute("email", emailDAOService.getAllEmail());*/

        return "contacts";
    }


    /*@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addContact(@RequestBody Contact contact) {
        contactsDAOService.addContact(
                contact.getFirstName(),
                contact.getName(),
                contact.getEmail()
        );
    }*/
    /*@PutMapping
    public void addContact(Contact contact){
        contactsDAOService.addContact(contact);
    }*/
}
