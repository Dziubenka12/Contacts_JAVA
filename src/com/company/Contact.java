package com.company;

import java.util.ArrayList;

public class Contact {
    private String firstName;
    private String name;
    private ArrayList<Phone> phones = new ArrayList<>();
    private ArrayList<Email> emails = new ArrayList<>();
    private Address address;

    public Contact(){
    }
    public Contact(String name, Phone phone){
        this.phones.add(phone);
        this.name = name;
    }

    public Contact(String firstName, String name) {
        this.firstName = firstName;
        this.name = name;
    }

    public Contact(String firstName, String name, Phone phone, Email email, Address address){
        this.firstName = firstName;
        this.name = name;
        this.phones.add(phone);
        this.emails.add(email);
        this.address = address;
    }

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
    public String getPhones() {
        String phonesString = "";
        for (int i = 0; i < phones.size(); i++) {
            Phone phone = phones.get(i);
            phonesString += phone.getPhoneNumber();
        }
        return " \"phones\":[ " + phonesString + " ],";
    }
    public void addPhone(Phone phone){
        this.phones.add(phone);
    }
    public String getEmail() {
        String emailString = "";
        for (int j = 0; j < emails.size(); j++) {
            Email email = emails.get(j);
            emailString += email.toString();
        }
        return  " \"emails\":[ " + emailString + " ],";
    }
    public void addEmail(Email email){
        this.emails.add(email);
    }
    public String  getAddress() {
        if (this.address == null)
            return " \"address\":" + null;
        else
        return address.toString();
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public String toString(){
        return "{\"firstName\":" + " \"" + firstName + "\"," + " \"name\":" + " \"" + name + "\"," + getPhones() + " \"email\":[" + " \"" + getEmail() + "\"]," + " " + getAddress() + "}";
    }
}
