/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author ADMIN
 */
public enum StudentTableColumns {
    ID("MSSV"),
    FULLNAME("Họ tên"),
    GRADE("Lớp"),
    MATH("Điểm Toán"),
    LITERATURE("Điểm Văn"),
    COMMENT("Nhận xét");

    private final String columnName;

    StudentTableColumns(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }
}
