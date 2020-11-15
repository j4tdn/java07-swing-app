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
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import static javax.swing.JSplitPane.*;
import view.sub.PanelEmployee;
import view.sub.PanelHomePage;

/**
 *
 * @author OS
 */
public class Ex03Card extends JFrame{
    private JPanel pnTop;
    private JPanel pnLeftTop;
    private JPanel pnLeftBottom;
    private JPanel pnCenter;
    private JSplitPane splitPaneLeft;
    private JSplitPane splitPaneCenter;
    private final Container conn = this.getContentPane();
    private final BorderLayout borderLayout = new BorderLayout();
    private final GridLayout gridLayout = new GridLayout(4, 0);
    private final CardLayout cardLayout = new CardLayout();

    public Ex03Card() {
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
        pnLeftTop.setPreferredSize(new Dimension(180, 300));
        pnLeftTop.setBackground(Color.BLACK);
        pnLeftTop.setLayout(gridLayout);
        gridLayout.setVgap(3);
        
        List<String> buttons = Arrays.asList("HomePage", "Employee");
        for (String btText: buttons) {
            JButton button = new JButton();
            button.setFocusPainted(false);
            button.setText(btText);
            pnLeftTop.add(button);
        }
        
        pnLeftBottom = new JPanel();
        pnLeftBottom.setPreferredSize(new Dimension(180, 0));
        pnLeftBottom.setBackground(Color.YELLOW);
        
        splitPaneLeft = new JSplitPane();
        splitPaneLeft.setOneTouchExpandable(true);
        splitPaneLeft.setOrientation(VERTICAL_SPLIT);
        splitPaneLeft.add(pnLeftTop, TOP);
        splitPaneLeft.add(pnLeftBottom, BOTTOM);
        
        pnCenter = new JPanel();
        pnCenter.setBackground(Color.PINK);
        pnCenter.setLayout(cardLayout);
        
        pnCenter.add(new PanelHomePage(), "HomePage");
        pnCenter.add(new PanelEmployee(), "Employee");
        
        cardLayout.show(pnCenter, "Employee");
        
        splitPaneCenter = new JSplitPane();
        splitPaneCenter.setOneTouchExpandable(true);
        splitPaneCenter.setOrientation(HORIZONTAL_SPLIT);
        splitPaneCenter.add(splitPaneLeft, LEFT);
        splitPaneCenter.add(pnCenter, RIGHT);
        conn.add(splitPaneCenter, CENTER);
    }
    
    public static void main(String[] args) {
        Ex03Card app = new Ex03Card();
        app.setVisible(true);
    }
}
