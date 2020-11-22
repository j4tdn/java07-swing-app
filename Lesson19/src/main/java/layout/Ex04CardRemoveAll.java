/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import common.CardType;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.JSplitPane;

import static java.awt.BorderLayout.*;
import java.awt.Button;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import static javax.swing.JSplitPane.*;
import javax.swing.border.Border;
import view.sub.PanelEmployee;
import view.sub.PanelHomePage;

/**
 *
 * @author ADMIN
 */
public class Ex04CardRemoveAll extends JFrame {

    private JPanel pnTop;
    private JPanel pnLeftTop;
    private JPanel pnLeftBottom;
    private JPanel pnCenter;
    private JSplitPane splitPanePnLeft;
    private JSplitPane splitPane;
    private JButton previousClickedButton;
    private Border defaultBorder;
    
    private final Border highlightBorder =BorderFactory.createLineBorder(Color.red,3);
    private final Font font = new Font("Tahoma", Font.PLAIN, 20);
    private final Container conn = getContentPane();
    private final BorderLayout borderLayout = new BorderLayout();
    private final BorderLayout borderLayoutPnCenter = new BorderLayout();
    private final GridLayout gridLayout=new GridLayout(4, 0);
    private final EnumMap<CardType,JPanel> cardMap;
            
    public Ex04CardRemoveAll() {
        cardMap=new EnumMap<>(CardType.class);
        cardMap.put(CardType.HomePage,new PanelHomePage());
        cardMap.put(CardType.Employee,new PanelEmployee());
        //UI
        initComponents();
        //events
        initEvents();
    }

    private void initComponents() {
        setTitle("JAVA07 - BorderLayout");
        setResizable(false);
        setSize(1080, 700);

        setLocationRelativeTo(null);

        Image image = new ImageIcon(getClass().getResource("/images/48px_like.png")).getImage();
        setIconImage(image);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(borderLayout);

        addPanel();
    }

    private void addPanel() {
        gridLayout.setVgap(3);
        
        pnTop = new JPanel();
        pnTop.setPreferredSize(new Dimension(0, 100));
        pnTop.setBackground(Color.green);
        conn.add(pnTop, NORTH);

        pnLeftTop = new JPanel();
        pnLeftTop.setPreferredSize(new Dimension(140,300));
        pnLeftTop.setBackground(Color.black);
        pnLeftTop.setLayout(gridLayout);
        
        
        CardType[] cards=CardType.values();
        JButton btHomePage=new JButton();
            btHomePage.setFocusPainted(false);
            btHomePage.setFont(font);
            btHomePage.setText(cards[0].name());
            defaultBorder=btHomePage.getBorder();
            btHomePage.setBorder(highlightBorder);
            previousClickedButton=btHomePage;
            pnLeftTop.add(btHomePage);
            
        for(int i=1;i<cards.length;i++){
            JButton button=new JButton();
            button.setFocusPainted(false);
            button.setFont(font);
            button.setText(cards[i].name());
            pnLeftTop.add(button);
        }
        
        pnLeftBottom = new JPanel();
        pnLeftBottom.setPreferredSize(new Dimension(180,0));
        pnLeftBottom.setBackground(Color.yellow);
        
        pnCenter = new JPanel();
        pnCenter.setBackground(Color.pink);
        pnCenter.setLayout(borderLayoutPnCenter);
        
        pnCenter.add(new PanelHomePage(),BorderLayout.CENTER);
        
        splitPanePnLeft=new JSplitPane();
        splitPanePnLeft.setOneTouchExpandable(true);
        splitPanePnLeft.setOrientation(VERTICAL_SPLIT);
        
        splitPanePnLeft.add(pnLeftTop,TOP);
        splitPanePnLeft.add(pnLeftBottom,BOTTOM);
        
        splitPane=new JSplitPane();
        splitPane.setOneTouchExpandable(true);
        splitPane.setOrientation(HORIZONTAL_SPLIT);
        splitPane.add(splitPanePnLeft,LEFT);
        splitPane.add(pnCenter,RIGHT);
        conn.add(splitPane,CENTER);
    }

    private void initEvents() {
        pnLeftTopEvents();
    }
    
    private void pnLeftTopEvents(){
        Component[] components=pnLeftTop.getComponents();
        for (Component component:components){
            if (component instanceof JButton){
                JButton button=(JButton) component;
                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                    // remove pnCenter's component
                    pnCenter.removeAll();
                    // show correct card panel
                    JPanel panel=cardMap.get(CardType.from(button.getText()));
                    pnCenter.add(panel);
                    
                    //validate
                    pnCenter.repaint();
                    pnCenter.revalidate();
                        // unhighlight previous button
                    previousClickedButton.setBorder(defaultBorder);
                        // highlight current button
                    button.setBorder(highlightBorder);
                    previousClickedButton=button;
                    }
                });
            }
        }
    } 
    
    public static void main(String[] args) {
        Ex04CardRemoveAll that = new Ex04CardRemoveAll();
        that.setVisible(true);
    }
}