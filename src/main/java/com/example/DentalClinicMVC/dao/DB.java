package com.example.DentalClinicMVC.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

    private static final String DRIVER = "org.h2.Driver";
    private static final String URL = "jdbc:h2:~/dentalClinic";
    private static final String USER = "sa";
    private static final String PASS = "sa";

    public static Connection getConnection() throws Exception {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASS);
    }
}