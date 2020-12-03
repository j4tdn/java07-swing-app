/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import dao.StudentDao;
import java.util.ArrayList;
import java.util.List;
import model.bean.Student;
import model.bean.grade;

/**
 *
 * @author Trung
 */
public class StudentDaoImpl implements StudentDao{

    public StudentDaoImpl() {
    }

    @Override
    public List<Student> getAll() {
        return mockData();
    }

    private List<Student> mockData(){
    List<Student> students=new ArrayList<>();
    students.add(new Student("sv01", "Le Teo",true, "lol", 9d, 9d, new grade(2, "16t2"), "", "ngu"));
    return students;
}
}