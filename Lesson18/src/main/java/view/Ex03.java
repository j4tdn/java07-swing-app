/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import static utils.CompUtils.*;

/**
 *
 * @author OS
 */
public class Ex03 extends JFrame{

    Container contentPain = this.getContentPane();

    public Ex03() {
        //UI
        initComponents();
        //Events
        initEvents();
    }
    
    private void initComponents() {
        setTitle("JAVA07 - HELLO APP");
        setSize(500, 220);
        setLocationRelativeTo(null);
        contentPain.setBackground(Color.yellow);
        Image image = new ImageIcon(getClass().getResource("/images/48px_like.png")).getImage();
        setIconImage(image);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        //JFrame: layout default: border layout;
        //setLayout
        setLayout(null);
        Font textFont = new Font("Tahoma", Font.BOLD, 16);
        JLabel lbFirst = new JLabel();
        lbFirst.setText("--- Welcome to JAVA07 class ---");
        lbFirst.setFont(textFont);
        lbFirst.setBounds(120, 30, getPreWidth(lbFirst),getPreHeight(lbFirst));
        add(lbFirst);
        
        JLabel lbSecond = new JLabel();
        lbSecond.setText("--- We are learning SWING app---");
        lbSecond.setFont(textFont);
        lbSecond.setBounds(120,30 + getPreHeight(lbSecond) , getPreWidth(lbSecond),getPreHeight(lbSecond));
        add(lbSecond);
    }
    
    private void initEvents() {
        
    }
    
    public static void main(String[] args) {
        Ex03 app = new Ex03();
        app.setVisible(true);
    }
}
