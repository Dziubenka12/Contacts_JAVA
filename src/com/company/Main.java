package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Phone mob = new MobPhone("+375", Operator.A1, "5474963");

        Contact c1 = new Contact("Oliy", mob);
        c1.setPhone(mob);
        //Contact c2 = new Contact("Toliy", "375447611521");
        c1.setName("Olga");
        Phone coun = new HomePhone(OperatorCountry.Minsk,"3619134");

        ArrayList<Contact> Contacts= new ArrayList<>();
        Contacts.add(c1);
        //Contacts.add(c2);
        System.out.println(mob.getPhoneNumber());
        System.out.println(coun.getPhoneNumber());
    }
}
