package com.example.demo.model;

public class MobPhone implements Phone {
    private String mobPhone;
    private Operator operator;
    private String countryCode;

    public MobPhone() {
    }

    public MobPhone(String countryCode, Operator operator, String mobPhone) {
        this.mobPhone = mobPhone;
        this.operator = operator;
        this.countryCode = countryCode;
    }

    public String getMobPhone() {
        return mobPhone;
    }

    public void setMobPhone(String mobPhone) {
        this.mobPhone = mobPhone;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String getPhoneNumber() {
        return "{" + "\"countryCode\": " +"\"" + countryCode + "\"," + "\"operator\":" + " " + operator.getCode() + "," + "\"mobPhone\":" + " \"" + mobPhone + "\"}";
    }
}
