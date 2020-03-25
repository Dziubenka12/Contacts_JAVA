package com.example.demo.dao.impl;

import com.example.demo.dao.ContactService;
import com.example.demo.dao.ContactsDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactsDAOService contactsDAOService;
    @Override
    public void createContact(String firstName, String name, String email) {
        contactsDAOService.addContact(firstName, name, email);
    }
}
