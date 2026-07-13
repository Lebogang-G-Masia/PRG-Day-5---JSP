package util;

import java.sql.*;

public class DBConnection {
    private static final String URL = 
            "jdbc:postgresql://localhost:5432/studentdb";
    private static final String USER = "admin";
    private static final String PASS = "admin";
    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connected");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return conn;
    }
}
