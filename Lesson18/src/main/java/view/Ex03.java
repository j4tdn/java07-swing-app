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
 * @author ADMIN
 */
public class Ex03 extends JFrame{

    Container ContentPane = getContentPane();
    
    
    
    
    public Ex03(){
       
        initComponent();
        initEvent();
    }
    private void initComponent(){
        ContentPane.setBackground(Color.YELLOW);
        
        setTitle("Java07 - HELLO App");
        setSize(500,220);
        setLocationRelativeTo(null);
        Image img=new ImageIcon(getClass().getResource("/images/48px_like.png")).getImage();
        setIconImage(img);
        
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // jframe layout default : border layout
        //set layout
        setLayout(null);
        Font textFont = new Font("Tahoma", Font.BOLD, 16);
        JLabel lbText1 = new JLabel();
        
        lbText1.setText("----Wellcome to java07 class---");
        lbText1.setFont(textFont);
        lbText1.setBounds(50, 30,getPreWidth(lbText1),getPreHeight(lbText1));
        add(lbText1);
        
        
        JLabel lbText2 = new JLabel();
        lbText2.setText("----Ee are learning aaaaaa swing app---");
        lbText2.setFont(textFont);
        lbText2.setBounds(50, 70,getPreWidth(lbText2),getPreHeight(lbText2));
        add(lbText2);
     
        
    }
    private void initEvent(){
        
    }
    public static void main(String[] args) {
       Ex03 that = new Ex03();
       that.setVisible(true);
    }
         
}