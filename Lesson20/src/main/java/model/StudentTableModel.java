/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import common.StudentTableColumns;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Student;
import service.StudentService;
import service.StudentServiceImpl;

/**
 *
 * @author Asus
 */
public class StudentTableModel extends AbstractTableModel{
    private List<Student> students;
    private StudentService studentService;
    private final StudentTableColumns[] colums ;
        
    
    public StudentTableModel(){
        colums = StudentTableColumns.values();
        studentService = new StudentServiceImpl();
        students = studentService.getAll();
        
    }

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return colums.length;
    }

    @Override
    public String getColumnName(int column) {
        return colums[column].getColumnName();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(colums[columnIndex]  ==    StudentTableColumns.MATH||colums[columnIndex]==StudentTableColumns.LITERATURE){
            return Double.class;
        }
        return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value = null;
        Student student = students.get(rowIndex);
        switch(colums[columnIndex]){
            case FULLNAME:
                value =student.getFullname();
                break;
            case GRADE:
                value =student.getGrade().getName();
                break;
            case MATH:
                value =student.getMatch();
                break;
            case LITERATURE:
                value =student.getLiterature();
                break;
            case COMMENT:
                value =student.getComment();
                break;    
        }
        
        
        return value;
    }
    
    
    
}
