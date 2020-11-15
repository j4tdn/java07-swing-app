/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import java.awt.BorderLayout;
import static java.awt.BorderLayout.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;
import static javax.swing.JSplitPane.*;

/**
 *
 * @author khanh
 */
public class Ex02Grid extends JFrame {

    private final GridLayout gridLayout = new GridLayout(5,5);
    
    private final Container conn = getContentPane();
    private final Font font = new Font("Tohama", Font.PLAIN, 20);


    public Ex02Grid() {

        initComponents();

        initEvent();

    }

    private void initComponents() {
        setSize(1080, 700);
        setTitle("Java07-FlowLayout");

        setLocationRelativeTo(null);

        Image image = new ImageIcon(getClass().getResource("/images/64px_flower.png")).getImage();
        setIconImage(image);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        conn.setLayout(gridLayout);
        addRooms(26);
        
    }

    private void addRooms(int rooms){
        for(int i =0;i<rooms;i++){
            JButton button = new JButton();
            button.setText("Room "+(100+i));
            button.setFont(font);
            button.setFocusPainted(false);
            conn.add(button);
        }
    }

    private void initEvent() {


    }

    public static void main(String[] args) {
        Ex02Grid that = new Ex02Grid();
        that.setVisible(true);

    }

}
