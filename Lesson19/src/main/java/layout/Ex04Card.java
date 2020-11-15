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
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.util.List;
import java.util.Arrays;
import javax.swing.JButton;
import static javax.swing.JSplitPane.*;
import javax.swing.JSplitPane;
import view.sub.panelEmployes;
import view.sub.panelHomePage;

/**
 *
 * @author DangHoang
 */
public class Ex04Card extends JFrame {

    private final Container con = getContentPane();
    private final Font font = new Font("Tahoma", Font.PLAIN, 13);
    private final BorderLayout borderLayout = new BorderLayout();
    private final GridLayout gridLayout = new GridLayout(4, 0);
    private final CardLayout cardLayout = new CardLayout();

    private JPanel pnTop;
    private JSplitPane spPane;
    private JPanel pnCenter;
    private JSplitPane spPaneLeft;
    private JPanel pnLeftTop;
    private JPanel pnLeftBottom;

    public Ex04Card() {
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
        pnLeftTop.setLayout(gridLayout);

        List<String> buttons = Arrays.asList("HomePage", "Employes");
        for (String button : buttons) {
            JButton bt = new JButton();
            bt.setFont(font);
            bt.setText(button);
            bt.setFocusable(false);
            pnLeftTop.add(bt);
        }
        spPaneLeft.add(pnLeftTop, TOP);

        pnLeftBottom.setPreferredSize(new Dimension(140, 0));
        pnLeftBottom.setBackground(Color.YELLOW);
        spPaneLeft.add(pnLeftBottom, BOTTOM);

        pnCenter.setBackground(Color.PINK);
        pnCenter.setLayout(cardLayout);
        pnCenter.add(new panelHomePage(), "HomePage");
        pnCenter.add(new panelEmployes(), "Employes");

        cardLayout.show(pnCenter, "Employes");

        spPane.setOneTouchExpandable(true);
        spPane.setOrientation(HORIZONTAL_SPLIT);
        spPane.add(spPaneLeft, LEFT);
        spPane.add(pnCenter, RIGHT);

        con.add(spPane);
    }

    private void initEvents() {
    }

    public static void main(String[] args) {
        new Ex04Card().setVisible(true);
    }
}
