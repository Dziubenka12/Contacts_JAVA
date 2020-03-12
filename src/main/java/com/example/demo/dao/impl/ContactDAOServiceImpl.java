package com.example.demo.dao.impl;

import com.example.demo.dao.ContactsDAOService;
import com.example.demo.dao.mapper.ContactsMapping;
import com.example.demo.dao.MobPhoneDAOService;
import com.example.demo.exceptions.ContactNotFoundException;
import com.example.demo.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactDAOServiceImpl implements ContactsDAOService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private MobPhoneDAOService mobPhoneDAOService;

    @Override
    public List<Contact> getAllContacts() {
        String sqlQuery = "SELECT * FROM contacts";
        RowMapper<Contact> rowMapper = new ContactsMapping(mobPhoneDAOService);
        return jdbcTemplate.query(sqlQuery, rowMapper);
    }

    @Override
    public List<Contact> getAllContactByContactId(Long contactId) {
        String sqlQuery = "SELECT * FROM contacts WHERE contact_id = " + contactId;
        RowMapper<Contact> rowMapper = new ContactsMapping(mobPhoneDAOService);
        return jdbcTemplate.query(sqlQuery, rowMapper);
    }

    @Override
    public Contact getContactById(Long contactId) throws ContactNotFoundException {
        String sqlQuery = "SELECT * FROM contacts WHERE contact_id = " + contactId;
        RowMapper<Contact> rowMapper = new ContactsMapping(mobPhoneDAOService);
        Contact contact = jdbcTemplate.queryForObject(sqlQuery, rowMapper);
        if (contact != null) {
            return contact;
        } else {
            throw new ContactNotFoundException("Contact with id " + contactId + " not found");
        }
    }


}
