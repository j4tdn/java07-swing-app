/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author Asus
 */
public enum StudentTableColumn {
    ID("Id"),
    FULLNAME("Họ Tên"),
    GRADE("Lớp"),
    MATH("Điểm Toán"),
    LITERATURE("Điểm Văn"),
    COMMENT("Nhận Xét");
    
    private final String columnName;

    private StudentTableColumn(String columnName) {
        this.columnName = columnName;
    }
    
    public String getColumnName(){
        return columnName;
    }
    
    
    
}
