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
import view.sub.PanelEmployee;
import view.sub.PanelHomePage;

/**
 *
 * @author ADMIN
 */
public class Ex05CardRemoveall extends JFrame {

    private JSplitPane splitpane;
    private JSplitPane splPanePnLeft;
    private JPanel pnTop;
    private JPanel pnleftTop;
    private JPanel pnleftBottom;
    private JPanel pnRight;
    private JPanel pnCenter;

    private Border defaultBorder;
    private BorderLayout boderlayoutpnCenter = new BorderLayout();
    private final Border hightlightBorder = BorderFactory.createCompoundBorder();
    private JButton previousClickedButton;
    private final Container conn = getContentPane();
    private Font font = new Font("Tahoma", Font.PLAIN, 18);
    private final BorderLayout borderLayout = new BorderLayout();
    private final GridLayout gridLayout = new GridLayout(4, 0);
    
    private final EnumMap<cardType, JPanel> cardMap;

    public Ex05CardRemoveall() {
        cardMap = new EnumMap<>(cardType.class);
        cardMap.put(cardType.Employee, new PanelEmployee());
        cardMap.put(cardType.HomePage, new PanelHomePage());
        //ui
        initComponent();
        //event
        initEvent();
    }

    private void initComponent() {

        setTitle("Java07 - Border Layout");

        setSize(1080, 700);

        setLocationRelativeTo(null);
        //Image img = new ImageIcon(getClass().getResource("/images/love.png")).getImage();
        //setIconImage(img);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        conn.setLayout(borderLayout);

        addPanels();

    }

    private void addPanels() {
        pnTop = new JPanel();
        pnTop.setPreferredSize(new Dimension(0, 100));
        pnTop.setBackground(Color.GREEN);
        conn.add(pnTop, NORTH);

        pnleftTop = new JPanel();
        pnleftTop.setPreferredSize(new Dimension(140, 300));
        pnleftTop.setBackground(Color.red);
        pnleftTop.setLayout(gridLayout);

        cardType[] cards = cardType.values();
          JButton btHomePage = new JButton();
            previousClickedButton = btHomePage;
            JButton button = new JButton();
            button.setText(cards[0].name());
            button.setFont(font);
            button.setFocusable(false);
            //defaultBorder =bthomepage.getBorder;
            pnleftTop.add(button);

        pnleftBottom = new JPanel();
        pnleftBottom.setPreferredSize(new Dimension(140, 0));
        pnleftBottom.setBackground(Color.yellow);

        splPanePnLeft = new JSplitPane();
        splPanePnLeft.setOneTouchExpandable(true);
        splPanePnLeft.setOrientation(VERTICAL_SPLIT);
        splPanePnLeft.add(pnleftTop, TOP);
        splPanePnLeft.add(pnleftBottom, BOTTOM);

        //conn.add(splPanePnLeft, WEST);
        pnCenter = new JPanel();
        pnCenter.setBackground(Color.pink);
        pnCenter.setLayout(borderLayout);
        
        pnCenter.add(new PanelHomePage(),BorderLayout.CENTER);
        pnCenter.add(new PanelEmployee(), "Employee");

        splitpane = new JSplitPane();
        splitpane.setOneTouchExpandable(true);
        splitpane.setOrientation(HORIZONTAL_SPLIT);
        splitpane.add(splPanePnLeft, LEFT);
        splitpane.add(pnCenter, RIGHT);

        conn.add(splitpane, CENTER);

    }

    private void initEvent() {
        pnleftTopevent();
    }
    
    private void pnleftTopevent() {
        Component[] components = pnleftTop.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                       
                        pnCenter.removeAll();
                        //JPanel pannel = cardType.get(cardType.from(button.));
                        pnCenter.setLayout(boderlayoutpnCenter);
                        String btText = button.getText();
                        //show corect panner
                        
                        pnCenter.add(cardMap.get(button.getText()));
                        pnCenter.repaint();
                        pnCenter.revalidate();
                        //unhightlight previous button
                        
                        //hight current button
                  
                        
                    }

                });
            }
        }

    }

    public static void main(String[] args) {
        Ex05CardRemoveall that = new Ex05CardRemoveall();
        that.setVisible(true);
    }

}
