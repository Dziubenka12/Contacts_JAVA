package com.company;

public class MobPhone implements Phone {
    private String mobPhone;
    private Operator operator;
    private String countryCode;

    public MobPhone() {}

    public MobPhone(String countryCode, Operator operator, String mobPhone) {
        this.mobPhone = mobPhone;
        this.operator = operator;
        this.countryCode = countryCode;
    }

    public Operator getOperator() {
        return operator;
    }

    public String getMobPhone() {
        return mobPhone;
    }

    public void setMobPhone(String mobPhone) {
        this.mobPhone = mobPhone;
    }

    @Override
    public String getPhoneNumber() {
        return " \"phones\":[ {" + "\"countryCode\": " + countryCode + "\"," + "\" operator\":" + " " + operator.getCode() + "," + "\"mobPhone\":" + " \"" + mobPhone + "\"}],";
    }
}
