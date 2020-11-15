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
import javax.swing.JSplitPane;

import static java.awt.BorderLayout.*;
import static javax.swing.JSplitPane.*;

/**
 *
 * @author ADMIN
 */
public class Ex02Border extends JFrame {
//jframe la 1 cua so

    private JPanel pnTop;
    private JPanel pnLeftTop;
    private JPanel pnLeftBottom;
    private JPanel pnCenter;

    private JSplitPane splitPane;
    private JSplitPane splitPanePnLeft;

    private Container conn = getContentPane();
    private final Font font = new Font("Tahoma", Font.PLAIN, 20);
    private final BorderLayout borderLayout = new BorderLayout();

    public Ex02Border() {
        initComponent();
        initEvent();
    }

    private void initComponent() {
        setTitle("JAVA07-Border Layout");
        setSize(1080, 700);
        setLocationRelativeTo(null);

        Image image = new ImageIcon(getClass().getResource("/images/48px_like.png")).getImage();
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

        splitPane = new JSplitPane();
        splitPane.setOneTouchExpandable(true);
        splitPane.setOrientation(HORIZONTAL_SPLIT);
        splitPane.add(splitPanePnLeft, LEFT);
        splitPane.add(pnCenter, RIGHT);

        conn.add(splitPane);

    }

    private void initEvent() {

    }

    public static void main(String[] args) {
        Ex02Border that = new Ex02Border();
        that.setVisible(true);
    }

}
