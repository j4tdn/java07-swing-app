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
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.JSplitPane;

import static java.awt.BorderLayout.*;
import static javax.swing.JSplitPane.*;

/**
 *
 * @author ADMIN
 */
public class Ex02Border extends JFrame {

    private JPanel pnTop;
    private JPanel pnLeftTop;
    private JPanel pnLeftBottom;
    private JPanel pnCenter;
    private JSplitPane splitPanePnLeft;
    private JSplitPane splitPane;

    private final Container conn = getContentPane();
    private final BorderLayout borderLayout = new BorderLayout();

    public Ex02Border() {
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
        pnTop = new JPanel();
        pnTop.setPreferredSize(new Dimension(0, 100));
        pnTop.setBackground(Color.green);
        conn.add(pnTop, NORTH);

        pnLeftTop = new JPanel();
        pnLeftTop.setPreferredSize(new Dimension(140,300));
        pnLeftTop.setBackground(Color.black);
        
        pnLeftBottom = new JPanel();
        pnLeftBottom.setPreferredSize(new Dimension(140,0));
        pnLeftBottom.setBackground(Color.yellow);
        
        pnCenter = new JPanel();
        pnCenter.setBackground(Color.pink);
        
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

    }

    public static void main(String[] args) {
        Ex02Border that = new Ex02Border();
        that.setVisible(true);
    }
}
