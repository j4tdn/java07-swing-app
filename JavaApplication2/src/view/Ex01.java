/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author khanh
 */

public class Ex01  {
    private static final String PROJECT_PATH= new File("").getAbsolutePath();
    private static final  String path = PROJECT_PATH+"\\src\\images";

    public Ex01() {
        
        initComponents();
        
        initEvent();
        
    }
    
    private void initComponents(){
        JFrame frame = new JFrame();
        frame.setSize(440, 220);
        frame.setTitle("Java07-HELLO APP");
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //get screen size;
        //Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
        //int x=screenSize.width/2-frame.getWidth()/2;
        //int y=screenSize.height/2-frame.getHeight()/2;
        frame.setLocationRelativeTo(null);
        
        Image image = new ImageIcon(getClass().getResource("/images/64px_flower.png")).getImage();
        frame.setIconImage(image);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
        private void initEvent() {
    }
        
    public static void main(String[] args) {
        new Ex01();
    }
}
