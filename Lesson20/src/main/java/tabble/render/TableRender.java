/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabble.render;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author khanh
 */
public class TableRender {
    
    private  TableRender(){
        
    }
    public static void setHorizontalAligment(JTable table,int column,int position ){
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(position);
        table.getColumnModel().getColumn(column).setCellRenderer(renderer);
    }
    public static void setHorizontalAligment(JTable table,int position ){
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(position);
        int columns = table.getColumnCount();
        for(int column=0;column<columns;column++){
                    table.getColumnModel().getColumn(column).setCellRenderer(renderer);
        }
    }
}
