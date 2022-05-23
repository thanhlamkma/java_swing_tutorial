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
import model.Class;

/**
 *
 * @author LAPTOP
 */
public class ClassDao {
    
    public List<Class> getAllClasses(){
        
        List <Class> classes = new ArrayList<Class>();
        
        Connection conn = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM lophoc";
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                Class lophoc = new Class();
                
                lophoc.setClassID(rs.getString("classid"));
                lophoc.setClassName(rs.getString("classname"));
                lophoc.setNumber(rs.getInt("number"));
                
                classes.add(lophoc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return classes;
    }
    
    public static void main(String[] args) {
        ClassDao st = new ClassDao();
        System.out.println("Lop hoc: " + st.getAllClasses());
    }
}
