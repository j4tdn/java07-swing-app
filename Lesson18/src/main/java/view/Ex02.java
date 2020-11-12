/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Common.Colour;
import java.awt.Button;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import utils.CompUtils;

/**
 *
 * @author ADMIN
 */
public class Ex02 extends JFrame{
    
    private JLabel lbText;
    private JButton btStop;
    private final Random rd = new Random();
    private Container conn = getContentPane();
    
    public Ex02() {
        //UI
        initComponents();
        //events
        initEvents();
    }
    private void initComponents(){
        setTitle("Random Background");
                
        setSize(440, 400);
        
        setLocationRelativeTo(null);
        
        Image image = new ImageIcon(getClass().getResource("/images/48px_like.png")).getImage();
        setIconImage(image);
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        lbText = new JLabel();
        lbText.setText("Random: Green");
        lbText.setBounds(20, 20, 120, 120);
        conn.add(lbText);
        
//        btStop = new JButton();
//        btStop.setText("Stop");
//        btStop.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        btStop.setBounds(160, 150, 120, 10);
//        conn.add(btStop);
        
        randomBackground();
        
    }
    
    private void randomBackground(){
        Thread thread = new Thread(()->{
            while(true){
                Colour[] colours = Colour.values();
                Colour colour = colours[rd.nextInt(colours.length)];
                lbText.setText("Random : " + colour.name().toUpperCase());
                conn.setBackground(colour.getColor());
            }
        });
        thread.start();
    }
    
    private void initEvents(){
        
    }
    public static void main(String[] args) {
        Ex02 that =  new Ex02();
        that.setVisible(true);
    }
}
