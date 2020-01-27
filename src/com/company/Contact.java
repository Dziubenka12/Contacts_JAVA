package com.company;

public class Contact {
    private String firstName;
    private String name;
    private Phone phone;
    private String email;
    private Address address;

    public Contact(){
    }
    public Contact(String name, Phone phone){
        this.name = name;
        this.phone = phone;
    }
    public Contact(String firstName, String name, Phone phone, String email, Address address){
        this.firstName = firstName;
        this.name = name;
        this.phone = phone;
        this.email = email;
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
    public String getPhone(){
        return phone.getPhoneNumber();
    }
    public void setPhone(Phone phone){
        this.phone= phone;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String  getAddress() {
        return address.getAddressFull();
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public String toString(){
        return firstName + " " + name + " " + getPhone() + " " + email + " " + getAddress();
    }
}
