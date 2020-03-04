package com.example.demo.model;

public class HomePhone implements Phone{
    private String homePhone;
    private OperatorCountry countryCode;

    public HomePhone() {
    }

    public HomePhone(OperatorCountry countryCode, String homePhone){
        this.homePhone = homePhone;
        this.countryCode = countryCode;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public OperatorCountry getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(OperatorCountry countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String getPhoneNumber() {
        return " \"phones\":[ {" + countryCode.getCode() + "\"mobPhone\":" + " \"" + homePhone + "\"}],";
    }
}
