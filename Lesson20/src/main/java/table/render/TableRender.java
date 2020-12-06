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
 * @author USER
 */
public class TableRender {

    private TableRender() {
    }

    public static void setHorizontalAlignment(JTable table, int position) {
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(position);
        int columns = table.getColumnModel().getColumnCount();
        for (int column = 0; column < columns; column++) {
            table.getColumnModel().getColumn(column).setCellRenderer(render);
        }
    }

}
