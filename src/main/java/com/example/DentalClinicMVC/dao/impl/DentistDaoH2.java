package com.example.DentalClinicMVC.dao.impl;

import com.example.DentalClinicMVC.dao.DB;
import com.example.DentalClinicMVC.dao.IDao;
import com.example.DentalClinicMVC.model.Dentist;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DentistDaoH2 implements IDao<Dentist> {

    private static final String SQL_INSERT =
            "INSERT INTO Dentist (denRegistration, denName, denLastName) VALUES (?, ?, ?)";

    private static final String SQL_FIND_ID =
            "SELECT denSec, denRegistration, denName, denLastName FROM Dentist WHERE denSec = ?";

    private static final String SQL_FIND_REGISTRATION =
            "SELECT denSec, denRegistration, denName, denLastName FROM Dentist WHERE denRegistration = ?";

    private static final String SQL_UPDATE =
            "UPDATE Dentist SET denRegistration = ?, denName = ?, denLastName = ? WHERE denSec = ?";

    private static final String SQL_DELETE =
            "DELETE FROM Dentist WHERE denSec = ?";

    private static final String SQL_FIND_ALL =
            "SELECT denSec, denRegistration, denName, denLastName FROM Dentist";

    @Override
    public Dentist save(Dentist dentist) {

        Connection connection = null;

        try {
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, dentist.getDenRegistration());
            ps.setString(2, dentist.getDenName());
            ps.setString(3, dentist.getDenLastName());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                dentist.setDenSec(rs.getInt(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return dentist;
    }

    @Override
    public Dentist findById(Integer id) {

        Connection connection = null;
        Dentist dentist = null;

        try {

            connection = DB.getConnection();
            PreparedStatement psSelect = connection.prepareStatement(SQL_FIND_ID);

            psSelect.setInt(1, id);
            ResultSet rsSelect = psSelect.executeQuery();

            while (rsSelect.next()) {

                dentist = new Dentist(
                        rsSelect.getInt(1),
                        rsSelect.getInt(2),
                        rsSelect.getString(3),
                        rsSelect.getString(4)
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

        return dentist;
    }

    @Override
    public void update(Dentist dentist) {

        Connection connection = null;

        try {

            connection = DB.getConnection();

            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
            psUpdate.setString(1, dentist.getDenName());
            psUpdate.setInt(2, dentist.getDenSec());
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
    public List<Dentist> findAll() {

        Connection connection = null;
        List<Dentist> dentistList = new ArrayList<>();

        try {

            connection = DB.getConnection();
            AddressDaoH2 addressDaoH2 = new AddressDaoH2();

            PreparedStatement psFindAll = connection.prepareStatement(SQL_FIND_ALL);
            ResultSet rs = psFindAll.executeQuery();

            while (rs.next()) {

                dentistList.add(new Dentist(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
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

        return dentistList;
    }

    @Override
    public Dentist findByString(String value) {
        return null;
    }
}