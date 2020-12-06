/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.bean.Grade;

/**
 *
 * @author OS
 */
public class Test {
    public static void main(String[] args) {
        StudentDao s = new StudentDaoImpl();
        s.update(1, "Phan Văn B", Boolean.TRUE, "Bóng đá, Cầu lông", 7.2d, 8.1d, new Grade(1, "17T1"), "path", "Nhất lớp");
    }
}
