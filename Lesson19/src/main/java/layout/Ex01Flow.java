/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;


import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;
import javax.swing.border.Border;



/**
 *
 * @author ADMIN
 */
public class Ex01Flow extends JFrame{
    
        private JPanel pnButton;
        private final Container conn = getContentPane();
        private Font font = new Font("Tahoma", Font.PLAIN, 18);
        private final FlowLayout flayout = new FlowLayout();
        private JRadioButton rdLtoR;
        private JRadioButton rdRtoL;
        private JButton btSubmit;
        private ButtonGroup orientationGroup = new ButtonGroup();
        
    
    
    public Ex01Flow(){
        
        //ui
        initComponent();
        //event
        initEvent();
    }
    private void initComponent(){
        
        setTitle("Java07 - HELLO App");
       
        setSize(800,300);
     
        setLocationRelativeTo(null);
        Image img=new ImageIcon(getClass().getResource("/images/love.png")).getImage();
        setIconImage(img);
        
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        conn.setLayout(flayout);
        addButton(5);
        addForm();
     
        
    }
    private void addButton(int nofButton){
        flayout.setHgap(15);
        flayout.setVgap(10);
        pnButton = new JPanel();
        pnButton.setLayout(flayout);
        Border insideBorder = BorderFactory.createEtchedBorder(Color.red,Color.GREEN);
        Border outsideBorder = BorderFactory.createEmptyBorder(30,0,0,0);
        
        
        Border border = BorderFactory.createCompoundBorder(outsideBorder,insideBorder);
        
        
        
        
        pnButton.setBorder(border);
        for(int i=1;i<=nofButton;i++){
            JButton button = new JButton();
            button.setFont(font);
            button.setFocusable(false);
           
            button.setText(i == 4 ?"LongNameButton " + i : "Button " + i);
            pnButton.add(button);
        }
        conn.add(pnButton);
        
    }
    private void addForm(){
        
        rdLtoR = new JRadioButton();
        rdLtoR.setText("Left To Right");
        rdLtoR.setFocusable(false);
        rdLtoR.setFont(font);
        conn.add(rdLtoR);
        orientationGroup.add(rdLtoR);
        
        rdRtoL = new JRadioButton();
        rdRtoL.setText("Right To Left");
        rdRtoL.setFocusable(false);
        rdRtoL.setFont(font);
        conn.add(rdRtoL);
        orientationGroup.add(rdRtoL);
        
       
        
        
        btSubmit = new JButton();
        btSubmit.setText("Submit");
        btSubmit.setFocusable(false);
        btSubmit.setFont(font);
        conn.add(btSubmit);
        
        
    }
    private void initEvent(){
        
    }
    public static void main(String[] args) {
       Ex01Flow that = new Ex01Flow();
       that.setVisible(true);
    }
         
}