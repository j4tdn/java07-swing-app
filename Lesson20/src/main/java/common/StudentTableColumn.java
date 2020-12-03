/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author DangHoang
 */
public enum StudentTableColumn {
    FULLNAME("Họ tên"),
    GRADE("Lớp"),
    MATH("Toán"),
    LITERATURE("Văn"),
    COMMENT("Nhận xét");

    private final String nameColumn;

    StudentTableColumn(String nameColumn) {
        this.nameColumn = nameColumn;
    }

    public String getNameColumn() {
        return nameColumn;
    }
}