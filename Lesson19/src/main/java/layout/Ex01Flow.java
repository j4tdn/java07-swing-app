/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import java.awt.Color;
import static java.awt.ComponentOrientation.*;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
 * @author khanh
 */
public class Ex01Flow extends JFrame {

    private final Container conn = getContentPane();
    private JPanel pnButtons;
    private JRadioButton rdLtoR;
    private JRadioButton rdRtoL;
    private JButton btnSubmit;
    private ButtonGroup orientationGroup = new ButtonGroup();

    private final Font font = new Font("Tohama", Font.PLAIN, 20);
    private final FlowLayout flowLayout = new FlowLayout();

    public Ex01Flow() {

        initComponents();

        initEvent();

    }

    private void initComponents() {
        setSize(870, 300);
        setTitle("Java07-FlowLayout");

        setLocationRelativeTo(null);

        Image image = new ImageIcon(getClass().getResource("/images/64px_flower.png")).getImage();
        setIconImage(image);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        conn.setLayout(flowLayout);

        addButtons(5);
        addForm();
    }

    private void addForm() {

        rdLtoR = new JRadioButton();
        rdLtoR.setText("Left To Right");
        rdLtoR.setFocusPainted(false);
        rdLtoR.setFont(font);
        rdLtoR.setSelected(true);
        conn.add(rdLtoR);

        rdRtoL = new JRadioButton();
        rdRtoL.setText("Right To Left");
        rdLtoR.setFocusPainted(false);
        rdRtoL.setFont(font);
        conn.add(rdRtoL);

        orientationGroup.add(rdLtoR);
        orientationGroup.add(rdRtoL);

        btnSubmit = new JButton();
        btnSubmit.setText("Submit");
        btnSubmit.setFocusPainted(false);
        btnSubmit.setFont(font);
        conn.add(btnSubmit);
    }

    private void addButtons(int nOfButtons) {
        flowLayout.setHgap(15);
        flowLayout.setVgap(10);
        pnButtons = new JPanel();
        pnButtons.setLayout(flowLayout);

        Border insideBorder = BorderFactory.createEtchedBorder(Color.RED, Color.GREEN);
        Border outsideBorder = BorderFactory.createEmptyBorder(30, 0, 0, 0);
        Border border = BorderFactory.createCompoundBorder(outsideBorder, insideBorder);
        pnButtons.setBorder(border);
        for (int i = 1; i <= nOfButtons; i++) {
            JButton button = new JButton();
            button.setFont(font);
            button.setFocusPainted(false);
            button.setText("Button: " + i);
            if (i == 4) {
                button.setText("Long name Button:" + i);
            }
            pnButtons.add(button);
        }
        conn.add(pnButtons);
    }

    private void initEvent() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                pnButtons.applyComponentOrientation(rdLtoR.isSelected() ? LEFT_TO_RIGHT : RIGHT_TO_LEFT);
                pnButtons.revalidate();
                //re,in,va
            }
        });

    }

    public static void main(String[] args) {
        Ex01Flow that = new Ex01Flow();
        that.setVisible(true);

    }

}
