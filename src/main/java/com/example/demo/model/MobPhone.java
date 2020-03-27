package com.example.demo.model;

import javax.persistence.*;

/*@Entity*/
public class MobPhone implements Phone {
    /*@Id
    @GeneratedValue*/
    private Integer Id;
    private String mobPhone;
    /*@Enumerated(EnumType.STRING)*/
    private Operator operator;
    private String countryCode;

    public MobPhone() {
    }

    public MobPhone(String countryCode, Operator operator, String mobPhone) {
        this.mobPhone = mobPhone;
        this.operator = operator;
        this.countryCode = countryCode;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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
