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
import model.beans.Grade;
import model.beans.Student;
import model.beans.StudentRaw;
import utils.SqlUtils;

/**
 *
 * @author DangHoang
 */
public class StudentDaoImpl implements StudentDao {

    private final ConnectionManager connection;
    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;

    public StudentDaoImpl() {
        connection = new ConnectionManagerImpl();
    }

    @Override
    public List<StudentRaw> getAll() {
        List<StudentRaw> students = new ArrayList<>();
        Connection con = connection.getConnection();
        String query = "SELECT * FROM sinhvien";

        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                StudentRaw student = new StudentRaw(rs.getString("Id"), rs.getString("Name"), rs.getString("IdGrade"), rs.getBoolean("Gender"),
                        rs.getString("Hobbies"), rs.getFloat("Math"), rs.getFloat("Literature"), rs.getString("Comment"), rs.getString("Avatar"));
                students.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            SqlUtils.close(rs, st, con);
        }

        return students;
    }

    @Override
    public List<Grade> getGrade() {
        List<Grade> grades = new ArrayList<>();
        Connection con = connection.getConnection();
        String query = "SELECT * FROM grade";

        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                Grade grade = new Grade(rs.getString("IdGrade"), rs.getString("Name"));
                grades.add(grade);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            SqlUtils.close(rs, st, con);
        }

        return grades;
    }

    @Override
    public boolean addStudent(Student student) {
        int affectedRows = 0;
        Connection con = connection.getConnection();
        String query = "INSERT INTO `sinhvien` VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            pst = con.prepareStatement(query);
            pst.setString(1, student.getId());
            pst.setString(2, student.getName());
            pst.setBoolean(3, student.getGender());
            pst.setString(4, student.getBobbies());
            pst.setFloat(5, student.getMath());
            pst.setFloat(6, student.getLiterature());
            pst.setString(7, student.getComment());
            pst.setString(8, student.getImagePath());
            pst.setString(9, student.getGrade().getId());
            affectedRows = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            SqlUtils.close(pst, con);
        }
        return affectedRows != 0;
    }

    @Override
    public boolean updateStudent(Student student) {
        int affectedRows = 0;
        Connection con = connection.getConnection();
        String query = "UPDATE `sinhvien` SET Name = ? , Gender = ? , Hobbies = ? , "
                + "Math = ? , Literature = ? , Comment = ? , Avatar = ? , IdGrade = ? WHERE Id = ?";

        try {
            pst = con.prepareStatement(query);
            pst.setString(1, student.getName());
            pst.setBoolean(2, student.getGender());
            pst.setString(3, student.getBobbies());
            pst.setFloat(4, student.getMath());
            pst.setFloat(5, student.getLiterature());
            pst.setString(6, student.getComment());
            pst.setString(7, student.getImagePath());
            pst.setString(8, student.getGrade().getId());
            pst.setString(9, student.getId());
            affectedRows = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            SqlUtils.close(pst, con);
        }
        return affectedRows != 0;
    }

//    @Override
//    public StudentRaw getStudent(String id) {
//        StudentRaw student = null;
//        Connection con = connection.getConnection();
//        String query = "SELECT * FROM `sinhvien` WHERE Id = " + id;
//
//        try {
//            st = con.createStatement();
//            rs = st.executeQuery(query);
//            while (rs.next()) {
//                student = new StudentRaw(rs.getString("Id"), rs.getString("Name"), rs.getString("IdGrade"), rs.getBoolean("Gender"),
//                        rs.getString("Hobbies"), rs.getFloat("Math"), rs.getFloat("Literature"),
//                        rs.getString("Comment"), rs.getString("Avatar"));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            SqlUtils.close(pst, con);
//        }
//        return student;
//    }
}
