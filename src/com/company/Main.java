package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        Phone mob = new MobPhone("+375", Operator.A1, "5474963");

        Contact c1 = new Contact("Oliy", mob);
        c1.setPhone(mob);
        //Contact c2 = new Contact("Toliy", "375447611521");
        c1.setName("Olga");
        Phone coun = new HomePhone(OperatorCountry.Minsk, "3619134");

        Address address1 = new Address(Country.Belarus, "Minsk", "Belskogo", 20, 37);
        Contact anatoli = new Contact("Dziubenko", "Anatoli", new MobPhone("+375", Operator.A1, "7611521"), "dziubenka12@gmail.com", address1);

        Address addressAnatoli = anatoli.getAddress();
        addressAnatoli.setStreet("qwe");


        ArrayList<Contact> contacts = new ArrayList<>();
        HashMap<String, Contact> contactsMap = new HashMap<>();
        //contactsMap.put("key1", c1);
        contactsMap.put("contact2", anatoli);
        contactsMap.put("contact3", c1);
        contacts.add(c1);

        Contact c3 = contactsMap.get("contact2");

        //Contacts.add(c2);
        System.out.println(contactsMap.toString());
        // System.out.println(coun.getPhoneNumber());
        //System.out.println(addressAnatoli.toString());
        System.out.println(contactsMap.keySet());

        File testFile = new File("./src/com/company/test123.json");
        try (FileWriter writer = new FileWriter(testFile);) {
            writer.append("{");
            for (String key : contactsMap.keySet()) {
                writer.write("\"" + key + "\": " + contactsMap.get(key));
            }
            writer.append("}");
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*try (FileReader reader = new FileReader(testFile)) {
            int i = reader.read();
            while (i != -1) {
                System.out.print((char) i);
                i = reader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/




        /*File testFile = new File("./src/com/company/test123.json");
        try (FileReader reader = new FileReader(testFile)) {
            int i = reader.read();
            while (i != -1) {
                System.out.print((char) i);
                i = reader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*try (FileWriter writer = new FileWriter(testFile, true);) {
            writer.append('\n');
            writer.append("row 2");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
