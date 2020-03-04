package com.example.demo.dao;

import com.example.demo.model.Email;

import java.util.List;

public interface EmailDAOService {

    List<Email> getAllEmailByContactId(Long contactId);
}
