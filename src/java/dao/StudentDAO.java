package dao;

import model.Student;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {
    public boolean saveStudent(Student st) {
        boolean status = false;
        String sql = 
                "INSERT INTO Students(fname, lname, email, phone, course)"
                + "VALUES(?, ?, ?, ?, ?)";
        
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, st.getFirstName());
            ps.setString(1, st.getLastName());
            ps.setString(1, st.getEmail());
            ps.setString(1, st.getPhone());
            ps.setString(1, st.getCourse());
            
            int rows = ps.executeUpdate();
            
            if (rows > 0) {
                status = true;
            }
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return status;
    }
}
