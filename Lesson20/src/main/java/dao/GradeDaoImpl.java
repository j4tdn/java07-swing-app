/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Grade;
import model.bean.Student;
import utils.SqlUtils;

/**
 *
 * @author OS
 */
public class GradeDaoImpl implements GradeDao{

    private final ConnectionManager manager;
    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;

    public GradeDaoImpl() {
        manager = new ConnectionManagerImpl();
    }

    @Override
    public List<Grade> getAll() {
        List<Grade> grades = new ArrayList<>();
        Connection connection = manager.getConnection();
        String query = "SELECT * \n" +
                        "FROM GRADE \n";
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()) {
                Grade grade = new Grade(rs.getInt("GradeId"), rs.getString("NameGrade"));
                grades.add(grade);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            SqlUtils.close(rs, st, connection);
        }
        return grades;
    }
    
}
