/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author khanh
 */

public class Ex02 extends JFrame{

    public Ex02() {
        
        initComponents();
        
        initEvent();
        
    }
    
    private void initComponents(){
        setSize(440, 220);
        setTitle("Java07-HELLO APP");
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //get screen size;
        //Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
        //int x=screenSize.width/2-frame.getWidth()/2;
        //int y=screenSize.height/2-frame.getHeight()/2;
        setLocationRelativeTo(null);
        
        Image image = new ImageIcon(getClass().getResource("/images/64px_flower.png")).getImage();
        setIconImage(image);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
        private void initEvent() {
    }
        
    public static void main(String[] args) {
        Ex02 that = new Ex02();
        that.setVisible(true);
        
    }


}
