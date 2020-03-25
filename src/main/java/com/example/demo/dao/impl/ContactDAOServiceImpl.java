package com.example.demo.dao.impl;

import com.example.demo.dao.AddressDAOService;
import com.example.demo.dao.ContactsDAOService;
import com.example.demo.dao.EmailDAOService;
import com.example.demo.dao.mapper.ContactsMapping;
import com.example.demo.dao.MobPhoneDAOService;
import com.example.demo.exceptions.ContactNotFoundException;
import com.example.demo.model.Contact;
import com.example.demo.model.Email;
import com.example.demo.model.MobPhone;
import com.example.demo.model.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class ContactDAOServiceImpl implements ContactsDAOService {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private ContactsDAOService contactsDAOService;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    private MobPhoneDAOService mobPhoneDAOService;
    @Autowired
    private EmailDAOService emailDAOService;
    @Autowired
    private AddressDAOService addressDAOService;

    @Override
    public List<Contact> getAllContacts() {
        String sqlQuery = "SELECT * FROM contacts";
        RowMapper<Contact> rowMapper = new ContactsMapping(mobPhoneDAOService, emailDAOService, addressDAOService);
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
        RowMapper<Contact> rowMapper = new ContactsMapping(mobPhoneDAOService, emailDAOService, addressDAOService);
        Contact contact = jdbcTemplate.queryForObject(sqlQuery, rowMapper);
        if (contact != null) {
            return contact;
        } else {
            throw new ContactNotFoundException("Contact with id " + contactId + " not found");
        }
        //return contact;
    }

    @Override
    public void deleteContactById(Long contactId) {
        String sqlDeleteContact = "delete from contacts where contact_id = ?";
        MapSqlParameterSource contact = new MapSqlParameterSource();
        addressDAOService.deleteAddressById(contactId);
        mobPhoneDAOService.deleteMobPhoneById(contactId);
        contact.addValue("contactId", contactId);
        jdbcTemplate.update(sqlDeleteContact, contactId);
    }

    /*@Override
    public void addContact(Contact contact) {
        System.out.println(contact.toString());
        String sqlAddContact = "insert into contacts(firstName, name, email) values (?, ?, ?)";
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sqlAddContact, contact.getFirstName(), contact.getName(),contact.getEmail());
    }*/


    @Override
    public void addContact(String firstName, String name, String email) {
        String sqlAddContact = "insert into contacts(firstName, name, email) values (:firstName, :name, :email)";
        MapSqlParameterSource addParams = new MapSqlParameterSource();
        /*addParams.getValue(firstName);
        addParams.getValue(name);
        addParams.getValue(email);*/
        addParams.addValue("firstName", firstName);
        addParams.addValue("name", name);
        addParams.addValue("email", email);
        namedParameterJdbcTemplate.update(sqlAddContact, addParams);
    }


    /*@Override
    public Contact updateContact(Long contactId) {
        *//*String sqlUpdate = "insert into contact(firstName, name) value (?,?)";
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sqlUpdate, new Object[] {contactId.getFirstName});*//*
        return contact;
    }*/




    }
