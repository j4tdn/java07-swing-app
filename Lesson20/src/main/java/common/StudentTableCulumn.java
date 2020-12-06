/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author OS
 */
public enum StudentTableCulumn {
    ID("Id"),
    FULLNAME("Họ Tên"),
    GRADE("Lớp"),
    MATH("Điểm Toán"),
    LITERATURE("Điểm Văn"),
    COMMENT("Nhận xét");
    
    private String columnName;

    private StudentTableCulumn(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }

}
