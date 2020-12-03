/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author Trung
 */
public enum StudentTableColms {
    FULLNAME("Ho ten"),
    GRADE("Lop"),
    MATH("Diem toan"),
    LITERATRE("Diem van"),
    COMMENT("Nhan xet");

    private String columnName;

    private StudentTableColms() {
    }

    private StudentTableColms(String columname) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }
}
