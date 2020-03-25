package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "contacts")
public class ContactEntity {

    @Id
    @GeneratedValue
    private Integer CONTACT_ID;
    private String firstName;
    @NotBlank
    private String name;






    /*@OneToMany*//*(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})*//*
    @JoinColumn(name = "CONTACT_ID", nullable = false)
    private ContactEntity contactEntity;*/

    /*@OneToMany (mappedBy="contacts", fetch=FetchType.EAGER)
    @JoinColumn (name="CONTACT_ID")*/
    /*private Collection<Email> Email;*/
    @ElementCollection
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contacts")
    /*@OneToMany (*//*mappedBy="contacts", *//*fetch=FetchType.EAGER, orphanRemoval = true)*/
    private ArrayList<Email> emails = new ArrayList<>();
    /*@JoinColumn (name="CONTACT_ID")*/
    /*private Set<Email> Email;*/
    public void addEmail(Email email) {
        emails.add(email);
        /*emails.setProfessor(this);*/
    }

    public void removeEmail(Email email) {
        emails.remove(email);
        /*emails.setProfessor(null);*/
    }

















    @OneToOne
    @JoinColumn(name = "CONTACT_ID", unique = true, nullable = false/* referencedColumnName = "ADDRESS_ID"*/)
    private Address address;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Email> getEmails() {
        return emails;
    }

    public void setEmails(ArrayList<Email> emails) {
        this.emails = emails;
    }

    public Integer getCONTACT_ID() {
        return CONTACT_ID;
    }

    public void setCONTACT_ID(Integer CONTACT_ID) {
        this.CONTACT_ID = CONTACT_ID;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
