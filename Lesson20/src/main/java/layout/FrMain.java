/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;


import common.cardType;
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
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import static javax.swing.JSplitPane.*;
import javax.swing.border.Border;
import view.sub.*;



/**
 *
 * @author ADMIN
 */
public class FrMain extends JFrame{
        private JSplitPane splitpane;
        private JSplitPane splPanePnLeft;
        
        private JPanel pnTop ;
        private JPanel pnleftTop;
        private JPanel pnleftBottom;
        private JPanel pnRight;
        private JPanel pnCenter;
        
        
        private JButton previousClickedButton;
        private Border defaultBorder;
        private final Border highlightBorder = BorderFactory.createLineBorder(Color.red,3);
        
        private final Container conn = getContentPane();
        private Font font = new Font("Tahoma", Font.PLAIN, 18);
        private final BorderLayout borderLayout = new BorderLayout();
        private final BorderLayout borderLayoutpnCenter = new BorderLayout();
        private final GridLayout gridLayout = new GridLayout(4, 0);
        
        
        private final EnumMap<cardType,JPanel> cardMap;
        
        
        
        
        
        
    
    
    public FrMain(){
        cardMap = new EnumMap<>(cardType.class);
        cardMap.put(cardType.Employee, new pnEmployee());
        cardMap.put(cardType.HomePage, new pnHomePage());
        cardMap.put(cardType.Student, new Stundent2());
        
        
        //ui
        initComponent();
        //event
        initEvent();
    }
    private void initComponent(){
        
        setTitle("Da Univercity");
       
        setSize(1280,800);
     
        setLocationRelativeTo(null);
        Image img=new ImageIcon(getClass().getResource("/images/student.png")).getImage();
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
        pnleftTop.setLayout(gridLayout);
        
        
        cardType[] cards = cardType.values();
        JButton btHomepage = new JButton();
            btHomepage.setText(cards[0].name());
            
            btHomepage.setFont(font);
            btHomepage.setFocusable(false);
            defaultBorder=btHomepage.getBorder();
            btHomepage.setBorder(highlightBorder);
            pnleftTop.add(btHomepage);
            
            
            previousClickedButton = btHomepage;
        for(int i=1;i<cards.length;i++ ){
            JButton button = new JButton();
            button.setText(cards[i].name());
            
            button.setFont(font);
            button.setFocusable(false);
            pnleftTop.add(button);
            
            
            
        }
        
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
        pnCenter.setLayout(borderLayoutpnCenter);
        
        
        
        pnCenter.add(new pnHomePage(),BorderLayout.CENTER);
        
        
        
        
        splitpane = new JSplitPane();
        splitpane.setOneTouchExpandable(true);
        splitpane.setOrientation(HORIZONTAL_SPLIT);
        splitpane.add(splPanePnLeft,LEFT);
        splitpane.add(pnCenter,RIGHT);
        
        conn.add(splitpane,CENTER);
        
        
    }
        
    private void initEvent(){
        pnleftTopEvent();
        
    }
    
    private void pnleftTopEvent(){
        Component[] components = pnleftTop.getComponents();
        for(Component component : components){
            if(component instanceof JButton){
                JButton button =(JButton)component;
                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        //show corrent card panel
                        pnCenter.removeAll();
                        System.out.println(button.getText());
                        JPanel panel = cardMap.get(cardType.from(button.getText()));
                        pnCenter.add(panel);
                        pnCenter.repaint();
                        pnCenter.revalidate();
                          //highlight corrent button
                        button.setBorder(highlightBorder);
                        //unhighlight previous button
                        previousClickedButton.setBorder(defaultBorder);
                        previousClickedButton = button;
                        
                    }
                    
                 
                    
                  
                 
                 
                    
                    
                });
            }
        }
    }
    
   
        
    
    public static void main(String[] args) {
       FrMain that = new FrMain();
       that.setVisible(true);
    }
         
}