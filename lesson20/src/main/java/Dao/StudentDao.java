/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.List;
import model.been.Student;

/**
 *
 * @author Admin
 */
public interface StudentDao {
    List<Student> getAll();
    List<Student> get(String id);
}
