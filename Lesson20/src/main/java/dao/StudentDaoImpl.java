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
import model.bean.Grade;
import model.bean.Student;

/**
 *
 * @author USER
 */
public class StudentDaoImpl implements StudentDao {

    private final ConnectionManager connection;
    private final GradeDao gradeDao;
    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;

    public StudentDaoImpl() {
        connection = new ConnectionManagerImpl();
        gradeDao = new GradeDaoImpl();
    }

    @Override
    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        Connection conn = connection.getConnection();
        List<Grade> grades = gradeDao.getAll();
        String query = "select * from student";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                Student student = new Student(rs.getInt("studentID"), rs.getString("fullname"), convertToBoolean(rs.getInt("gender")), rs.getString("hobbies"), rs.getDouble("math"), rs.getDouble("literature"), grades.get(rs.getInt("gradeID") - 1), rs.getString("avatarPath"), rs.getString("comment"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    private boolean convertToBoolean(int input) {
        return input == 1;
    }

    @Override
    public boolean save(Student student) {
        boolean flag = false;
        Connection conn = connection.getConnection();
        boolean gender = student.getGender();
        int grade = student.getGrade().getId();
        String query = "insert into student(fullname, gender, hobbies, math, literature, avatarPath, comment, gradeID)values('" + student.getFullname() + "', "
                + "'" + gender + "', '" + student.getHobbies() + "', '" + student.getMath() + "', '" + student.getLiterature() + "', '" + student.getAvatarPath() + "', "
                + "'" + student.getComment() + "', '" + grade + "')";
        try {
            pst = conn.prepareStatement(query);
            pst.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Student getStudent(int id) {
        Student student = new Student();
        Connection conn = connection.getConnection();
        List<Grade> grades = gradeDao.getAll();
        String query = "select * from student where studentID = " + id;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                student.setId(rs.getInt("studentID"));
                student.setFullname(rs.getString("fullname"));
                student.setGender(convertToBoolean(rs.getInt("gender")));
                student.setHobbies(rs.getString("hobbies"));
                student.setMath(rs.getDouble("math"));
                student.setLiterature(rs.getDouble("literature"));
                student.setAvatarPath(rs.getString("avatarPath"));
                student.setComment(rs.getString("comment"));
                student.setGrade(grades.get(rs.getInt("gradeID") - 1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public boolean update(Student student) {
        boolean flag = false;
        Connection conn = connection.getConnection();
        String query = "update student set fullname='" + student.getFullname() + "', "
                + " gender='" + student.getGender() + "', hobbies='" + student.getHobbies() + "', math='" + student.getMath() + "', literature='" + student.getLiterature() + "', avatarPath='" + student.getAvatarPath() + "', "
                + " comment='" + student.getComment() + "', grade='" + student.getGrade() + "')";
        try {
            pst = conn.prepareStatement(query);
            pst.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        Connection conn = connection.getConnection();
        String query = "delete from student where studentID = " + id;
        try {
            pst = conn.prepareStatement(query);
            pst.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

}
