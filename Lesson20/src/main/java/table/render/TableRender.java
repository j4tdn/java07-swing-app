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
 * @author Asus
 */
public class TableRender {
    private TableRender() {
    }

    public static void setHorizontalAlignment(JTable table, int position) {
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(position);
        int column = table.getColumnModel().getColumnCount();
        for (int i = 0; i < column; i++) {
            setHorizontalAlignment(table, i, position);
        }
    }

    public static void setHorizontalAlignment(JTable table, int indexColumn, int position) {
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(position);
        table.getColumnModel().getColumn(indexColumn).setCellRenderer(render);
    }
    
}
