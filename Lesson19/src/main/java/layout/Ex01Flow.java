/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
    private final Font font = new Font("Tahoma", Font.PLAIN, 20);
    private final FlowLayout flowlayout = new FlowLayout();
    
    private JRadioButton rdLtoR;
    private JRadioButton rdRtoL;
    private JButton btSubmit;
    private ButtonGroup orientationGroup = new ButtonGroup();
    
    public Ex01Flow() {
        //UI
        initComponents();
        //events
        initEvents();
    }
    
    private void initComponents(){
        setTitle("JAVA07 - FlowLayout");
                
        setSize(870, 300);
        
        setLocationRelativeTo(null);
        
        Image image = new ImageIcon(getClass().getResource("/images/48px_like.png")).getImage();
        setIconImage(image);
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        conn.setLayout(flowlayout);
    
        addButton(5);
        
        addForm();
        
    }
    
    private void addForm(){
        rdRtoL = new JRadioButton();
        rdRtoL.setText("Right to left");
        conn.add(rdRtoL);
        
        rdLtoR = new JRadioButton();
        rdLtoR.setText("Left to right");

        conn.add(rdRtoL);
        
        btSubmit = new JButton();
        btSubmit.setText("Submit");
        
        conn.add(btSubmit);
    }
    
    private void addButton(int n){
        
        flowlayout.setHgap(15);
        flowlayout.setVgap(10);
        
        pnButton = new JPanel();
        pnButton.setLayout(flowlayout);
       
        Border insideBorder = BorderFactory.createEtchedBorder();
        Border outsideBorder = BorderFactory.createEmptyBorder(30, 0, 0, 0);
        Border border = BorderFactory.createCompoundBorder(outsideBorder, insideBorder);
        pnButton.setBorder(border);
        
        for (int i = 1; i <= n; i++) {
            JButton button = new JButton();
            button.setFont(font);
            button.setText(i == 4? "Long-name Button " + i : "Button " + i);
            button.setFocusPainted(false);
            pnButton.add(button);
        }
        conn.add(pnButton);
    }
    
    private void initEvents(){
        
    }
    public static void main(String[] args) {
        Ex01Flow that =  new Ex01Flow();
        that.setVisible(true);
    }
}
