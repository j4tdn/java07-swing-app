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
 * @author khanh
 */
public class StudentTableModel extends AbstractTableModel{
    
    private List<Student> students;
    private final StudentService studentService; 
    
    private final StudentTableColumns[] columns;
    
    public StudentTableModel(){
        columns = StudentTableColumns.values();
        studentService = new StudentServiceImpl();
        students = studentService.getAll();
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
    public String getColumnName(int column) {
        return columns[column].getColumnName();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columns[columnIndex]==StudentTableColumns.MATH || columns[columnIndex]==StudentTableColumns.LITERATURE){
            return Double.class;
        }
        return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value =null;
        Student student = students.get(rowIndex);
        switch(columns[columnIndex]){
            case FULLNAME:
                value = student.getFullname();
                break;
            case GRADE:
                value = student.getGrade();
                break;
            case MATH:
                value = student.getMath();
                break;
            case LITERATURE:
                value = student.getLiterature();
                break;
            case COMMENT:
                value = student.getComment();
                break;
            
                
        }
        return value;
    }
    
    
}
