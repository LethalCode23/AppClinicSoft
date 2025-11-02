package com.example.DentalClinicMVC.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB {

    private static final String DRIVER = "org.h2.Driver";
    private static final String URL = "jdbc:h2:~/dentalClinic";
    private static final String USER = "sa";
    private static final String PASS = "sa";

    private static final String SQL_CREATE_DENTIST_TB = "DROP TABLE IF EXISTS Dentist; " +
            "CREATE TABLE Dentist " +
            " (" +
            " denSec INT AUTO_INCREMENT PRIMARY KEY, " +
            " denRegistration INT NOT NULL, " +
            " denName VARCHAR(100) NOT NULL, " +
            " denLastName VARCHAR(100) NOT NULL" +
            " )";

    private static final String SQL_CREATE_ADDRESS_TB = "DROP TABLE IF EXISTS Address; " +
            "CREATE TABLE Address " +
            " (" +
            " addSec INT AUTO_INCREMENT PRIMARY KEY, " +
            " addStreet VARCHAR(100) NOT NULL, " +
            " addNumber INT NOT NULL, " +
            " addLocation VARCHAR(100) NOT NULL, " +
            " addProvince VARCHAR(100) NOT NULL" +
            " )";

    private static final String SQL_CREATE_PATIENT_TB = "DROP TABLE IF EXISTS Patient; " +
            "CREATE TABLE Patient " +
            " (" +
            " patSec INT AUTO_INCREMENT PRIMARY KEY, " +
            " patName VARCHAR(100) NOT NULL, " +
            " patLastName VARCHAR(100) NOT NULL, " +
            " patIdentity INT NOT NULL, " +
            " patAdmission DATE NOT NULL, " +
            " addSec INT NOT NULL )";

    private static final String SQL_INSERT = "INSERT INTO Address(addStreet, addNumber, addLocation, addProvince)" +
            "VALUES('Real de Minas', 62, 'Manchester', 'England')," +
            "('Mutis', 53, 'London', 'England');" +
            "INSERT INTO Patient(patName, patLastName, patIdentity, patAdmission, addSec)" +
            "VALUES('Christopher', 'Diaz', 6354798, '2025-11-02', 1);" +
            "INSERT INTO Dentist(denRegistration, denName, denLastName)" +
            "VALUES(503680, 'Felipe', 'Gomez')";

    public static Connection getConnection() throws Exception {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static void createTables() {

        Connection connection = null;

        try {

            connection = getConnection();
            Statement statement = connection.createStatement();

            /* create both table | patient, dentist and address */

            statement.execute(SQL_CREATE_ADDRESS_TB);
            statement.execute(SQL_CREATE_DENTIST_TB);
            statement.execute(SQL_CREATE_PATIENT_TB);

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
}