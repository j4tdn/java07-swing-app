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
public class Ex02 extends JFrame{
    //private static final String PROJECT_PATH=new File("").getAbsolutePath();
    //private static final String IMAGES_PATH=PROJECT_PATH+"\\src\\main\\java\\images";
    public Ex02(){
        
        //ui
        initComponent();
        //event
        initEvent();
    }
    private void initComponent(){
        setTitle("JAVA07-HELLO APP");
        setSize(440,220);
        
//        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
//        int x=screenSize.width/2-frame.getWidth()/2;
//        int y=screenSize.height/2-frame.getHeight()/2;
//        frame.setLocation(x,y);
        
        //full screen
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        //ss url uri
        Image image=new ImageIcon(getClass().getResource("/images/48px_like.png")).getImage();
        setIconImage(image);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     
        //vi tri tuong doi
        setLocationRelativeTo(null);
                
        
    }
    private void initEvent(){
        
    }
    public static void main(String[] args) {
       Ex02 that= new Ex02();
       that.setVisible(true);
    }
         
}
