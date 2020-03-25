package com.example.demo.dao.mapper;

import com.example.demo.dao.AddressDAOService;
import com.example.demo.dao.EmailDAOService;
import com.example.demo.dao.MobPhoneDAOService;
import com.example.demo.model.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ContactsMapping implements RowMapper<Contact> {

    private MobPhoneDAOService mobPhoneDAOService;
    private EmailDAOService emailDAOService;
    private AddressDAOService addressDAOService;

    public ContactsMapping(MobPhoneDAOService mobPhoneDAOService) {
        this.mobPhoneDAOService = mobPhoneDAOService;
    }


    public ContactsMapping(MobPhoneDAOService mobPhoneDAOService, EmailDAOService emailDAOService) {
        this.mobPhoneDAOService = mobPhoneDAOService;
        this.emailDAOService = emailDAOService;
    }

    public ContactsMapping(MobPhoneDAOService mobPhoneDAOService, EmailDAOService emailDAOService, AddressDAOService addressDAOService) {
        this.mobPhoneDAOService = mobPhoneDAOService;
        this.emailDAOService = emailDAOService;
        this.addressDAOService = addressDAOService;
    }

    @Override
    public Contact mapRow(ResultSet resultSet, int i) throws SQLException {
        Contact contact = new Contact();
        Long id = resultSet.getLong("CONTACT_ID");
        if (mobPhoneDAOService != null) {
            List<MobPhone> mobPhones = mobPhoneDAOService.getAllMobPhonesByContactId(id);
            for (MobPhone mobPhone : mobPhones) {
                contact.addPhone(mobPhone);
            }
        }
        List<Email> emails = emailDAOService.getAllEmailByContactId(id);
        for (Email email : emails) {
            contact.addEmail(email);
        }
        List<Address> addresses = addressDAOService.getAllAddressByContactId(id);
        for (Address address : addresses) {
            contact.setAddress(address);
        }
        contact.setFirstName(resultSet.getString("firstName"));
        contact.setName(resultSet.getString("name"));
        contact.setCONTACT_ID(resultSet.getInt("CONTACT_ID"));
        return contact;
    }
}
