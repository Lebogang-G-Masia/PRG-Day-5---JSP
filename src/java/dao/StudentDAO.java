package dao;

import model.Student;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public boolean saveStudent(Student st) {
        boolean status = false;
        String sql = 
                "INSERT INTO students(first_name, last_name, email, phone, course)"
                + "VALUES(?, ?, ?, ?, ?)";
        
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, st.getFirstName());
            ps.setString(2, st.getLastName());
            ps.setString(3, st.getEmail());
            ps.setString(4, st.getPhone());
            ps.setString(5, st.getCourse());
            
            int rows = ps.executeUpdate();
            
            if (rows > 0) {
                System.out.println("Rows: " + rows);
                status = true;
            } else {
                System.out.println("No ROWS"); 
            }
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return status;
    }
    
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students ORDER BY student_id";
        
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            var rs = ps.executeQuery();
            
            while (rs.next()) {
                Student student = new Student(rs.getInt("student_id"),
                                               rs.getString("first_name"),
                                               rs.getString("last_name"),
                                               rs.getString("email"),
                                               rs.getString("phone"),
                                               rs.getString("course"));
                students.add(student);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return students;
    }
}
