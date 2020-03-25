package com.example.demo.dao;

import com.example.demo.model.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Integer> {

}
