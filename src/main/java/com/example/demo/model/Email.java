package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "emails")
public class Email {

    @Id
    @GeneratedValue
    @Column(name = "EMAILS_ID")
    private Integer EMAILS_ID;
    @ManyToOne/*(optional=false, cascade=CascadeType.ALL)*/(fetch = FetchType.LAZY)
    @JoinColumn (name="CONTACT_ID")
    public ContactEntity contactEntity;


    /*public ContactEntity getContactEntity() {
        return contactEntity;
    }

    public void setContactEntity(ContactEntity contactEntity) {
        this.contactEntity = contactEntity;
    }*/
    @Column
    private String email;
    private Contact contact;




    /*@OneToMany(fetch = FetchType.EAGER, mappedBy = "emails")
    private Set<ContactEntity> contactEntity;*/

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
