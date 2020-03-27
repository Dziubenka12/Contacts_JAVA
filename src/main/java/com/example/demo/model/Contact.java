package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
/*@Entity*/
//@Table(name = "contacts")
public class Contact {
    /*@Id
    @GeneratedValue*/
    private Integer id;
    private String firstName;
    /*@NotBlank*/
    private String name;
    /*@OneToMany(cascade=CascadeType.ALL)*/
    /*private ArrayList<Phone> phones = new ArrayList<>();*/
    /*@OneToMany(cascade=CascadeType.ALL)*/
    private List<Email> emails;
    /*@OneToOne(cascade=CascadeType.ALL)*/
    private Address address;

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

/*public Contact() {
        super();
    }

    *//*public Contact(){
    }*//*

    public Contact(MobPhone mobPhone){

    }


    public Contact(String firstName, String name, ArrayList<Email> emails) {
        this.firstName = firstName;
        this.name = name;
        this.emails = emails;
    }

    public Contact(String name, Phone phone){
        this.phones.add(phone);
        this.name = name;
    }

    public Contact(String firstName, String name) {
        this.firstName = firstName;
        this.name = name;
    }

    public Contact(ArrayList<Phone> phones) {
        this.phones = phones;
    }

    public Contact(String firstName, String name, Phone phone, Email email, Address address){
        this.firstName = firstName;
        this.name = name;
        this.phones.add(phone);
        this.emails.add(email);
        this.address = address;
    }*/

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    /*public String getPhones() {
        String phonesString = "";
        for (int i = 0; i < phones.size(); i++) {
            Phone phone = phones.get(i);
            phonesString += phone.getPhoneNumber();
        }
        return " \"phones\":[ " + phonesString + " ],";
    }
    public List<Phone> getPhoneList() {
        return this.phones;
    }
    public void addPhone(Phone phone){
        this.phones.add(phone);
    }*/
    public String getEmail() {
        String emailString = "";
        for (int j = 0; j < emails.size(); j++) {
            Email email = emails.get(j);
            emailString += email.toString();
        }
        /*return emailString;*/
        return emailString;
    }
    public List<Email> getEmails() {
        return this.emails;
    }
    public void addEmail(Email email){
        this.emails.add(email);
    }
    public Address  getAddress() {
        /*if (this.address == null)
            return " \"address\":" + null;
        else*/
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /*public String toString(){
        return "{\"firstName\":" + " \"" + firstName + "\"," + " \"name\":" + " \"" + name + "\"," + getPhones() + " \"email\":[" + " \"" + getEmail() + "\"]," + " " + getAddress() + "}";
    }*/


    public void setEmails(ArrayList<Email> emails) {
        this.emails = emails;
    }
}
