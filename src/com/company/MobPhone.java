package com.company;

public class MobPhone {
    private String mobPhone;
    public String getMobPhone(){
        return mobPhone;
    }
    public void setMobPhone(String mobPhone){
        this.mobPhone = mobPhone;
        if (mobPhone == "44" || mobPhone == "33" || mobPhone == "29") {
            this.mobPhone =  NumKod.getNumKod() + mobPhone;

        } else {
            this.mobPhone = "No operator";
        }
    }
}
