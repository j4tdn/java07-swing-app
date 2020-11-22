/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;


/**
 *
 * @author ADMIN
 */
public class Ex03Grid extends JFrame{
        private final GridLayout gridLayout = new GridLayout(5, 5);
        private final Container conn = getContentPane();
        private Font font = new Font("Tahoma", Font.BOLD, 18);
        private Font fontB = new Font("Tahoma", Font.BOLD, 20);
        private JButton button;
        
        
        
        
        
    
    
    public Ex03Grid(){
        
        //ui
        initComponent();
        //event
        initEvent();
    }
    private void initComponent(){
        
        setTitle("Java07 - Grid Layout");
       
        setSize(1080,700);
     
        setLocationRelativeTo(null);
        Image img=new ImageIcon(getClass().getResource("/images/love.png")).getImage();
        setIconImage(img);
        
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        conn.setLayout(gridLayout);
        addRoom(26);
        
        
        
     
        
    }
    
    private void addRoom(int room){
        for(int i =1;i<=room;i++){
             button = new JButton();
            button.setText("Room"+(100+i));
            button.setFont(font);
            button.setFocusable(false);
            conn.add(button);
            
        }
        
    }
    private void initEvent(){
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setFont(fontB);
                button.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setFont(font);
                button.setForeground(Color.black);
            }
            
            
        });
        
    }
    
   
        
    
    public static void main(String[] args) {
       Ex03Grid that = new Ex03Grid();
       that.setVisible(true);
    }
         
}