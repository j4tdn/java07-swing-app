/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import java.awt.BorderLayout;
import static java.awt.BorderLayout.*;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;
import static javax.swing.JSplitPane.*;
import view.sub.pnEmployee;
import view.sub.pnHomePage;

/**
 *
 * @author khanh
 */
public class Ex04Card extends JFrame {

    private JPanel pnTop;
    private JPanel pnLeftTop;
    private JPanel pnLeftBottom;
    private JSplitPane splitPanePnLeft;
    private JPanel pnCenter;
    private JSplitPane splitPane;

    private final Container conn = getContentPane();

    private final Font font = new Font("Tohama", Font.PLAIN, 20);
    private final BorderLayout borderLayout = new BorderLayout();
    private final GridLayout gridLayout = new GridLayout(4,0);
    private final CardLayout cardLayout = new CardLayout();

    public Ex04Card() {

        initComponents();

        initEvent();

    }

    private void initComponents() {
        setSize(1080, 700);
        setTitle("Java07-FlowLayout");

        setLocationRelativeTo(null);

        Image image = new ImageIcon(getClass().getResource("/images/64px_flower.png")).getImage();
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
        
        List<String> buttons = Arrays.asList("HomePage","Emp");
        for(String btnText:buttons){
            JButton button= new JButton();
            button.setText(btnText);
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
        pnCenter.setLayout(cardLayout);
        pnCenter.add(new pnHomePage(),"HomePage");
        pnCenter.add(new pnEmployee(),"Employee");

        splitPane = new JSplitPane();
        splitPane.setOneTouchExpandable(true);
        splitPane.setOrientation(HORIZONTAL_SPLIT);
        splitPane.add(splitPanePnLeft, LEFT);
        splitPane.add(pnCenter, RIGHT);
        conn.add(splitPane, CENTER);
    }

    private void initEvent() {
        
    }

    public static void main(String[] args) {
        Ex04Card that = new Ex04Card();
        that.setVisible(true);

    }

}
