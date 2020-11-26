/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author DangHoang
 */
public class Ex03Grid extends JFrame{

    private final Container con = getContentPane();
    private final GridLayout gridLayout = new GridLayout(5, 5);
    private final Font font = new Font("Tahoma", Font.PLAIN, 13);
    
    public Ex03Grid() {
        initComponents();
        initEvents();
    }

    private void initComponents() {
        setSize(1080, 600);
        con.setLayout(gridLayout);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        addRooms(26);
    }

    private void addRooms(int rooms) {
        for (int i = 1; i <= rooms; i++) {
            JButton button = new JButton();
            button.setText("Room " + (100 + i));
            button.setFont(font);
            button.setFocusable(false);
            con.add(button);
        }
    }
    
    private void initEvents() {
    }
    
    public static void main(String[] args) {
        new Ex03Grid().setVisible(true);
    }
}
