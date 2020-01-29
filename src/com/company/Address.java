package com.company;

public class Address {
    private Country country;
    private String city;
    private String street;
    private int house;
    private int apartment;

    public Address(Country country, String city, String street, int house, int apartment){
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
    public int getHouse() {
        return house;
    }
    public void setHouse(int house) {
        this.house = house;
    }
    public int getApartment() {
        return apartment;
    }
    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    public String toString(){
        return " \"address\": {" + " \"country\"" + " \"" + country + "\"," + " " + "\"city\":" + " \"" + city + "\"," + " " + "\"street\":" + " \"" + street + "\"," + " " + "\"house\":" + " \"" + house + "\"," + " " + "\"apartment\":" + " \"" + apartment + "\"}";
    }
}
