package com.example.demo.dao;

import com.example.demo.model.Contact;

import java.util.List;

public interface ContactsDAOService {

    List<Contact> getAllContacts();

    List<Contact> getAllContactByContactId(Long contactId);
}
