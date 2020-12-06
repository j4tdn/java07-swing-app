/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author Admin
 */
public enum StudentTableColum {
    ID("MSSV"),
    FULLNAME("Họ Tên"),
    GRADE("Lớp"),
    MATH("Điểm Toán"),
    LITERATURE("Điểm Văn"),
    COMENT("Nhận Xét");
    
    private final String columnName;
    StudentTableColum(String columnName){
        this.columnName = columnName;
    }
    public String getColumnName(){
        return columnName;
    }
}

