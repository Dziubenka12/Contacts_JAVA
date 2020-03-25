package com.example.demo.dao.impl;

import com.example.demo.dao.MobPhoneDAOService;
import com.example.demo.dao.mapper.MobPhoneMapper;
import com.example.demo.model.MobPhone;
import com.example.demo.model.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class MobPhoneDAOServiceImpl implements MobPhoneDAOService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private MobPhoneDAOService mobPhoneDAOService;

    /*@Override
    public List<MobPhone> getAllMobPhones() {
        String sqlQuery = "SELECT * FROM mobphone";
        RowMapper<MobPhone> rowMapper = new MobPhoneMapper();
        return jdbcTemplate.query(sqlQuery, rowMapper);
    }*/

    @Override
    public List<MobPhone> getAllMobPhones() {
        String sqlQuery = "SELECT * FROM CONTACTS \n" +
                "JOIN MOBPHONE \n" +
                "ON CONTACTS.CONTACT_ID = MOBPHONE.CONTACT_ID;";
        RowMapper<MobPhone> rowMapper = new MobPhoneMapper();
        return jdbcTemplate.query(sqlQuery, rowMapper);
    }


    @Override
    public List<MobPhone> getAllMobPhonesByContactId(Long contactId) {
        String sqlQuery = "SELECT * FROM mobphone WHERE contact_id = " + contactId;
        RowMapper<MobPhone> rowMapper = new MobPhoneMapper();
        return jdbcTemplate.query(sqlQuery, rowMapper);
    }

    @Override
    public void deleteMobPhoneById(Long contactId) {
        String sqlDeleteContact = "delete from mobPhone where contact_id = ?";
        MapSqlParameterSource mobPhone = new MapSqlParameterSource();
        mobPhone.addValue("contactId", contactId);
        jdbcTemplate.update(sqlDeleteContact, contactId);
    }
}
/*      MobPhone mobPhone = new MobPhone();
        mobPhone.setCountryCode(resultSet.getString("countryCode"));

        List<MobPhone> mobPhones = mobPhoneDAOService.getAllMobPhonesByContactId(id);
        for(MobPhone mobPhone : mobPhones) {
        mobPhone.setCountryCode(resultSet.getString("countryCode"));
        mobPhone.setMobPhone(resultSet.getString("mobPhone"));
        mobPhone.setOperator(Operator.valueOf(resultSet.getString("operator")));

        contact.addPhone(mobPhone);
        }*/




/*
("SELECT * FROM CONTACTS\n" +
        "JOIN MOBPHONE ON MOBPHONE.CONTACT_ID = MOBPHONE.CONTACT_ID\n" +
        "JOIN ADDRESS ON ADDRESS.CONTACT_ID = ADDRESS.CONTACT_ID ;"))*/
