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
 * @author OS
 */
public class Ex02Border extends JFrame{
    private JPanel pnTop;
    private JPanel pnLeftTop;
    private JPanel pnLeftBottom;
    private JPanel pnCenter;
    private JSplitPane splitPaneLeft;
    private JSplitPane splitPaneCenter;
    private final Container conn = this.getContentPane();
    private final BorderLayout borderLayout = new BorderLayout();

    public Ex02Border() {
        //UI
        initComponents();
        //Events
        initEvents();
    }
    
    private void initComponents() {
        setTitle("JAVA07 - HELLO APP");
        setSize(1080, 700);
        setLocationRelativeTo(null);
        Image image = new ImageIcon(getClass().getResource("/images/48px_like.png")).getImage();
        setIconImage(image);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        conn.setLayout(borderLayout);
        addPanels();
    }
    
    private void initEvents() {
        
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
        
        splitPaneLeft = new JSplitPane();
        splitPaneLeft.setOneTouchExpandable(true);
        splitPaneLeft.setOrientation(VERTICAL_SPLIT);
        splitPaneLeft.add(pnLeftTop, TOP);
        splitPaneLeft.add(pnLeftBottom, BOTTOM);
        
        pnCenter = new JPanel();
        pnCenter.setBackground(Color.PINK);
        
        splitPaneCenter = new JSplitPane();
        splitPaneCenter.setOneTouchExpandable(true);
        splitPaneCenter.setOrientation(HORIZONTAL_SPLIT);
        splitPaneCenter.add(splitPaneLeft, LEFT);
        splitPaneCenter.add(pnCenter, RIGHT);
        conn.add(splitPaneCenter, CENTER);
    }
    
    public static void main(String[] args) {
        Ex02Border app = new Ex02Border();
        app.setVisible(true);
    }
}
