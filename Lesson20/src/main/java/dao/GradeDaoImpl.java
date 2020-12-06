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
import model.bean.Grade;
import utils.SqlUtils;

/**
 *
 * @author USER
 */
public class GradeDaoImpl implements GradeDao{
    
    private final ConnectionManager connection;
    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;

    public GradeDaoImpl() {
        connection = new ConnectionManagerImpl();
    }
    
    @Override
    public List<Grade> getAll() {
        List<Grade> grades = new ArrayList<>();
        Connection conn = connection.getConnection();
        String query = "select * from grade";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                Grade grade = new Grade(rs.getInt("gradeID"), rs.getString("name"));
                grades.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SqlUtils.close(rs, st, conn);
        }
        return grades;
    }
    
}
