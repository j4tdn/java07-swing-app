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
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Grade;
import model.bean.Student;
import utils.SqlUtils;

/**
 *
 * @author OS
 */
public class StudentDaoImpl implements StudentDao{
    
    private final ConnectionManager manager;
    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;

    public StudentDaoImpl() {
        manager = new ConnectionManagerImpl();
    }

    @Override
    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        Connection connection = manager.getConnection();
        String query = "SELECT * \n" +
                        "FROM STUDENT \n" +
                        "JOIN GRADE\n" +
                        "ON STUDENT.GRADEID = GRADE.GRADEID";
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()) {
                Grade grade = new Grade(rs.getInt("GradeId"), rs.getString("NameGrade"));
                Student student = new Student(
                        rs.getInt("StudentId") + "", 
                        rs.getString("FullName"), 
                        rs.getBoolean("Gender"),
                        rs.getString("Hobbies"), 
                        rs.getDouble("Math"), 
                        rs.getDouble("Literature"), 
                        grade, 
                        rs.getString("AvatarPath"), 
                        rs.getString("Comments"));
                students.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            SqlUtils.close(rs, st, connection);
        }
        return students;
    }
    
    private List<Student> mockData() {
        List<Grade> grades = Arrays.asList(
                new Grade(1, "17T1"),
                new Grade(2, "17T2"),
                new Grade(3, "17T3"),
                new Grade(4, "17T4"));
        List<Student> students = new ArrayList<>();
        students.add(new Student("102", "Le Na", Boolean.TRUE, "Bóng đá, bóng chuyền", 8.2d, 8.2d, grades.get(0), "", "học ngu"));
        students.add(new Student("103", "Xuân Nguyệt", Boolean.FALSE, "Bóng đá, bóng chuyền", 8.2d, 8.2d, grades.get(1), "", "học ngu"));
        students.add(new Student("104", "Phan A", Boolean.FALSE, "Bóng đá, bóng chuyền", 8.2d, 8.2d, grades.get(2), "", "học ngu"));
        return students;
    }

    @Override
    public int insert(String fullname, Boolean gender, String hobbies, Double math, Double literature, Grade grade, String avartarPath, String comment) {
        int result = 0;
        Connection connection = manager.getConnection();
        String query = "INSERT INTO \n" +
                        "STUDENT(FullName, Gender, Hobbies, Math, Literature, AvatarPath, Comments, GradeId)\n" +
                        "value(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            pst = connection.prepareStatement(query);
            pst.setString(1, fullname);
            pst.setBoolean(2, gender);
            pst.setString(3, hobbies);
            pst.setDouble(4, math);
            pst.setDouble(5, literature);
            pst.setString(6, avartarPath);
            pst.setString(7, comment);
            pst.setInt(8, grade.getId());
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            SqlUtils.close(pst, connection);
        }
        return result;
    }

    @Override
    public int update(int id, String fullname, Boolean gender, String hobbies, Double math, Double literature, Grade grade, String avartarPath, String comment) {
        int result = 0;
        Connection connection = manager.getConnection();
        String query = "UPDATE `school`.`student` "
                + "SET `FullName` = ?, "
                + "`Gender` = ?, `"
                + "Hobbies` = ?, "
                + "`Math` = ?, "
                + "`Literature` = ?, "
                + "`AvatarPath` = ?, "
                + "`Comments` = ?, "
                + "`GradeId` = ?"
                + " WHERE StudentId = ?";
        try {
            pst = connection.prepareStatement(query);
            pst.setString(1, fullname);
            pst.setBoolean(2, gender);
            pst.setString(3, hobbies);
            pst.setDouble(4, math);
            pst.setDouble(5, literature);
            pst.setString(6, avartarPath);
            pst.setString(7, comment);
            pst.setInt(8, grade.getId());
            pst.setInt(9, id);
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            SqlUtils.close(pst, connection);
        }
        return result;
    }

    @Override
    public Student get(int id) {
        Connection connection = manager.getConnection();
        Student student = null;
        String query = "SELECT * \n" +
                        "FROM STUDENT \n" +
                        "JOIN GRADE\n" +
                        "ON STUDENT.GRADEID = GRADE.GRADEID " +
                        "WHERE STUDENTID = ?";
        try {
            pst = connection.prepareStatement(query);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if(!rs.next()) {
                return null;
            } else {
                Grade grade = new Grade(rs.getInt("GradeId"), rs.getString("NameGrade"));
                student = new Student(
                        rs.getInt("StudentId") + "", 
                        rs.getString("FullName"), 
                        rs.getBoolean("Gender"),
                        rs.getString("Hobbies"), 
                        rs.getDouble("Math"), 
                        rs.getDouble("Literature"), 
                        grade, 
                        rs.getString("AvatarPath"), 
                        rs.getString("Comments"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            SqlUtils.close(rs, st, connection);
        }
        return student;
    }
    
}
