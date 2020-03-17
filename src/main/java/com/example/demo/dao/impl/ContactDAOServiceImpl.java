package com.example.demo.dao.impl;

import com.example.demo.dao.AddressDAOService;
import com.example.demo.dao.ContactsDAOService;
import com.example.demo.dao.EmailDAOService;
import com.example.demo.dao.mapper.ContactsMapping;
import com.example.demo.dao.MobPhoneDAOService;
import com.example.demo.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
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
    public Contact getContactById(Long contactId) /*throws ContactNotFoundException */{
        String sqlQuery = "SELECT * FROM contacts WHERE contact_id = " + contactId;
        RowMapper<Contact> rowMapper = new ContactsMapping(mobPhoneDAOService, emailDAOService, addressDAOService);
        Contact contact = jdbcTemplate.queryForObject(sqlQuery, rowMapper);
        /*if (contact != null) {
            return contact;
        } else {
            throw new ContactNotFoundException("Contact with id " + contactId + " not found");
        }*/
        return contact;
    }

    @Override
    public void deleteContactById(Long contactId) {
        String sqlDeleteContact = "delete from contact where id = contactId";
        MapSqlParameterSource contact = new MapSqlParameterSource();
        contact.addValue("contactId", contactId);
        jdbcTemplate.update(sqlDeleteContact, contact);
    }

    @Override
    public Contact updateContact(Long contactId) {
        String sqlUpdate = "insert into contact(firstName, name) value (?,?)";
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sqlUpdate, new Object[] {contactId.getFirstName});
        return contact;
    }




    }
