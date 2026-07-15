package util;

import java.sql.*;

public class DBConnection {
    private static final String URL = 
            "jdbc:postgresql://localhost:5432/studentDB";
    private static final String USER = "postgres";
    private static final String PASS = "belgiumcampus";
    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connected");
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error connecting to the database: " + ex.getMessage(), ex);
        }
        return conn;
    }
}
