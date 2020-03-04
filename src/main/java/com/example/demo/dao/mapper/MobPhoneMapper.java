package com.example.demo.dao.mapper;

import com.example.demo.dao.MobPhoneDAOService;
import com.example.demo.model.Contact;
import com.example.demo.model.MobPhone;
import com.example.demo.model.Operator;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MobPhoneMapper implements RowMapper<MobPhone> {

    private  MobPhoneDAOService mobPhoneDAOService;

    public MobPhoneMapper(MobPhoneDAOService mobPhoneDAOService) {
        this.mobPhoneDAOService = mobPhoneDAOService;
    }

    public MobPhoneMapper() {

    }

    @Override
    public MobPhone mapRow(ResultSet resultSet, int i) throws SQLException {
        MobPhone mobPhone = new MobPhone();
        Long id = resultSet.getLong("CONTACT_ID");
        /*List<MobPhone> mobPhones = mobPhoneDAOService.getAllMobPhonesByContactId(id);*/
        /*List<MobPhone> mobPhones = mobPhoneDAOService.getAllMobPhones();

        for(MobPhone mobPhone : mobPhones) {
            mobPhone.getPhoneNumber(mobPhone);
        }
*/


        /*ArrayList<Contact> contacts = new ArrayList<>();
        while (resultSet.next()) {
            Long id = resultSet.getLong("CONTACT_ID");
            String mobPhone = resultSet.getString("mobPhone");
            String countryCode = resultSet.getString("countryCode");
            String operator = resultSet.getString("operator");
            Contact contact = new Contact(new MobPhone(countryCode, Operator.valueOf(operator), mobPhone));
            List<MobPhone> mobPhones = mobPhoneDAOService.getAllMobPhonesByContactId(id);
            contacts.add(contact);
        }
        mobPhone.getMobPhone(contacts);*/

        /*List<MobPhone> mobPhones = mobPhoneDAOService.getAllMobPhones();*/

        /*for(MobPhone mobPhone : mobPhones) {
            contact.addPhone(mobPhone);
        }*/


        mobPhone.setCountryCode(resultSet.getString("countryCode"));
        mobPhone.setMobPhone(resultSet.getString("mobPhone"));
        mobPhone.setOperator(Operator.valueOf(resultSet.getString("operator")));
        return mobPhone;
    }
}
