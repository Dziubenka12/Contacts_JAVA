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

    /*public String getMobPhone(){
        return mobPhone;
    }

    public void setMobPhone(String mobPhone){
        this.mobPhone = mobPhone;
        if (mobPhone == "44" || mobPhone == "33" || mobPhone == "29") {
            //this.mobPhone =  NumKod.getNumKod() + mobPhone;

        } else {
            this.mobPhone = "No operator";
        }
    }*/

    @Override
    public String getPhoneNumber() {
        return countryCode + "-(" + operator.getCode() + ")-" + mobPhone;
    }
}
