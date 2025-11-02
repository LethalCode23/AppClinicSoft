package com.example.DentalClinicMVC.dao.impl;

import com.example.DentalClinicMVC.dao.DB;
import com.example.DentalClinicMVC.dao.IDao;
import com.example.DentalClinicMVC.model.Address;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AddressDaoH2 implements IDao<Address> {

    private static final String SQL_INSERT = "INSERT INTO Address" +
            "(addStreet, addNumber, addLocation, addProvince)" +
            "VALUES(?, ?, ?, ?')";

    private static final String SQL_FIND_ID = "SELECT addSec, addStreet, addNumber, addLocation, addProvince" +
            " FROM Address WHERE addSec = ?";

    private static final String SQL_UPDATE = "UPDATE Address SET addStreet = ? WHERE addSec = ?";

    private static final String SQL_DELETE = "DELETE FROM Address WHERE addSec = ?";

    private static final String SQL_FIND_ALL = "SELECT addSec, addStreet, addNumber, addLocation, addProvince" +
            "FROM Address";

    @Override
    public Address save(Address address) {

        Connection connection = null;

        try {

            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, address.getAddStreet());
            ps.setInt(2, address.getAddNumber());
            ps.setString(3, address.getAddLocation());
            ps.setString(4, address.getAddProvince());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();

            while (rs.next()) {
                address.setAddSec(rs.getInt(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return address;
    }

    @Override
    public Address findById(Integer id) {

        Connection connection = null;
        Address address = null;

        try {

            connection = DB.getConnection();
            PreparedStatement psSelect = connection.prepareStatement(SQL_FIND_ID);

            psSelect.setInt(1, id);
            ResultSet rsSelect = psSelect.executeQuery();

            while (rsSelect.next()) {

                address = new Address(

                    rsSelect.getInt(1),
                    rsSelect.getString(2),
                    rsSelect.getInt(3),
                    rsSelect.getString(4),
                    rsSelect.getString(5)
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return address;
    }

    @Override
    public void update(Address address) {

        Connection connection = null;

        try {

            connection = DB.getConnection();

            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
            psUpdate.setString(1, address.getAddStreet());
            psUpdate.setInt(2, address.getAddSec());
            psUpdate.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Integer id) {

        Connection connection = null;

        try {

            connection = DB.getConnection();

            PreparedStatement psDelete = connection.prepareStatement(SQL_DELETE);
            psDelete.setInt(1, id);
            psDelete.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Address> findAll() {

        Connection connection = null;
        List<Address> addressList = new ArrayList<>();

        try {

            connection = DB.getConnection();
            PreparedStatement psFindAll = connection.prepareStatement(SQL_FIND_ALL);
            ResultSet rs = psFindAll.executeQuery();

            while (rs.next()) {

                addressList.add(new Address(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(4)
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return addressList;
    }
}