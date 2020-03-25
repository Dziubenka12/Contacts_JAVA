package com.example.demo.dao.impl;

import com.example.demo.dao.AddressDAOService;
import com.example.demo.dao.mapper.AddressMapping;
import com.example.demo.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressDAOServiceImpl implements AddressDAOService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Address> getAllAddressByContactId(Long contactId) {
        String sqlQuery = "SELECT * FROM address WHERE contact_id = " + contactId;
        /*String sqlQuery = "SELECT * FROM address";*/
        RowMapper<Address> rowMapper = new AddressMapping();
        return jdbcTemplate.query(sqlQuery, rowMapper);
    }

    @Override
    public void deleteAddressById(Long contactId) {
        String sqlDeleteContact = "delete from address where contact_id = ?";
        MapSqlParameterSource address = new MapSqlParameterSource();
        address.addValue("contactId", contactId);
        jdbcTemplate.update(sqlDeleteContact, contactId);
    }
}
