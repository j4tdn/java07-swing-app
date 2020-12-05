/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import model.bean.Grade;
import model.bean.Student;
import static utils.SqlUtils.*;

/**
 *
 * @author khanh
 */
public class StudentDaoImpl implements StudentDao {

    private final ConnectionManager connection;
    private PreparedStatement pst;
    private ResultSet rs;

    public StudentDaoImpl() {
        connection = new ConnectionManagerImpl();
    }

    @Override
    public List<Student> getAll() {
        List<Grade> grades = getAllGrade();
        List<Student> students = new ArrayList<>();
        Connection conn = connection.getConnection();
        String sql = "select * from student";
        
        try {
            pst = conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                String id = rs.getString(1);
                String fullname =rs.getString(2);
                Boolean gender =rs.getBoolean(3);
                String hobbies = rs.getString(4);
                Double math = rs.getDouble(5);
                Double literature =rs.getDouble(6);
                Integer grade_id = rs.getInt(7);
                Grade grade  =grades.stream().filter(s->s.getId().equals(grade_id)).findFirst().get();
                String avatarPath  = rs.getString(8);
                String comment = rs.getString(9);
                students.add(new Student(id, fullname, gender, hobbies, math, literature, grade, avatarPath, comment));
                   
            }
        } catch (SQLException e) {
        }
        
        return students;
    }
    

    @Override
    public List<Grade> getAllGrade() {
        List<Grade> grades = new ArrayList<>();
        Connection conn = connection.getConnection();
        String sql = "select * from grade";

        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt(1);
                String name = rs.getString(2);
                grades.add(new Grade(id, name));
            }

        } catch (SQLException e) {
        } finally {
            close();
        }

        return grades;
    }

}
