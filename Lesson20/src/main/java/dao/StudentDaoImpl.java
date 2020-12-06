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
import model.bean.Grade;
import model.bean.Student;
import util.SqlUtils;

/**
 *
 * @author ADMIN
 */
public class StudentDaoImpl implements StudentDao {

    public final ConnectionManager connection;
    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;

    public StudentDaoImpl() {
        connection = new ConnectionManagerImpl();
    }

    @Override
    public List<Student> getAll() {
        //
        return mockData();
    }

    private List<Student> mockData() {

        List<Grade> grades = Arrays.asList(
                new Grade(1, "Lớp 12T1"),
                new Grade(1, "Lớp 12T2"),
                new Grade(1, "Lớp 12T3"),
                new Grade(1, "Lớp 12T4")
        );

        List<Student> students = new ArrayList<>();
        students.add(new Student("102", "Le S", Boolean.TRUE, "bóng đá ,bóng chuyền", 1.2d, 5.5d, grades.get(0), "", "Comments"));
        students.add(new Student("103", "Le A", Boolean.TRUE, "bóng đá ,bóng chuyền", 5d, 1.5d, grades.get(1), "", "Comments"));
        students.add(new Student("104", "Le B", Boolean.TRUE, "bóng đá ,bóng chuyền", 1.5d, 2.5d, grades.get(2), "", "Comments"));
        students.add(new Student("105", "le V", Boolean.TRUE, "bóng đá ,bóng chuyền", 2.3d, 3.5d, grades.get(3), "", "Comments"));

        return students;
    }

    private List<Student> listStudent() {
        Connection conn = connection.getConnection();
        List<Student> students = new ArrayList<>();
        String query = "select *\n" + "from Student\n";
        List<Grade> grades = getListGrade();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                int gradeIndex = rs.getInt("GradeId");
                students.add(new Student(rs.getString("ID"), rs.getString("Fullname"), rs.getBoolean(""), rs.getString("Hobbies"), rs.getDouble("Math"), rs.getDouble("Literature"), grades.get(gradeIndex), rs.getString("AvatarPath"), rs.getString("Comment")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SqlUtils.close(rs, st, conn);
        }
        return students;
    }

    @Override
    public void addStudent(String id, String fullname, Boolean gender, String hobbies, Double math, Double literature, Grade gradeID, String avatarPath, String comments) {

        Connection conn = connection.getConnection();
        List<Grade> grades = new ArrayList<>();
        String query = "insert into student(ID,fullname,Gender,hobbies,math,literature,gradeID,avatarPath,Comments) value("
                + id + "," + fullname + "," + gender + "," + hobbies + "," + math + "," + literature + "," + gradeID + "," + avatarPath + "," + comments
                + ")";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                grades.add(new Grade(rs.getInt("ID"), rs.getString("GradeName")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SqlUtils.close(rs, st, conn);
        }
    }

    @Override
    public List<Grade> getListGrade() {
        Connection conn = connection.getConnection();
        List<Grade> grades = new ArrayList<>();
        String query = "select *\n" + "from Grade\n";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                grades.add(new Grade(rs.getInt("ID"), rs.getString("GradeName")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SqlUtils.close(rs, st, conn);
        }
        return grades;
    }

    @Override
    public Student get(String id) {
        List<Student> students = mockData();
         //students.stream().filter(student -> student.getId().equals(id)).findFirst().
        return null;
    }

}
