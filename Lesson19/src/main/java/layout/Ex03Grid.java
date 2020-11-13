/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;


/**
 *
 * @author USER
 */
public class Ex03Grid extends JFrame {
    
    private final GridLayout gridLayout = new GridLayout(5, 0);
    
    private final Font font = new Font("Tahoma", Font.PLAIN, 20);
    
    private final Container conn = getContentPane();
    
    public Ex03Grid() {
        initComponents();
        initEvents();
    }
    
    private void initComponents() {
        setTitle("JAVA07 - GridLayout");
        
        setSize(1080, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        Image image = new ImageIcon(getClass().getResource("/images/48px_like.png")).getImage();
        setIconImage(image);
        
        conn.setLayout(gridLayout);
        
        addRooms(12);
    }
    
    private void addRooms(int rooms) {
        for (int i = 1; i <= rooms; i++) {
            JButton button = new JButton();
            button.setText("Room " + (100 + i));
            button.setFont(font);
            button.setFocusPainted(false);
            conn.add(button);
        }
    }
    
    private void initEvents() {
        
    }
    
    public static void main(String[] args) {
        Ex03Grid that = new Ex03Grid();
        that.setVisible(true);
    }
}
