package com.example.demo.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue
    private Integer ADDRESS_ID;
    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    private Country country;
    private String city;
    private String street;
    private String house;
    private int apartment;
    @OneToOne(optional = false, mappedBy="address")
    private ContactEntity contactEntity;

    public Address() {
    }

    public Address(Country country, String city, String street, String house, int apartment){
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
    }

    public Address(Country country, String city) {
        this.country = country;
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }
    public void setCountry(Country country) {
        this.country = country;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getHouse() {
        return house;
    }
    public void setHouse(String house) {
        this.house = house;
    }
    public int getApartment() {
        return apartment;
    }
    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    public Integer getADDRESS_ID() {
        return ADDRESS_ID;
    }

    public void setADDRESS_ID(Integer ADDRESS_ID) {
        this.ADDRESS_ID = ADDRESS_ID;
    }

    /*public String toString(){
        return " \"address\": {" + " \"country\":" + " \"" + country + "\"," + " " + "\"city\":" + " \"" + city + "\"," + " " + "\"street\":" + " \"" + street + "\"," + " " + "\"house\":" + " \"" + house + "\"," + " " + "\"apartment\":" + " \"" + apartment + "\"}";
    }*/
}
