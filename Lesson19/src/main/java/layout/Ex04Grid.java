/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import static java.awt.BorderLayout.*;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import static javax.swing.JSplitPane.*;

/**
 *
 * @author OS
 */
public class Ex04Grid extends JFrame{
   
    private final Container conn = getContentPane();
    private final GridLayout gridLayout = new GridLayout(5, 0);

    public Ex04Grid() {
        //UI
        initComponents();
        //Events
        initEvents();
    }
    
    private void initComponents() {
        setTitle("JAVA07 - GridLayout");
        setSize(1080, 700);
        setLocationRelativeTo(null);
        Image image = new ImageIcon(getClass().getResource("/images/48px_like.png")).getImage();
        setIconImage(image);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        conn.setLayout(gridLayout);
        addRooms(26);
    }
    
    private void initEvents() {
        
    }
    
    public static void main(String[] args) {
        Ex04Grid app = new Ex04Grid();
        app.setVisible(true);
    }

    private void addRooms(int rooms) {
        for (int i = 1; i <= rooms; i++) {
            JButton button = new JButton();
            button.setText("Room " + (100 + i));
            button.setFocusPainted(false);
            conn.add(button);
        }
    }
}
