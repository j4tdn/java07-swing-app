/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import common.CardType;
import java.awt.BorderLayout;
import static java.awt.BorderLayout.*;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;
import static javax.swing.JSplitPane.*;
import javax.swing.border.Border;
import view.sub.pnEmployee;
import view.sub.pnHomePage;
import view.sub.pnStudent;
import view.sub.pnStudentForm;

/**
 *
 * @author khanh
 */
public class FrMain extends JFrame {
    
    private JPanel pnTop;
    private JPanel pnLeftTop;
    private JPanel pnLeftBottom;
    private JSplitPane splitPanePnLeft;
    private JPanel pnCenter;
    private JSplitPane splitPane;
    private final Border highlightBorder = BorderFactory.createLineBorder(Color.red,2);
    private Border defaultBorder;
    private JButton previousClickedButton;
    
    private final Container conn = getContentPane();
    
    private final Font font = new Font("Tohama", Font.PLAIN, 20);
    private final BorderLayout borderLayout = new BorderLayout();
    private final BorderLayout borderLayoutPnCenter = new BorderLayout();
    private final GridLayout gridLayout = new GridLayout(4, 0);
    private final EnumMap<CardType,JPanel> cardMap;
    
    public FrMain() {
        cardMap = new EnumMap<>(CardType.class);
        cardMap.put(CardType.Employee, new pnEmployee());
        cardMap.put(CardType.HomePage, new pnHomePage());
        cardMap.put(CardType.Student, new pnStudent());
        
        
        initComponents();  
        initEvent();
        
    }
    
    private void initComponents() {
        setSize(1320, 800);
        setTitle("Da Nang University UI");
        
        setLocationRelativeTo(null);
        
        Image image = new ImageIcon(getClass().getResource("/images/student.png")).getImage();
        setIconImage(image);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        conn.setLayout(borderLayout);
        addPanels();
    }
    
    private void addPanels() {
        pnTop = new JPanel();
        pnTop.setPreferredSize(new Dimension(0, 100));
        pnTop.setBackground(Color.green);
        conn.add(pnTop, NORTH);
        
        pnLeftTop = new JPanel();
        pnLeftTop.setPreferredSize(new Dimension(140, 300));
        pnLeftTop.setBackground(Color.BLACK);
        pnLeftTop.setLayout(gridLayout);
        
        CardType[] cards = CardType.values();
        JButton btnHomePage = new JButton();
        btnHomePage.setText(cards[0].name());
        btnHomePage.setFont(font);
        btnHomePage.setFocusPainted(false);
        defaultBorder = btnHomePage.getBorder();
        btnHomePage.setBorder(highlightBorder);
        pnLeftTop.add(btnHomePage);
        
        previousClickedButton = btnHomePage;
        
        for (int i = 1; i < cards.length; i++) {
            JButton button = new JButton();
            button.setText(cards[i].name());
            button.setFont(font);
            button.setFocusPainted(false);
            pnLeftTop.add(button);
        }
        
        pnLeftBottom = new JPanel();
        pnLeftBottom.setPreferredSize(new Dimension(140, 0));
        pnLeftBottom.setBackground(Color.yellow);
        
        splitPanePnLeft = new JSplitPane();
        splitPanePnLeft.setOneTouchExpandable(true);
        splitPanePnLeft.setOrientation(VERTICAL_SPLIT);
        splitPanePnLeft.add(pnLeftTop, TOP);
        splitPanePnLeft.add(pnLeftBottom, BOTTOM);
        
        pnCenter = new JPanel();
        pnCenter.setBackground(Color.PINK);
        pnCenter.setLayout(borderLayoutPnCenter);
        pnCenter.add(new pnHomePage(),BorderLayout.CENTER);
        
        
        splitPane = new JSplitPane();
        splitPane.setOneTouchExpandable(true);
        splitPane.setOrientation(HORIZONTAL_SPLIT);
        splitPane.add(splitPanePnLeft, LEFT);
        splitPane.add(pnCenter, RIGHT);
        conn.add(splitPane, CENTER);
    }
    
    private void initEvent() {
        pnLeftTopEvents();
    }
    
    private void pnLeftTopEvents(){
       
        Component[] components= pnLeftTop.getComponents();
        for(Component component:components){
            if(component instanceof JButton){
                JButton button= (JButton) component;
                button.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mousePressed(MouseEvent e) {
                        pnCenter.removeAll();
                        JPanel panel= cardMap.get(CardType.from(button.getText()));
                        pnCenter.add(panel);
                        repaint();
                        revalidate();
                        previousClickedButton.setBorder(defaultBorder);
                        button.setBorder(highlightBorder);
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
