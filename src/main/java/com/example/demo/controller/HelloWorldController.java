package com.example.demo.controller;

import com.example.demo.dao.ContactsDAOService;
import com.example.demo.dao.EmailDAOService;
import com.example.demo.dao.MobPhoneDAOService;
import com.example.demo.dao.mapper.MobPhoneMapper;
import com.example.demo.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/contacts")
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
}
