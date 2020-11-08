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
 * @author khanh
 */

public class Ex03 extends JFrame{
    
    Container contentpane = getContentPane();

    public Ex03() {
        
        initComponents();
        
        initEvent();
        
    }
    
    private void initComponents(){
        setSize(440, 220);
        setLayout(null);
        setTitle("Java07-HELLO APP");
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.blue);
        Font font = new Font("Tahoma",Font.BOLD,16);
        
        Image image = new ImageIcon(getClass().getResource("/images/64px_flower.png")).getImage();
        setIconImage(image);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       
        JLabel lbFirst = new JLabel();
        lbFirst.setFont(font);
        lbFirst.setText("-----Welcome to-----");
        lbFirst.setBounds(120, 30,getPreWidth(lbFirst),getPreHeight(lbFirst));
        add(lbFirst);
        
        JLabel lbSecond = new JLabel();
        lbSecond.setFont(font);
        lbSecond.setText("-----Welcome to java07 clas-----");
        lbSecond.setBounds(120, 30+getPreHeight(lbFirst), getPreWidth(lbSecond), getPreHeight(lbSecond));
        add(lbSecond);
        

    }
    
        private void initEvent() {
    }
        
    public static void main(String[] args) {
        Ex03 that = new Ex03();
        that.setVisible(true);
        
    }


}
