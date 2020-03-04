package com.example.demo.dao.mapper;

import com.example.demo.dao.EmailDAOService;
import com.example.demo.model.Email;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmailMapper implements RowMapper<Email> {

    /*private final EmailDAOService emailDAOService;

    public EmailMapper(EmailDAOService emailDAOService) {
        this.emailDAOService = emailDAOService;
    }*/

    @Override
    public Email mapRow(ResultSet resultSet, int i) throws SQLException {
        Email email = new Email();
        email.setEmail(resultSet.getString("email"));
        //email.setEmail(resultSet.getString("Email"));
        /*List<Email> emails = emailDAOService.getAllEmail();
        for (Email email: emails) {
            email.getEmail(email);
        }*/
        return email;
    }
}
