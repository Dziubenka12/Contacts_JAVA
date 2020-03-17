package com.example.demo.dao.impl;

import com.example.demo.dao.EmailDAOService;
import com.example.demo.dao.mapper.EmailMapper;
import com.example.demo.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailDAOServiceImpl implements EmailDAOService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Email> getAllEmailByContactId(Long contactId) {
        String sqlQuery = "SELECT email FROM contacts WHERE contact_id = " + contactId;
        RowMapper<Email> rowMapper = new EmailMapper();
        return jdbcTemplate.query(sqlQuery, rowMapper);
    }
}
