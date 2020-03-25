package com.example.demo.controller;

import com.example.demo.dao.ContactRepository;
import com.example.demo.dao.ContactService;
import com.example.demo.exceptions.ContactNotFoundException;
import com.example.demo.model.Contact;
import com.example.demo.model.ContactEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactsController {

    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private ContactService contactService;

    /*@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createContact(@Valid @RequestBody Contact contact) {
        *//*contactService.createContact(
                contact.getFirstName(),
                contact.getName(),
                contact.getEmail()

        );*//*
        contactRepository.save(contact);

    }*/

    @GetMapping
    public List<ContactEntity> getContacts() {
        return contactRepository.findAll();
    }


}












/*
package com.example.demo.controller;

import com.example.demo.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/contacts")
public class ContactsController {

    @GetMapping
    public String getContacts(Model model) {


Contact contact = new Contact("Pasha", "26");
        List<String> list = Arrays.asList("123", "Text", "hhh");
        model.addAttribute("message", "Hello contacts");
        model.addAttribute("mylist", list);
        model.addAttribute("contact1", contact);
        return "contacts";

        final String DB_URL = "jdbc:mysql://localhost:3306/bdcontacts2?serverTimezone=UTC";
        final String USER = "root";
        final String PASS = "2559134dz";
        ArrayList<Contact> contacts = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM CONTACTS\n" +
                     "JOIN MOBPHONE ON MOBPHONE.CONTACT_ID = MOBPHONE.CONTACT_ID\n" +
                     "JOIN ADDRESS ON ADDRESS.CONTACT_ID = ADDRESS.CONTACT_ID ;")) {
            while (resultSet.next()) {
                String firstName = resultSet.getString("firstName");
                String name = resultSet.getString("name");
                String mobPhone = resultSet.getString("mobPhone");
                String countryCode = resultSet.getString("countryCode");
                String operator = resultSet.getString("operator");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                String city = resultSet.getString("city");
                String street = resultSet.getString("street");
                String house = resultSet.getString("house");
                int appartament = resultSet.getInt("appartament");
                Contact contact = new Contact(firstName, name, new MobPhone(countryCode, Operator.valueOf(operator), mobPhone), new Email(), new Address(Country.valueOf(country), city, street, house, appartament));
                //model.addAttribute("contact", contact);
                contacts.add(contact);
            }
            model.addAttribute("contact", contacts.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "contacts";
    }
    //return "contacts";
}


*/
