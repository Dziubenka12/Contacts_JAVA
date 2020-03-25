package com.example.demo.dao;

import com.example.demo.exceptions.ContactNotFoundException;
import com.example.demo.model.Contact;

import java.util.List;

public interface ContactsDAOService {

    List<Contact> getAllContacts();

    List<Contact> getAllContactByContactId(Long contactId);

    Contact getContactById(Long contactId) throws ContactNotFoundException;

    void deleteContactById(Long contactId);

    /*void addContact(Contact contact);*/

    void addContact(String firstName, String name, String email);

    /* Contact updateContact(Long contactId);*/
}
