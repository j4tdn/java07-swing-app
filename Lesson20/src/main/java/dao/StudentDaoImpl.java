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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            rs = pst.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String fullname = rs.getString(2);
                Boolean gender = rs.getBoolean(3);
                String hobbies = rs.getString(4);
                Double math = rs.getDouble(5);
                Double literature = rs.getDouble(6);
                Integer grade_id = rs.getInt(7);
                Grade grade = grades.stream().filter(s -> s.getId().equals(grade_id)).findFirst().get();
                String avatarPath = rs.getString(8);
                String comment = rs.getString(9);
                students.add(new Student(id, fullname, gender, hobbies, math, literature, grade, avatarPath, comment));

            }
        } catch (SQLException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        } finally {
            close();
        }

        return grades;
    }

    @Override
    public Integer addStudent(Student student) {
        Connection conn = connection.getConnection();
        String sql = "insert into student(fullname, gender, hobbies, math, literature, grade_id, avatar, comment)"
                + " values( ?, ?, ?, ?, ?, ?,?, ?)";
        int id = -1;

        try {
            pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, student.getFullname());
            pst.setBoolean(2, student.getGender());
            pst.setString(3, student.getHobbies());
            pst.setDouble(4, student.getMath());
            pst.setDouble(5, student.getLiterature());
            pst.setInt(6, student.getGrade().getId());
            pst.setString(7, student.getAvatarPath());
            pst.setString(8, student.getComment());
            pst.executeUpdate();
            rs = pst.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;
    }

    @Override
    public Student get(String id) {
        List<Student> students = getAll();
        return students.stream().filter(s -> s.getId().equals(id)).findFirst().get();
    }

    @Override
    public boolean updateStudent(Student student) {
        int check = 0;
        Connection conn = connection.getConnection();
        String sql = "update student set fullname = ?, gender = ?, hobbies = ?, math = ?, literature = ?, "
                + "grade_id = ?, avatar = ?, comment = ? where id = ?";

        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, student.getFullname());
            pst.setBoolean(2, student.getGender());
            pst.setString(3, student.getHobbies());
            pst.setDouble(4, student.getMath());
            pst.setDouble(5, student.getLiterature());
            pst.setInt(6, student.getGrade().getId());
            pst.setString(7, student.getAvatarPath());
            pst.setString(8, student.getComment());
            pst.setInt(9,Integer.parseInt(student.getId()));
            check = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return check!=0 ;
    }

    @Override
    public boolean deleteStudent(Student student) {
        int check = 0;
        Connection conn = connection.getConnection();
        String sql = "delete from student where id = ?";
        
        try {
            pst=conn.prepareStatement(sql);
            pst.setInt(1,Integer.parseInt(student.getId()));
            check =pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return check!=0 ;
    }
}
