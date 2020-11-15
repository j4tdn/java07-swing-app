/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import common.Colour;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import utils.CompUtils;

/**
 *
 * @author khanh
 */

public class Ex04 extends JFrame{
    
    private JLabel lbText;
    private JButton btnStop;
    private  Thread thread;
    private final Random rd = new Random();
    
    private final Container conn = getContentPane();

    public Ex04() {
        
        initComponents();   
        initEvent();
        
    }
    
    private void initComponents(){
        setResizable(false);
        setSize(440, 400);
        setTitle("Random Background");

        setLocationRelativeTo(null);
        Font font = new Font("Tahoma",Font.BOLD,18);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        lbText = new JLabel();
        lbText.setIcon(new ImageIcon(getClass().getResource("/images/ghost/1.jpg")));
        lbText.setFont(font);
        lbText.setBounds(145, 50, 100, 100);
        conn.add(lbText);
        
        btnStop = new JButton();
        btnStop.setText("Stop");
        btnStop.setFocusPainted(false);
        btnStop.setFont(font);
        btnStop.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnStop.setBounds(160,150  ,120, CompUtils.getPreHeight(btnStop));
        conn.add(btnStop);
        
        
        
        randomBackground();
        randomImages();
    }
    
    private void randomImages(){
        
        thread = new Thread(()->{
            while(true){
                int imgNumbers = rd.nextInt(8)+1;
                lbText.setIcon(new ImageIcon(getClass().getResource("/images/ghost/"+imgNumbers+".jpg")));
                sleep(1);
            }
        });
        thread.start();
    }
    
    private void randomBackground(){
        //create thread run paralle
        
        thread = new Thread(()->{
            while(true){
                Colour[] colours = Colour.values();
                Colour colour = colours[rd.nextInt(colours.length)];
        
                conn.setBackground(colour.getColor());
                    sleep(3);
                }
        }

        );
        thread.start();
        
    }
    
        private void initEvent() {
            btnStop.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    thread.interrupt();
                    
                    sleep(3);
                    System.exit(0);
                }
                
            });
            
    }
        private void sleep(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        }
        
    public static void main(String[] args) {
        Ex04 that = new Ex04();
        that.setVisible(true);
        
    }


}
