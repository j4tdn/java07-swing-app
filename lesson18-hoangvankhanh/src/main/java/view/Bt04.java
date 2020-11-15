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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import utils.CompUtils;
import common.Colour;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



/**
 *
 * @author ADMIN
 */
public class Bt04 extends JFrame{
    private final Random rd = new Random();
    private  Thread thread;
    private final Container conn = getContentPane();
    private JLabel lbText;
    private JButton btStop;
    
    
    
    public Bt04(){
        
        //ui
        initComponent();
        //event
        initEvent();
    }
    private void initComponent(){
        setResizable(false);
        
        setTitle("Java07 - Random BackGround");
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(440,400);
        // get screen size with height 
       // Dimension screensize =Toolkit.getDefaultToolkit().getScreenSize();
       // int x=screensize.width/2-frame.getWidth()/2;
       // int y=screensize.height/2-frame.getHeight()/2;
       // frame.setLocation(x, y);
        setLocationRelativeTo(null);
        Image img=new ImageIcon(getClass().getResource("/images/48px_like.png")).getImage();
        setIconImage(img);
        
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        Font font = new Font("Tahoma",Font.BOLD, 18);
        lbText = new JLabel();
        lbText.setText("Random : Green" );
        lbText.setFont(font);
        lbText.setBounds(120, 50, CompUtils.getPreWidth(lbText)+30, CompUtils.getPreHeight(lbText));
        
        conn.add(lbText);
        
        
        btStop = new JButton();
        btStop.setText("Stop");
        btStop.setFocusable(false);
        btStop.setCursor(new Cursor(Cursor.HAND_CURSOR) {
        });
        btStop.setBounds(145, 150, CompUtils.getPreWidth(btStop)+30, CompUtils.getPreHeight(btStop));
        
        conn.add(btStop);
        
        
        randomBackground();
     
        
    }
    private void randomBackground(){
        //create thread run parallel
         thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {  
                    System.out.println("Thread Running :)");
                Colour[] colors = Colour.values();
                Colour colour = colors[rd.nextInt(colors.length)];
                lbText.setText("Random :" + colour.name());
                conn.setBackground(colour.getColour());
                    sleep(1);
                    
                }
                
                
        }
        } );
        thread.start();
        
      
       
        
        
    }
    private void sleep(long second){
        try {
            Thread.sleep(second *1000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
    private void initEvent(){
        btStop.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                thread.interrupt();
                sleep(3);
                System.exit(0);
            }
            
        });
        
    }
    public static void main(String[] args) {
       Bt04 that = new Bt04();
       that.setVisible(true);
    }
         
}