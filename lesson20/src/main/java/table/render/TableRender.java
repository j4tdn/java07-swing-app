/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table.render;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Admin
 */
public class TableRender {

    private TableRender() {
    }

    public static void setHorizontalAligment(JTable table, int column, int position) {
        DefaultTableCellRenderer renderen = new DefaultTableCellRenderer();
        renderen.setHorizontalAlignment(position);
        table.getColumnModel().getColumn(column).setCellRenderer(renderen);
    }

    public static void setHorizontalAligment(JTable table, int position) {
        DefaultTableCellRenderer renderen = new DefaultTableCellRenderer();
        renderen.setHorizontalAlignment(position);
        int columns = table.getColumnModel().getColumnCount();
       // for(int columns = 0)
    }
}
