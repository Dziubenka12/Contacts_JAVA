package com.example.demo.dao;

import com.example.demo.model.Address;

import java.util.List;

public interface AddressDAOService {

    List<Address> getAllAddressByContactId(Long contactId);
}
