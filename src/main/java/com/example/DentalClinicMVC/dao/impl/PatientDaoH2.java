package com.example.DentalClinicMVC.dao.impl;

import com.example.DentalClinicMVC.dao.DB;
import com.example.DentalClinicMVC.dao.IDao;
import com.example.DentalClinicMVC.model.Patient;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PatientDaoH2 implements IDao<Patient> {

    private static final String SQL_INSERT = "INSERT INTO Patient" +
            "(patName, patLastName, patIdentity, patAdmission, patName, patEmail, addSec)" +
            "VALUES(?, ?, ?, ?, ?, ?')";

    private static final String SQL_FIND_ID = "SELECT patSec, patName, patLastName, patIdentity, patAdmission, patEmail, addSec" +
            " FROM Patient WHERE patSec = ?";

    private static final String SQL_FIND_EMAIL = "SELECT patSec, patName, patLastName, patIdentity, patAdmission, patEmail, addSec" +
            " FROM Patient WHERE patEmail = ?";

    private static final String SQL_UPDATE = "UPDATE Patient SET patName = ? WHERE patSec = ?";

    private static final String SQL_DELETE = "DELETE FROM Patient WHERE patSec = ?";

    private static final String SQL_FIND_ALL = "SELECT patSec, patName, patLastName, patIdentity, patAdmission, patEmail, addSec" +
            " FROM Patient";

    @Override
    public Patient save(Patient patient) {

        Connection connection = null;

        try {

            AddressDaoH2 addressDaoH2 = new AddressDaoH2();
            addressDaoH2.save(patient.getAddress());

            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, patient.getPatName());
            ps.setString(2, patient.getPatLastName());
            ps.setInt(3, patient.getPatIdentity());
            ps.setDate(4, Date.valueOf(patient.getPatAdmission()));
            ps.setString(5, patient.getPatEmail());
            ps.setInt(6, patient.getAddress().getAddSec());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();

            while (rs.next()) {
                patient.setPatSec(rs.getInt(1));
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

        return patient;
    }

    @Override
    public Patient findById(Integer id) {

        Connection connection = null;
        Patient patient = null;

        try {

            connection = DB.getConnection();
            PreparedStatement psSelect = connection.prepareStatement(SQL_FIND_ID);

            psSelect.setInt(1, id);
            ResultSet rsSelect = psSelect.executeQuery();

            AddressDaoH2 addressDaoH2 = new AddressDaoH2();

            while (rsSelect.next()) {

                patient = new Patient(

                        rsSelect.getInt(1),
                        rsSelect.getString(2),
                        rsSelect.getString(3),
                        rsSelect.getInt(4),
                        rsSelect.getDate(5).toLocalDate(),
                        rsSelect.getString(6),
                        addressDaoH2.findById(rsSelect.getInt(7))
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

        return patient;
    }

    @Override
    public void update(Patient patient) {

        Connection connection = null;

        try {

            connection = DB.getConnection();

            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
            psUpdate.setString(1, patient.getPatName());
            psUpdate.setInt(2, patient.getPatSec());
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
    public List<Patient> findAll() {

        Connection connection = null;
        List<Patient> patientList = new ArrayList<>();

        try {

            connection = DB.getConnection();
            AddressDaoH2 addressDaoH2 = new AddressDaoH2();

            PreparedStatement psFindAll = connection.prepareStatement(SQL_FIND_ALL);
            ResultSet rs = psFindAll.executeQuery();

            while (rs.next()) {

                patientList.add(new Patient(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDate(5).toLocalDate(),
                        rs.getString(6),
                        addressDaoH2.findById(rs.getInt(7))
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

        return patientList;
    }

    @Override
    public Patient findByString(String email) {

        Connection connection = null;
        Patient patient = null;

        try {

            connection = DB.getConnection();
            PreparedStatement psSelect = connection.prepareStatement(SQL_FIND_EMAIL);

            psSelect.setString(1, email);
            ResultSet rsSelect = psSelect.executeQuery();

            AddressDaoH2 addressDaoH2 = new AddressDaoH2();

            while (rsSelect.next()) {

                patient = new Patient(

                        rsSelect.getInt(1),
                        rsSelect.getString(2),
                        rsSelect.getString(3),
                        rsSelect.getInt(4),
                        rsSelect.getDate(5).toLocalDate(),
                        rsSelect.getString(6),
                        addressDaoH2.findById(rsSelect.getInt(7))
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

        return patient;
    }
}