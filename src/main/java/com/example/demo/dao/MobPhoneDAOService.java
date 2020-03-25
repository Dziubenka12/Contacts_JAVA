package com.example.demo.dao;

import com.example.demo.model.MobPhone;
import com.example.demo.model.Phone;

import java.util.List;

public interface MobPhoneDAOService {

    List<MobPhone> getAllMobPhones();

    List<MobPhone> getAllMobPhonesByContactId(Long contactId);

    void deleteMobPhoneById(Long contactId);
}
