/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import common.StudentTableCulumn;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import model.bean.Student;
import service.StudentService;
import service.StudentServiceImpl;
import table.render.TableRender;

/**
 *
 * @author OS
 */
public class StudentTableModel extends AbstractTableModel{
    
    private List<Student> students;
    private final StudentService studentService;
    private final StudentTableCulumn[] columns;
    private final JTable table;
    
    public StudentTableModel(JTable table) {
        this.table = table;
        columns = StudentTableCulumn.values();
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value = null;
        Student student = students.get(rowIndex);
        switch(columns[columnIndex]) {
            case ID:
                value = student.getId();
                break;
            case FULLNAME:
                value = student.getFullname();
                break;
            case GRADE:
                value = student.getGrade().getName();
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

    @Override
    public String getColumnName(int column) {
        return columns[column].getColumnName();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columns[columnIndex] == StudentTableCulumn.MATH || columns[columnIndex] == StudentTableCulumn.LITERATURE) {
            return Double.class;
        }
        return super.getColumnClass(columnIndex);
    }
        
    public void cssForTable() {
        Font font = new Font("Tahoma", Font.PLAIN, 18);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setFont(font);
        table.getTableHeader().setPreferredSize(new Dimension(0, 32));
        table.setFont(font);
        table.setRowHeight(26);
        TableRender.setHorizontalAlignMent(table, SwingConstants.CENTER);
    }
    
    public void loadData() {
        table.setModel(this);
    }
         
}
