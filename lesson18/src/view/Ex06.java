/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import common.Colour;
import java.awt.Color;
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
 * @author Admin
 */
public class Ex06 extends JFrame{
    private final   Container conn = getContentPane();
    private JLabel lbText;
    private JButton btStop;
    private final Random  rd = new Random();
    private Thread thread;
    
    
    public Ex06() {
        //ui
        initComponents();
        //event
        initEvents();
    }
   
    
    
    
    
    
//    private static final String Project_Path = new File("").getAbsolutePath();
    private static final String Image_Path = "D:\\Java\\Workspace\\local_Git\\java07-repository-app\\image\\images";// set đường dẫn
    private void initComponents(){
         setTitle("Lê Nhật Phi");
         
        setSize(500, 320); ///set size
       setLocationRelativeTo(null);
       Image image = new ImageIcon(Image_Path + File.separator +"48px_like.png").getImage(); // set hình ảnh cho iconImage
       setIconImage(image);
       setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // bắt event khi tắt chương trình cho khỏi chạy ngầm
         Font font1 = new Font("Tahoma", Font.BOLD, 18);
       //setcolor
       
       //set layout
        setLayout(null);
        lbText = new JLabel();
       lbText.setText("Random:GREEN");
       lbText.setFont(font1);
       lbText.setBounds(145, 50, 200, CompUtils.getPreHeight(lbText));
       add(lbText);
       
       btStop = new JButton();
       btStop.setText("Stop");
       btStop.setFocusPainted(false);
       btStop.setBounds(160, 150, 120,CompUtils.getPreHeight(btStop));
       btStop.setCursor(new Cursor(Cursor.HAND_CURSOR));
       add(btStop);
       randomBackgroud();
    }
      private void randomBackgroud(){
          //create thred run pareller wwi main therd
           thread = new Thread(new Runnable() {
              @Override
              public void run() {
                System.out.println("THread Running:");
                Colour[] colours = Colour.values();
                Colour colour = colours[rd.nextInt(colours.length)];
                lbText.setText("Random:" + colour.name().toUpperCase());
                conn.setBackground(Color.RED);
                //conn.setBackground(colour.g);
                sleep(1);
              }
          });
          
          thread.start();
            
       
          
    }
      
    private void sleep(long second) {
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Ex06.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void initEvents(){
        btStop.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                thread.interrupt();
                sleep(1);
                System.exit(0);
            }
            
        });
    }
    
    public static void main(String[] args) {
        Ex06 that = new Ex06();
        that.setVisible(true);
    }
}
