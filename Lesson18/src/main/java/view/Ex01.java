/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;



/**
 *
 * @author ADMIN
 */
public class Ex01 {
    //private static final String PROJECT_PATH=new File("").getAbsolutePath();
    //private static final String IMAGES_PATH=PROJECT_PATH+"\\src\\main\\java\\images";
    public Ex01(){
        
        //ui
        initComponent();
        //event
        initEvent();
    }
    private void initComponent(){
        JFrame frame=new JFrame();
        frame.setTitle("JAVA07-HELLO APP");
        frame.setSize(440,220);
        
//        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
//        int x=screenSize.width/2-frame.getWidth()/2;
//        int y=screenSize.height/2-frame.getHeight()/2;
//        frame.setLocation(x,y);
        
        //full screen
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        //ss url uri
        Image image=new ImageIcon(getClass().getResource("/images/64px_flower.png")).getImage();
        frame.setIconImage(image);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     
        //vi tri tuong doi
        frame.setLocationRelativeTo(null);
        
        frame.setVisible(true);
    }
    private void initEvent(){
        
    }
    public static void main(String[] args) {
        new Ex01();
    }
         
}
