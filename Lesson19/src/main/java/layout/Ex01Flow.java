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

import static java.awt.ComponentOrientation.*;

/**
 *
 * @author ADMIN
 */
public class Ex01Flow extends JFrame {

    private final Font font = new Font("Tahoma", Font.PLAIN, 20);
    private final Container conn = getContentPane();
    private final FlowLayout flayout = new FlowLayout();

    private JPanel pnButtons;
    private JRadioButton rdLtoR;
    private JRadioButton rdRtoL;
    private JButton btSubmit;
    private ButtonGroup orientationGroup = new ButtonGroup();

    public Ex01Flow() {
        //UI
        initComponents();
        //events
        initEvents();
    }

    private void initComponents() {
        setTitle("JAVA07 - FlowLayout");
        setResizable(false);
        setSize(800, 300);

        setLocationRelativeTo(null);

        Image image = new ImageIcon(getClass().getResource("/images/48px_like.png")).getImage();
        setIconImage(image);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(flayout);

        addButtons(5);
        addForm();
    }

    private void addForm() {
        rdLtoR = new JRadioButton();
        rdLtoR.setText("Left To Right");
        rdLtoR.setFont(font);
        rdLtoR.setFocusPainted(false);
        rdLtoR.setSelected(true);
        conn.add(rdLtoR);

        rdRtoL = new JRadioButton();
        rdRtoL.setText("Right To Left");
        rdRtoL.setFont(font);
        rdRtoL.setFocusPainted(false);
        conn.add(rdRtoL);

        orientationGroup.add(rdLtoR);
        orientationGroup.add(rdRtoL);

        btSubmit = new JButton();
        btSubmit.setText("Submit");
        btSubmit.setFont(font);
        btSubmit.setFocusPainted(false);
        conn.add(btSubmit);
    }

    private void addButtons(int nofButtons) {
        flayout.setHgap(15);
        flayout.setVgap(10);
        pnButtons = new JPanel();
        pnButtons.setLayout(flayout);

        Border insideBorder = BorderFactory.createEtchedBorder(Color.PINK, Color.BLACK);
        Border outsideBorder = BorderFactory.createEmptyBorder(30, 0, 0, 0);
        Border border = BorderFactory.createCompoundBorder(outsideBorder, insideBorder);
        pnButtons.setBorder(border);
        for (int i = 1; i <= nofButtons; i++) {
            JButton button = new JButton();
            button.setFocusPainted(false);
            button.setFont(font);
            button.setText((i == 4) ? "Long-Named Button " + i : "Button " + i);
            pnButtons.add(button);
        }
        conn.add(pnButtons);
    }

    private void initEvents() {
        btSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                pnButtons.applyComponentOrientation(rdLtoR.isSelected()?LEFT_TO_RIGHT:RIGHT_TO_LEFT);
                pnButtons.revalidate();
                // revalidate = invalidate + validate 
                // validate : redraw invalidate comps
                // invalidate : check list of comps need to be redraw
            }
        });
    }

    public static void main(String[] args) {
        Ex01Flow that = new Ex01Flow();
        that.setVisible(true);
    }
}
