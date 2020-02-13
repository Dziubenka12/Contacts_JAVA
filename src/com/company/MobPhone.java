package com.company;

public class MobPhone implements Phone {
    private String mobPhone;
    private Operator operator;
    private String countryCode;

    public MobPhone(String countryCode,  Operator operator, String mobPhone) {
        this.mobPhone = mobPhone;
        this.operator = operator;
        this.countryCode = countryCode;
    }

    @Override
    public String getPhoneNumber() {
        return "{" + "\"countryCode\": " +"\"" + countryCode + "\"," + "\"operator\":" + " " + operator.getCode() + "," + "\"mobPhone\":" + " \"" + mobPhone + "\"}";
    }
}
