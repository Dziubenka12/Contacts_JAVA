package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;


/*@Entity*/
/*@Table(name = "emails")*/
public class Email {

    /*@Id
    @GeneratedValue*/
    private Integer EMAILS_ID;
    /*@ManyToOne*//*(optional=false, cascade=CascadeType.ALL)*/
    /*@JoinColumn (name="emails_id")*/
    private Contact contact;




    /*@OneToMany(fetch = FetchType.EAGER, mappedBy = "emails")
    private Set<ContactEntity> contactEntity;*/
    private String email;
    /*private Set<Author> users;*/
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEMAILS_ID() {
        return EMAILS_ID;
    }

    public void setEMAILS_ID(Integer EMAILS_ID) {
        this.EMAILS_ID = EMAILS_ID;
    }
    /*public Set<ContactEntity> getContactEntity() {
        return contactEntity;
    }

    public void setContactEntity(Set<ContactEntity> contactEntity) {
        this.contactEntity = contactEntity;
    }*/
}
