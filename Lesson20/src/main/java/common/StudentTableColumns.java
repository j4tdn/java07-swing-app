/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author khanh
 */
public enum StudentTableColumns {
    FULLNAME("Họ tên"),
    GRADE("Lớp"),
    MATH("Điểm toán"),
    LITERATURE("Điểm văn"),
    COMMENT("Nhận xét");
    
    private final String columnName;

    private StudentTableColumns(String columnName) {
        this.columnName = columnName;
    }
    public String getColumnName(){
        return columnName;
    }
    
}
