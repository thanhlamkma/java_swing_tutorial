/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ClassDao;
import java.util.List;
import model.Class;


/**
 *
 * @author LAPTOP
 */
public class ClassService {
    private ClassDao classDao;

    public ClassService() {
        classDao = new ClassDao();
    }
      
    public List<Class> getAllClasses() {
        return classDao.getAllClasses();
    }
}
