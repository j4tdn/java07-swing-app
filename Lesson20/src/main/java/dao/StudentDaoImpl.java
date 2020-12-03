/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.model.Grade;
import java.util.ArrayList;
import java.util.List;
import model.beans.Student;

/**
 *
 * @author DangHoang
 */
public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> getAll() {
        return mockData();
    }

    private List<Student> mockData() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("sv01", "Lê Tèo", new Grade(1, "16T1"), true, "Đá bóng", 9f, 9f, "Hơi non", ""));
        students.add(new Student("sv02", "Lê Na", new Grade(2, "16T2"), false, "Cầu lông", 9.5f, 8.9f, "non", ""));
        return students;
    }
}
