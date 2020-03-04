package com.example.demo.dao.impl;

import com.example.demo.dao.AddressDAOService;
import com.example.demo.dao.mapper.AddressMapping;
import com.example.demo.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class AddressDAOServiceimp implements AddressDAOService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Address> getAllAddressByContactId(Long contactId) {
        /*String sqlQuery = "SELECT * FROM address WHERE contact_id = " + contactId;*/
        String sqlQuery = "SELECT * FROM address";
        RowMapper<Address> rowMapper = new AddressMapping();
        return jdbcTemplate.query(sqlQuery, rowMapper);
    }
}
