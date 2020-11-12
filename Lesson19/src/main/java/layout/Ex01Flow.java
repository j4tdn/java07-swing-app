/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

/**
 *
 * @author USER
 */
public class Ex01Flow extends JFrame {

    private JPanel pnButtons;

    private JRadioButton rdLtoR;
    private JRadioButton rdRtoL;
    private JButton btSubmit;
    private ButtonGroup orientationGroup = new ButtonGroup();

    private final Font font = new Font("Tahoma", Font.PLAIN, 20);

    private final FlowLayout flayout = new FlowLayout();

    private final Container conn = getContentPane();

    public Ex01Flow() {
        initComponents();
        initEvents();
    }

    private void initComponents() {
        setTitle("JAVA07 - FlowLayout");

        setSize(870, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Image image = new ImageIcon(getClass().getResource("/images/48px_like.png")).getImage();
        setIconImage(image);

        conn.setLayout(flayout);

        addButton(5);
        addForm();
    }

    private void addForm() {

        rdLtoR = new JRadioButton();
        rdLtoR.setText("Left to Right");
        rdLtoR.setFont(font);
        rdLtoR.setFocusPainted(false);
        orientationGroup.add(rdLtoR);
        conn.add(rdLtoR);

        rdRtoL = new JRadioButton();
        rdRtoL.setText("Right to Left");
        rdRtoL.setFont(font);
        rdRtoL.setFocusPainted(false);
        orientationGroup.add(rdRtoL);
        conn.add(rdRtoL);

        btSubmit = new JButton();
        btSubmit.setText("Submit");
        btSubmit.setFont(font);
        conn.add(btSubmit);
    }

    private void addButton(int number) {
        flayout.setHgap(10);
        flayout.setVgap(10);

        pnButtons = new JPanel();
        pnButtons.setLayout(flayout);

        Border insideBorder = BorderFactory.createEtchedBorder(Color.RED, Color.GREEN);
        Border outsideBorder = BorderFactory.createEmptyBorder(30, 0, 0, 0);

        Border border = BorderFactory.createCompoundBorder(outsideBorder, insideBorder);

        pnButtons.setBorder(border);

        for (int i = 1; i <= number; i++) {
            JButton button = new JButton();
            button.setFont(font);
            button.setFocusPainted(false);
            button.setText(i == 4 ? "Long-Named Button " + i : "Button " + i);
            pnButtons.add(button);
        }
        conn.add(pnButtons);
    }

    private void initEvents() {

    }

    public static void main(String[] args) {
        Ex01Flow that = new Ex01Flow();
        that.setVisible(true);
    }
}
