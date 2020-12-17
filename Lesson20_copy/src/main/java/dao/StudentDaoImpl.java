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

/**
 *
 * @author ADMIN
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
    public List<Student> getAll() {
        // mock data
        // return mockData();
        
        List<Student> students=new ArrayList<>();
        Connection conn = connection.getConnection();
        String query = "select * from student";
        
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                Student student = new Student(rs.getString("id"), rs.getString("name"),(rs.getInt("gender")!=0)?true:false,rs.getString("hobbies"),rs.getDouble("math"),rs.getDouble("literature"),convertedGrade(rs.getString("grade")),rs.getString("avatar"),rs.getString("comment"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SqlUtils.close(rs, st, conn);
        }
        return students;
    }
    
    private Grade convertedGrade(String stringGrade){
        List<Grade> grades = Arrays.asList(
                new Grade(1, "Lớp 11T1"),
                new Grade(2, "Lớp 12T2"),
                new Grade(3, "Lớp 13T3"),
                new Grade(4, "Lớp 14T4")
        );
        for (Grade grade:grades){
            if(grade.getName().equals(stringGrade)) {
                return grade;
            }
        }
        return null;
    }
    
    @Override
    public Student get(String id) {
        /*
        List<Student> students = mockData();
        return students.stream().filter(student -> id.equals(student.getId())) // filter tra ve stream
                .findFirst() // find first tra ve optional(co hoac khong)
                .orElse(null);
        */
        List<Student> students = getAll();
        return students.stream().filter(student -> id.equals(student.getId())) // filter tra ve stream
                .findFirst() // find first tra ve optional(co hoac khong)
                .orElse(null);
    }
    
    @Override
    public boolean updateStudent(Student student) {
        Connection conn = connection.getConnection();
        String query = "update student set name = ?, gender = ?, hobbies = ?, math = ?, literature = ?, grade = ?, comment = ?, avatar = ? where id = ?";
        int affectedRows = 0;
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, student.getFullname());
            pst.setInt(2,(student.getGender())?1:0);
            pst.setString(3, student.getHobbies());
            pst.setDouble(4, student.getMath());
            pst.setDouble(5, student.getLiterature());
            pst.setString(6, student.getGrade().getName());
            pst.setString(7, student.getComment());
            pst.setString(8, student.getAvatarPath());
            pst.setInt(9, Integer.parseInt(student.getId()));
            affectedRows = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SqlUtils.close(pst, conn);
        }
        return (affectedRows > 0);
    }

    private List<Student> mockData() {
        List<Grade> grades = Arrays.asList(
                new Grade(1, "Lớp 11T1"),
                new Grade(2, "Lớp 12T2"),
                new Grade(3, "Lớp 13T3"),
                new Grade(4, "Lớp 14T4")
        );
        List<Student> students = new ArrayList<>();
        students.add(new Student("102", "Le Na", Boolean.TRUE, "Bóng đá, Bóng chuyền", 8.2d, 7.8d, grades.get(0), "", "Comment"));
        students.add(new Student("103", "Le Thanh", Boolean.FALSE, "Bóng chuyền", 8.2d, 8.8d, grades.get(1), "", "Comment"));
        students.add(new Student("104", "Le Lien", Boolean.TRUE, "Bóng đá, Bóng chuyền", 8.6d, 7.8d, grades.get(2), "", "Comment"));
        students.add(new Student("105", "Le Hung", Boolean.FALSE, "Bóng đá", 8.2d, 9.8d, grades.get(0), "", "Comment"));
        return students;
    }

    @Override
    public int addStudent(Student student) {
        int id=-1;
        Connection conn = connection.getConnection();
        String query = "INSERT INTO student (`name`, `gender`, `hobbies`, `math`, `literature`, `grade`, `comment`, `avatar`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        int affectedRows = 0;
        try {
            pst = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, student.getFullname());
            pst.setInt(2,(student.getGender())?1:0);
            pst.setString(3, student.getHobbies());
            pst.setDouble(4, student.getMath());
            pst.setDouble(5, student.getLiterature());
            pst.setString(6, student.getGrade().getName());
            pst.setString(7, student.getComment());
            pst.setString(8, student.getAvatarPath());
            affectedRows = pst.executeUpdate();
            if(affectedRows>0){
                rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    id=rs.getInt(1);
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SqlUtils.close(pst, conn);
        }
        return id;
    }
    
    // SELECT * FROM Table ORDER BY ID DESC LIMIT 1
}
