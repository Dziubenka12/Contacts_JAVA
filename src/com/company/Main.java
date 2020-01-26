package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Contact c1 = new Contact("Oliy", "37529371881");
        Contact c2 = new Contact("Toliy", "375447611521");
        c1.setName("Olga");

        ArrayList<Contact> Contacts= new ArrayList<>();
        Contacts.add(c1);
        Contacts.add(c2);
        System.out.println(Contacts.toString());

    }
}
