/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import common.StudentTableColumn;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import model.beans.Student;
import service.StudentService;
import service.StudentServiceImpl;
import static table.render.TableRender.setHorizontalAlignment;

/**
 *
 * @author DangHoang
 */
public class StudentTableModel extends AbstractTableModel {

    private final Font font = new Font("Tahoma", Font.PLAIN, 13);
    private final List<Student> students;
    private final StudentService service;
    private final StudentTableColumn[] columns;
    private final JTable tbStudent;

    public StudentTableModel(JTable tbStudent) {
        this.tbStudent = tbStudent;
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
            case ID ->
                student.getId();
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

    public void loadData() {
        tbStudent.setModel(this);
    }

    public void cssForTable() {
        tbStudent.setFont(font);
        tbStudent.setRowHeight(20);
        tbStudent.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tbStudent.getTableHeader().setReorderingAllowed(false);
        tbStudent.getTableHeader().setPreferredSize(new Dimension(0, 35));
        tbStudent.getTableHeader().setFont(font);

        tbStudent.getColumnModel().getColumn(0).setMaxWidth(0);
        tbStudent.getColumnModel().getColumn(0).setMinWidth(0);

        setHorizontalAlignment(tbStudent, SwingConstants.CENTER);
    }
}
