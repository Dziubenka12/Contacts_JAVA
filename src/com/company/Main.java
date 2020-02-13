package com.company;

import java.util.ArrayList;
import java.sql.*;
import java.util.Scanner;

public class Main {

    private static Object address;

    public static void main(String[] args) {

        //ArrayList<Contact> cn = getContacts();

        System.out.printf(getContacts());
        addContact();




      /*
        Phone mob = new MobPhone("+375", Operator.A1, "5474963");

        Contact c1 = new Contact("Oliy", mob);
        c1.setPhone(mob);
        //Contact c2 = new Contact("Toliy", "375447611521");
        c1.setName("Olga");
        Phone coun = new HomePhone(OperatorCountry.Minsk, "3619134");

        Address address1 = new Address(Country.Belarus, "Minsk", "Belskogo", 20, 37);
        Contact anatoli = new Contact("Dziubenko", "Anatoli", new MobPhone("+375", Operator.A1, "7611521"), "dziubenka12@gmail.com", address1);

        //Address addressAnatoli = anatoli.getAddress();
        //addressAnatoli.setStreet("qwe");


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
                writer.write("\"" + key + "\": " + contactsMap.get(key) + ",");
                //writer.write("\"" + key + "\": " + contactsMap.values());
                //writer.write("\"" + key + "\": " + contactsMap.isEmpty());
            }
            writer.append("}");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
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

    public static String getContacts() {
        final String DB_URL = "jdbc:mysql://localhost:3306/bdcontacts?serverTimezone=UTC";
        final String USER = "root";
        final String PASS = "2559134dz";
        ArrayList<Contact> contacts = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM CONTACTS\n" +
                     "JOIN MOBPHONE ON MOBPHONE.CONTACT_ID = MOBPHONE.CONTACT_ID\n" +
                     "JOIN ADDRESS ON ADDRESS.CONTACT_ID = ADDRESS.CONTACT_ID ;")){
            while (resultSet.next()){
                String firstName = resultSet.getString("firstName");
                String name = resultSet.getString("name");
                String mobPhone = resultSet.getString("mobPhone");
                String countryCode = resultSet.getString("contryCode");
                String operator = resultSet.getString("operator");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                String city = resultSet.getString("city");
                String street = resultSet.getString("street");
                String house = resultSet.getString("house");
                int appartament = resultSet.getInt("appartament");
                Contact contact = new Contact(firstName, name, new MobPhone(countryCode, Operator.valueOf(operator), mobPhone), new Email(), new Address(Country.valueOf(country), city, street, house, appartament));
                contacts.add(contact);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts.toString();
    };

    static void addContact() {
        final String DB_URL = "jdbc:mysql://localhost:3306/bdcontacts?serverTimezone=UTC";
        final String USER = "root";
        final String PASS = "2559134dz";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите код оператора");
        String countryCode = scanner.nextLine();
        System.out.println("Введите имя оператор");
        String operator = scanner.nextLine();
        System.out.println("Введите номер телефона");
        String mobPhone = scanner.nextLine();
        System.out.println("Введите CONTACT_ID");
        int CONTACT_ID = scanner.nextInt();

        /*String countryCode = countryCode;
        String operator = operator;

        void setCountryCode(String countryCode){
            this.countryCode = countryCode;
        }*/

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);){
            String sql = "insert MOBPHONE(contryCode, operator, mobPhone, CONTACT_ID)\n" +
                    "values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,countryCode);
            preparedStatement.setString(2,operator);
            preparedStatement.setString(3, mobPhone);
            preparedStatement.setInt(4, CONTACT_ID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    };
}
