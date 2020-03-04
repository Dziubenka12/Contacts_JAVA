package com.example.demo.dao.mapper;

import com.example.demo.dao.MobPhoneDAOService;
import com.example.demo.model.Contact;
import com.example.demo.model.Email;
import com.example.demo.model.MobPhone;
import com.example.demo.model.Operator;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ContactsMapping implements RowMapper<Contact> {

    private MobPhoneDAOService mobPhoneDAOService;

    public ContactsMapping(MobPhoneDAOService mobPhoneDAOService) {
        this.mobPhoneDAOService = mobPhoneDAOService;
    }

    @Override
    public Contact mapRow(ResultSet resultSet, int i) throws SQLException {
        Contact contact = new Contact();
        Long id = resultSet.getLong("CONTACT_ID");
        List<MobPhone> mobPhones = mobPhoneDAOService.getAllMobPhonesByContactId(id);
        for(MobPhone mobPhone : mobPhones) {
            /*mobPhone.setCountryCode(resultSet.getString("countryCode"));
            mobPhone.setMobPhone(resultSet.getString("mobPhone"));
            mobPhone.setOperator(Operator.valueOf(resultSet.getString("operator")));
*/
            contact.addPhone(mobPhone);
        }


        contact.setFirstName(resultSet.getString("firstName"));
        contact.setName(resultSet.getString("name"));
        return contact;
    }
}
