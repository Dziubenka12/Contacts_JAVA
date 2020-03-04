package com.example.demo.dao.mapper;

import com.example.demo.model.HomePhone;
import com.example.demo.model.OperatorCountry;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class HomePhoneMapper implements RowMapper<HomePhone> {

    @Override
    public HomePhone mapRow(ResultSet resultSet, int i) throws SQLException {
        HomePhone homePhone = new HomePhone();
        homePhone.setCountryCode(OperatorCountry.valueOf(resultSet.getString("countryCode")));
        homePhone.setHomePhone(resultSet.getString("homePhone"));
        return homePhone;
    }
}
