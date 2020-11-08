/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;



/**
 *
 * @author ADMIN
 */
public class Ex02 extends JFrame{
    
    
    public Ex02(){
        
        //ui
        initComponent();
        //event
        initEvent();
    }
    private void initComponent(){
        
        setTitle("Java07 - HELLO App");
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(440,220);
        // get screen size with height 
       // Dimension screensize =Toolkit.getDefaultToolkit().getScreenSize();
       // int x=screensize.width/2-frame.getWidth()/2;
       // int y=screensize.height/2-frame.getHeight()/2;
       // frame.setLocation(x, y);
        setLocationRelativeTo(null);
        Image img=new ImageIcon(getClass().getResource("/images/48px_like.png")).getImage();
        setIconImage(img);
        
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     
        
    }
    private void initEvent(){
        
    }
    public static void main(String[] args) {
       Ex02 that = new Ex02();
       that.setVisible(true);
    }
         
}