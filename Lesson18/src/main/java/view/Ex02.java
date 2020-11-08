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
 * @author ADMIN
 */
public class Ex02 extends JFrame{
    public Ex02() {
        //UI
        initComponents();
        //events
        initEvents();
    }
    private void initComponents(){
        setTitle("JAVA07 - HELLO APP");
                
        setSize(440, 220);
        
        setLocationRelativeTo(null);
        
        Image image = new ImageIcon(getClass().getResource("/images/48px_like.png")).getImage();
        setIconImage(image);
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
    }
    private void initEvents(){
        
    }
    public static void main(String[] args) {
        Ex02 that =  new Ex02();
        that.setVisible(true);
    }
}
