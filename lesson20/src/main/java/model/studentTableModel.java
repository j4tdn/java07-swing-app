/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import common.StudentTableColum;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import service.StudentService;
import service.StudentServiceImpl;

/**
 *
 * @author Admin
 */
public class studentTableModel extends AbstractTableModel{
    private final List<Student> student;
    private final StudentService studentService;
    private final StudentTableColum[] colums;
    public studentTableModel(){
        colums = StudentTableColum.values();
        studentService = new StudentServiceImpl();
        student = studentService.getAll();
    }
    @Override
    public int getRowCount() {
        return student.size();
    }

    @Override
    public int getColumnCount() {
        return colums.length;
    }
    @Override
    public String getColumnName(int column){
        return colums[column].getColumnName();
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value = null;
        Student student = this.student.get(rowIndex);
        switch(colums[columnIndex]){
            case FULLNAME:value = student.getFullname();
            case GRADE:value = student.getGrade().getName();
             case MATH:value = student.getMathl();
             case LITERATURE:value = student.getLiterature();
             case COMENT:value = student.getComment();
      
        }
        return value;
    }
    @Override
    public Class<?> getColumnClass(int columnIndex){
        if(colums[columnIndex] == StudentTableColum.MATH ||colums[columnIndex] == StudentTableColum.LITERATURE ){
            return Double.class;
        }
        return super.getColumnClass(columnIndex);
    }      
    
}
