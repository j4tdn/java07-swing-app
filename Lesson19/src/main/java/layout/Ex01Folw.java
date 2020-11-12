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
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

/**
 *
 * @author DangHoang
 */
public class Ex01Folw extends JFrame {

    private final Container con = getContentPane();
    private JPanel pnButton;
    private JRadioButton rdLtoR;
    private JRadioButton rdRtoL;
    private JButton btSubmit;

    private final ButtonGroup orientationGroup = new ButtonGroup();
    private final FlowLayout flowLayout = new FlowLayout();
    private final Font font = new Font("Tahoma", Font.PLAIN, 13);

    public Ex01Folw() {
        initComponents();
        initEvents();
    }

    private void initComponents() {
        setSize(600, 400);
        setLayout(flowLayout);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addButtons(5);
        addForm();
    }

    private void addButtons(int noffButtons) {
        flowLayout.setHgap(15);
        flowLayout.setVgap(10);

        pnButton = new JPanel();
        pnButton.setLayout(flowLayout);
        Border insideBorder = BorderFactory.createEtchedBorder(Color.RED, Color.GREEN);
        Border outsideBorder = BorderFactory.createEmptyBorder(30, 0, 0, 0);
        Border border = BorderFactory.createCompoundBorder(outsideBorder, insideBorder);
        pnButton.setBorder(border);

        for (int i = 1; i <= noffButtons; i++) {
            JButton button = new JButton();
            button.setFocusPainted(false);
            button.setFont(font);
            button.setText(i == 4 ? ("Long-named Button " + i) : ("Button " + i));
            pnButton.add(button);
        }
        con.add(pnButton);
    }

    private void addForm() {
        rdLtoR = new JRadioButton();
        rdLtoR.setText("Left to Right");
        rdLtoR.setFont(font);
        con.add(rdLtoR);

        rdRtoL = new JRadioButton();
        rdRtoL.setText("Right to Left");
        rdRtoL.setFont(font);
        con.add(rdRtoL);

        orientationGroup.add(rdLtoR);
        orientationGroup.add(rdRtoL);

        btSubmit = new JButton();
        btSubmit.setFont(font);
        btSubmit.setText("Submit");

        con.add(btSubmit);
    }

    private void initEvents() {
    }

    public static void main(String[] args) {
        new Ex01Folw().setVisible(true);
    }
}
