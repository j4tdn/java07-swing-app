/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import common.StudentTableColms;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Student;
import service.studentService;
import service.studentServiceImpl;

/**
 *
 * @author Trung
 */
public class StudentTableModel extends AbstractTableModel{

    private List<Student> students;
    private studentService studentSerivce;
    private final StudentTableColms[] columns;
    public StudentTableModel() {
        columns=StudentTableColms.values();
        studentSerivce=(studentService) new studentServiceImpl();
        students=studentSerivce.getAll();
    }
    

    @Override
    public int getRowCount() {
         return students.size();
    }
    

    @Override
    public int getColumnCount() {
       return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value=null;
        Student student=students.get(rowIndex);
        switch(columns[columnIndex]){
            case FULLNAME:
                value=student.getFullname();
                break;
                case GRADE:
                value=student.getGrade().getFullname();
                break;
                case MATH:
                value=student.getMath();
                break;
                case LITERATRE:
                value=student.getLiterature();
                break;
                case COMMENT:
                value=student.getComment();
                break;
                
        }
        return value;
    }

    

    
}
