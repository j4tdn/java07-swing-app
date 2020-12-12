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
import utils.SqlUtils;
import views.FrMain;

/**
 *
 * @author ADMIN
 */
public class StudentDaoImpl implements StudentDao {

    public final ConnectionManager connection;
    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;
    private static List<Student> students = new ArrayList<>();

    public StudentDaoImpl() {
        connection = new ConnectionManagerImpl();
    }

    @Override
    public List<Student> getAll() {
        return getListStudent();

    }

    private List<Student> mockData() {

        List<Grade> grades = Arrays.asList(
                new Grade(1, "Lớp 12T1"),
                new Grade(2, "Lớp 12T2"),
                new Grade(3, "Lớp 12T3"),
                new Grade(4, "Lớp 12T4")
        );

        students.add(new Student("102", "Hoang Anh", Boolean.TRUE, "Bóng đá, Bóng chuyền", 1.2d, 5.5d, grades.get(0), "", "Comments"));
        students.add(new Student("103", "Gia Linh", Boolean.TRUE, "Bóng đá, Bóng chuyền", 5d, 1.5d, grades.get(1), "", "Comments"));
        students.add(new Student("104", "Tran Thanh", Boolean.FALSE, "Bóng đá, Bóng chuyền", 1.5d, 2.5d, grades.get(2), "", "Comments"));
        students.add(new Student("105", "Ho Minh", Boolean.FALSE, "Bóng đá, Cầu lông,Bóng chuyền", 2.3d, 3.5d, grades.get(3), "", "Comments"));
        return students;
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
        List<Student> students = getListStudent();
        //students.stream().filter(student -> student.getId().equals(id)).findFirst().
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public List<Student> getListStudent() {
        Connection conn = connection.getConnection();

        List<Student> students = new ArrayList<>();
        String query = "select *from Student\n";
        List<Grade> grades = getListGrade();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                int gradeIndex = rs.getInt("GradeId");
                students.add(new Student(rs.getString("ID"), rs.getString("Fullname"), rs.getBoolean("Gender"), rs.getString("Hobbies"), rs.getDouble("Math"), rs.getDouble("Literature"), grades.get(gradeIndex - 1), rs.getString("AvatarPath"), rs.getString("Comment")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SqlUtils.close(rs, st, conn);
        }
        return students;
    }

    @Override
    public void addStudent(Student student) {
        Connection conn = connection.getConnection();

        List<Student> students = new ArrayList<>();
        String query = "insert into Student(ID ,Fullname,Gender,Hobbies,Math ,Literature ,GradeID ,AvatarPath ,`Comment`) value('"
                + Integer.toString(getListStudent().size() + 1) + "','"
                + student.getFullname() + "',"
                + student.getGender() + ",'"
                + student.getHobbies() + "',"
                + student.getMath() + ","
                + student.getLiterature() + ","
                + student.getGrade().getId() + ",'"
                + student.getAvatarPath() + "','"
                + student.getComment() + "');";

        try {
            st = conn.createStatement();
            st.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SqlUtils.close(rs, st, conn);
        }
    }

    @Override
    public void updateStudent(Student student) {

        Connection conn = connection.getConnection();

        List<Student> students = new ArrayList<>();
        String q = "update Student set FullName='" + student.getFullname() + "',"
                + "Gender=" + student.getGender() + ","
                + "Hobbies='" + student.getHobbies() + "',"
                + "Math=" + student.getMath() + ","
                + "Literature=" + student.getLiterature() + ","
                + "GradeID='" + student.getGrade().getId() + "',"
                + "AvatarPath='" + student.getAvatarPath() + "',"
                + "Comment='" + student.getAvatarPath() + "' "
                + "where ID='" + student.getId() + "'";

        try {
            st = conn.createStatement();
            st.executeUpdate(q);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SqlUtils.close(rs, st, conn);
        }
    }

}
