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
import static javax.swing.JSplitPane.LEFT;
import static javax.swing.JSplitPane.RIGHT;

/**
 *
 * @author USER
 */
public class Ex02Border extends JFrame {
    
    private JPanel pnTop;
    private JPanel pnLeftTop;
    private JPanel pnLeftBottom;
    private JPanel pnCenter;
    
    private JSplitPane splitPanelLeft;
    private JSplitPane splitPanel;
    
    private final Font font = new Font("Tahoma", Font.PLAIN, 20);
    
    private final Container conn = getContentPane();
    
    private final BorderLayout borderLayout = new BorderLayout();
    
    public Ex02Border() {
        initComponents();
        initEvents();
    }
    
    private void initComponents() {
        setTitle("JAVA07 - BorderLayout");
        
        setSize(1080, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        Image image = new ImageIcon(getClass().getResource("/images/48px_like.png")).getImage();
        setIconImage(image);
        
        conn.setLayout(borderLayout);
        
        addPanels();
    }
    
    private void addPanels() {
        pnTop = new JPanel();
        pnTop.setPreferredSize(new Dimension(0, 100));
        pnTop.setBackground(Color.GREEN);
        conn.add(pnTop, NORTH);
        
        pnLeftTop = new JPanel();
        pnLeftTop.setPreferredSize(new Dimension(140, 300));
        pnLeftTop.setBackground(Color.BLACK);
        
        pnLeftBottom = new JPanel();
        pnLeftBottom.setPreferredSize(new Dimension(140, 0));
        pnLeftBottom.setBackground(Color.YELLOW);
        
        splitPanelLeft = new JSplitPane();
        splitPanelLeft.setOneTouchExpandable(true);
        splitPanelLeft.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPanelLeft.add(pnLeftTop, JSplitPane.TOP);
        splitPanelLeft.add(pnLeftBottom, JSplitPane.BOTTOM);
        
        pnCenter = new JPanel();
        pnCenter.setBackground(Color.PINK);
        
        splitPanel = new JSplitPane();
        splitPanel.setOneTouchExpandable(true);
        splitPanel.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPanel.add(splitPanelLeft, LEFT);
        splitPanel.add(pnCenter, RIGHT);
        
        conn.add(splitPanel, CENTER);
    }
    
    private void initEvents() {
        
    }
    
    public static void main(String[] args) {
        Ex02Border that = new Ex02Border();
        that.setVisible(true);
    }
}
