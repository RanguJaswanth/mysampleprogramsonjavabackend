package com.jdbc.old;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // PostgreSQL database details
    private static final String URL = "jdbc:postgresql://localhost:5432/JDBCExample";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Rangu@321";

    static {
        try {
            // Old-style driver loading
            Class.forName("org.postgresql.Driver");
            System.out.println("✔ PostgreSQL Driver Loaded Successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Driver Not Found: " + e.getMessage());
        }
    }

    // Get a database connection
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✔ Connection Established Successfully!");
        } catch (SQLException e) {
            System.out.println("❌ Connection Failed: " + e.getMessage());
        }
        return conn;
    }
}

