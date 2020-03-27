package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;


@Entity
/*@Table(name = "emails")*/
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_email")
    private Integer id;
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
