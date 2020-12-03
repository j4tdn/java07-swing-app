/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import common.StudentTableColumn;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.beans.Student;
import service.StudentService;
import service.StudentServiceImpl;

/**
 *
 * @author DangHoang
 */
public class StudentTableModel extends AbstractTableModel {

    private List<Student> students;
    private final StudentService service;
    private final StudentTableColumn[] columns;

    public StudentTableModel() {
        columns = StudentTableColumn.values();
        service = new StudentServiceImpl();
        students = service.getAll();
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
        return columns[column].getNameColumn();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columns[columnIndex] == StudentTableColumn.MATH || columns[columnIndex] == StudentTableColumn.LITERATURE) {
            return Float.class;
        }
        return super.getColumnClass(columnIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = students.get(rowIndex);
        Object value = switch (columns[columnIndex]) {
            case FULLNAME ->
                student.getName();
            case GRADE ->
                student.getGrade().getName();
            case MATH ->
                student.getMath();
            case LITERATURE ->
                student.getLiterature();
            default ->
                student.getComment();
        };
        return value;
    }
}
