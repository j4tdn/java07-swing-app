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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import static java.awt.BorderLayout.*;
import static javax.swing.JSplitPane.*;
import javax.swing.JSplitPane;

/**
 *
 * @author DangHoang
 */
public class Ex02Border extends JFrame {

    private final Container con = getContentPane();
    private final BorderLayout borderLayout = new BorderLayout();

    private JPanel pnTop;
    private JSplitPane spPane;
    private JPanel pnCenter;
    private JSplitPane spPaneLeft;
    private JPanel pnLeftTop;
    private JPanel pnLeftBottom;

    public Ex02Border() {
        initComponents();
        initEvents();
    }

    private void initComponents() {
        setSize(1080, 600);
        con.setLayout(borderLayout);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addPanels();
    }

    private void addPanels() {
        pnTop = new JPanel();
        spPane = new JSplitPane();
        pnCenter = new JPanel();
        spPaneLeft = new JSplitPane();
        pnLeftTop = new JPanel();
        pnLeftBottom = new JPanel();

        spPaneLeft.setOrientation(VERTICAL_SPLIT);
        spPaneLeft.setOneTouchExpandable(true);

        pnTop.setPreferredSize(new Dimension(0, 100));
        pnTop.setBackground(Color.GREEN);
        con.add(pnTop, NORTH);

        pnLeftTop.setPreferredSize(new Dimension(140, 300));
        pnLeftTop.setBackground(Color.BLACK);
        spPaneLeft.add(pnLeftTop, TOP);

        pnLeftBottom.setPreferredSize(new Dimension(140, 0));
        pnLeftBottom.setBackground(Color.YELLOW);
        spPaneLeft.add(pnLeftBottom, BOTTOM);

        pnCenter.setBackground(Color.PINK);

        spPane.setOneTouchExpandable(true);
        spPane.setOrientation(HORIZONTAL_SPLIT);
        spPane.add(spPaneLeft, LEFT);
        spPane.add(pnCenter, RIGHT);

        con.add(spPane);
    }

    private void initEvents() {
    }

    public static void main(String[] args) {
        new Ex02Border().setVisible(true);
    }
}
