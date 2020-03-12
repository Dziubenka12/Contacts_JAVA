package com.example.demo.dao.mapper;

import com.example.demo.model.Address;
import com.example.demo.model.Country;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressMapping implements RowMapper {

    @Override
    public Address mapRow(ResultSet resultSet, int i) throws SQLException {
        Address address = new Address();
        address.setCountry(Country.valueOf(resultSet.getString("country")));
        address.setCity(resultSet.getString("city"));
        address.setStreet(resultSet.getString("street"));
        address.setHouse(resultSet.getString("house"));
        /*address.setApartment(resultSet.getInt("appartament"));*/
        address.setApartment(resultSet.getInt("apartment"));
        return address;
    }
}
