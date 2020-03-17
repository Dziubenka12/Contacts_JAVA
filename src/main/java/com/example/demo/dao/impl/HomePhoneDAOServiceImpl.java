package com.example.demo.dao.impl;

import com.example.demo.dao.HomePhoneDAOService;
import com.example.demo.dao.mapper.HomePhoneMapper;
import com.example.demo.model.HomePhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomePhoneDAOServiceImpl implements HomePhoneDAOService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<HomePhone> getAllHomePhone() {
        String sqlQuery = "SELECT * FROM homephone";
        RowMapper<HomePhone> rowMapper = new HomePhoneMapper();
        return jdbcTemplate.query(sqlQuery, rowMapper);
    }
}
