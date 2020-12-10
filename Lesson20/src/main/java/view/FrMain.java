/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import common.CardType;
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
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EnumMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import static javax.swing.JSplitPane.*;
import javax.swing.border.Border;
import view.sub.PnEmployee;
import view.sub.PnHomePage;
import view.sub.PnStudent;
import view.sub.PnStudentForm;

/**
 *
 * @author qphan
 */
public class FrMain extends JFrame {

    private JPanel pnTop;
    private JPanel pnLeftTop;
    private JPanel pnLeftBottom;
    private JPanel pnCenter;

    private JSplitPane splitPane;
    private JSplitPane splitPanePnLeft;

    private Border defaultBorder;
    private JButton previousClickedButton;
    private final Border hightlightBorder = BorderFactory.createLineBorder(Color.RED, 3);

    private final Container conn = getContentPane();
    private final Font font = new Font("Tahoma", Font.PLAIN, 20);

    private final BorderLayout borderLayout = new BorderLayout();
    private final BorderLayout borderLayoutPnCenter = new BorderLayout();
    private final GridLayout gridLayout = new GridLayout(4, 0);

    private final EnumMap<CardType, JPanel> cardMap;
    
    public FrMain() {
        cardMap = new EnumMap<>(CardType.class);
        cardMap.put(CardType.Employee, new PnEmployee());
        cardMap.put(CardType.HomePage, new PnHomePage());
        cardMap.put(CardType.Student, new PnStudent());
        
        initComponents();
        initEvents();
    }

    private void initComponents() {
        setTitle("Da Nang University UI/UX");

        setSize(1320, 800);
        setLocationRelativeTo(null);

        Image image = new ImageIcon(getClass().getResource("/images/student.png")).getImage();
        setIconImage(image);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        conn.setLayout(borderLayout);

        addPanels();
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

        CardType[] cards = CardType.values();
        JButton btHomePage = new JButton();
        btHomePage.setText(cards[0].name());
        btHomePage.setFont(font);
        btHomePage.setFocusPainted(false);
        defaultBorder = btHomePage.getBorder();
        btHomePage.setBorder(hightlightBorder);
        pnLeftTop.add(btHomePage);

        previousClickedButton = btHomePage;
        
        for (int i = 1; i < cards.length; i++) {
            JButton button = new JButton();
            button.setText(cards[i].name());
            button.setFont(font);
            button.setFocusPainted(false);
            pnLeftTop.add(button);
        }

        pnLeftBottom = new JPanel();
        pnLeftBottom.setPreferredSize(new Dimension(180, 0));
        pnLeftBottom.setBackground(Color.YELLOW);

        splitPanePnLeft = new JSplitPane();
        splitPanePnLeft.setOneTouchExpandable(true);
        splitPanePnLeft.setOrientation(VERTICAL_SPLIT);
        splitPanePnLeft.add(pnLeftTop, TOP);
        splitPanePnLeft.add(pnLeftBottom, BOTTOM);

        pnCenter = new JPanel();
        pnCenter.setBackground(Color.PINK);
        pnCenter.setLayout(borderLayoutPnCenter);

        pnCenter.add(new PnHomePage(), BorderLayout.CENTER);

        splitPane = new JSplitPane();
        splitPane.setOneTouchExpandable(true);
        splitPane.setOrientation(HORIZONTAL_SPLIT);
        splitPane.add(splitPanePnLeft, LEFT);
        splitPane.add(pnCenter, RIGHT);

        conn.add(splitPane, CENTER);
    }

    private void initEvents() {
        pnLeftTopEvents();
    }

    private void pnLeftTopEvents() {
        Component[] components = pnLeftTop.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        pnCenter.removeAll();
                        
                        // show correct card panel
                        JPanel panel = cardMap.get(CardType.from(button.getText()));
                        pnCenter.add(panel);
                        
                        // validate
                        // revalidate:
                        // 1. Create new PnHomePage
                        // 2. Revalidate PnCenter
                        pnCenter.revalidate();

                        // Repaint
                        // current: PnHomePage
                        // 
                        pnCenter.repaint();
                        // unhighlight previous button
                        // Option 1: Interate all buttons in pnLeftTop -> setBorder(defaultButton)
                        // Option 2: 
                        previousClickedButton.setBorder(defaultBorder);
                        
                        // highlight current button
                        button.setBorder(hightlightBorder);
                        previousClickedButton = button;
                    }

                });
            }
        }
    }

    public static void main(String[] args) {
        FrMain that = new FrMain();
        that.setVisible(true);
    }
}
