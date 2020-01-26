package com.company;

public class NumKod extends MobPhone{
    private static String numKod;

    public static String getNumKod() {
        System.out.println(numKod);
        return numKod;
    }

    public void setNumKod(String numKod) {
        this.numKod = numKod;
        if (numKod == "44" || numKod == "33" || numKod == "29") {
            this.numKod = "+375" + numKod;
        } else {
            this.numKod = "No operator";
        }
    }
}
