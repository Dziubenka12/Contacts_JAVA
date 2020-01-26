package com.company;

public class HomePhone implements Phone{
    private String homePhone;
    private OperatorCountry countryCode;

    public HomePhone(OperatorCountry countryCode, String homePhone){
        this.homePhone = homePhone;
        this.countryCode = countryCode;
    }

    @Override
    public String getPhoneNumber() {
        return countryCode.getCode() + homePhone;
    }
}
