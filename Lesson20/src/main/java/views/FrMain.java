/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import common.CardType;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import static java.awt.BorderLayout.*;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EnumMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;
import view.sub.PnEmployee;
import view.sub.PnHomePage;
import view.sub.PnStudent1;

/**
 *
 * @author ADMIN
 */
public class FrMain extends JFrame {

    private JPanel pnLeft;
    private JPanel pnCenter;
    private JButton previousClickedButton;
    private Border defaultBorder;

    private final Border highlightBorder = BorderFactory.createLineBorder(Color.red, 3);
    private final Font font = new Font("Tahoma", Font.PLAIN, 20);
    private final Container conn = getContentPane();
    private final BorderLayout borderLayout = new BorderLayout();
    private final BorderLayout borderLayoutPnCenter = new BorderLayout();
    private final GridLayout gridLayout = new GridLayout(5, 0);
    private final EnumMap<CardType, JPanel> cardMap;

    public FrMain() {
        cardMap = new EnumMap<>(CardType.class);
        cardMap.put(CardType.HomePage, new PnHomePage());
        cardMap.put(CardType.Employee, new PnEmployee());
        cardMap.put(CardType.Student, new PnStudent1());
        //UI
        initComponents();
        //events
        initEvents();
    }

    private void initComponents() {
        setTitle("JAVA07 - BorderLayout");
        setResizable(false);
        setSize(1200, 700);

        setLocationRelativeTo(null);

        Image image = new ImageIcon(getClass().getResource("/images/student.png")).getImage();
        setIconImage(image);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(borderLayout);
        addPanel();
    }

    private void addPanel() {
        gridLayout.setVgap(3);

        pnLeft = new JPanel();
        pnLeft.setPreferredSize(new Dimension(200, 300));
        pnLeft.setBackground(Color.GREEN);
        pnLeft.setLayout(gridLayout);

        CardType[] cards = CardType.values();
        JButton btHomePage = new JButton();
        btHomePage.setFocusPainted(false);
        btHomePage.setFont(font);
        btHomePage.setText(cards[0].name());

        defaultBorder = btHomePage.getBorder();
        btHomePage.setBorder(highlightBorder);
        previousClickedButton = btHomePage;
        pnLeft.add(btHomePage);

        for (int i = 1; i < cards.length; i++) {
            JButton button = new JButton();
            button.setFocusPainted(false);
            button.setFont(font);
            button.setText(cards[i].name());
            pnLeft.add(button);
            System.out.println(cards[i].name());
        }

        pnCenter = new JPanel();
        pnCenter.setBackground(Color.pink);
        pnCenter.setLayout(borderLayoutPnCenter);

        pnCenter.add(new PnHomePage(), BorderLayout.CENTER);

        conn.add(pnLeft, WEST);

        conn.add(pnCenter, CENTER);
    }

    private void initEvents() {
        pnLeftTopEvents();
    }

    private void pnLeftTopEvents() {
        Component[] components = pnLeft.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        // remove pnCenter's component
                        pnCenter.removeAll();
                        // show correct card panel
                        JPanel panel = cardMap.get(CardType.from(button.getText()));
                        pnCenter.add(panel);
                        pnCenter.repaint();
                        pnCenter.revalidate();
                        // unhighlight previous button
                        previousClickedButton.setBorder(defaultBorder);
                        // highlight current button
                        button.setBorder(highlightBorder);
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
