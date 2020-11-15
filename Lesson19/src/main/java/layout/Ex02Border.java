/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import static java.awt.BorderLayout.*;
import javax.swing.JSplitPane;
import static javax.swing.JSplitPane.*;


/**
 *
 * @author ADMIN
 */
public class Ex02Border extends JFrame{
        private JSplitPane splitpane;
        private JSplitPane splPanePnLeft;
        private JPanel pnTop ;
        private JPanel pnleftTop;
        private JPanel pnleftBottom;
        private JPanel pnRight;
        private JPanel pnCenter;
        
        private final Container conn = getContentPane();
        private Font font = new Font("Tahoma", Font.PLAIN, 18);
        private final BorderLayout borderLayout = new BorderLayout();
        
        
        
        
    
    
    public Ex02Border(){
        
        //ui
        initComponent();
        //event
        initEvent();
    }
    private void initComponent(){
        
        setTitle("Java07 - Border Layout");
       
        setSize(1080,700);
     
        setLocationRelativeTo(null);
        Image img=new ImageIcon(getClass().getResource("/images/love.png")).getImage();
        setIconImage(img);
        
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        conn.setLayout(borderLayout);
        
        
        addPanels();
     
        
    }
    private void addPanels(){
        pnTop = new JPanel();
        pnTop.setPreferredSize(new Dimension(0, 100));
        pnTop.setBackground(Color.GREEN);
        conn.add(pnTop,NORTH);
        
        pnleftTop = new JPanel();
        pnleftTop.setPreferredSize(new Dimension(140, 300));
        pnleftTop.setBackground(Color.red);
        
        pnleftBottom = new JPanel();
        pnleftBottom.setPreferredSize(new Dimension(140, 0));
        pnleftBottom.setBackground(Color.yellow);
        
        
        splPanePnLeft = new JSplitPane();
        splPanePnLeft.setOneTouchExpandable(true);
        splPanePnLeft.setOrientation(VERTICAL_SPLIT);
        splPanePnLeft.add(pnleftTop,TOP);
        splPanePnLeft.add(pnleftBottom,BOTTOM);
        
        //conn.add(splPanePnLeft, WEST);
        
        
        pnCenter = new JPanel();
        pnCenter.setBackground(Color.pink);
        
        
        splitpane = new JSplitPane();
        splitpane.setOneTouchExpandable(true);
        splitpane.setOrientation(HORIZONTAL_SPLIT);
        splitpane.add(splPanePnLeft,LEFT);
        splitpane.add(pnCenter,RIGHT);
        
        conn.add(splitpane,CENTER);
        
        
    }
        
    private void initEvent(){
        
    }
    
   
        
    
    public static void main(String[] args) {
       Ex02Border that = new Ex02Border();
       that.setVisible(true);
    }
         
}