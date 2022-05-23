/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;

/**
 *
 * @author LAPTOP
 */
public class StudentDao {
    
    public List<Student> getAllStudents(){
        
        List <Student> students = new ArrayList<Student>();
        
        Connection conn = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM hocsinh";
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                Student st = new Student();
                
                st.setStudentId(rs.getString("studentid"));
                st.setStudentName(rs.getString("studentname"));
                st.setAddress(rs.getString("address"));
                
                students.add(st);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }
    
    public static void main(String[] args) {
        StudentDao st = new StudentDao();
        System.out.println("Sinh vien: " + st.getAllStudents());
    }
}
