/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
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
 * @author OS
 */
public class Ex01FlowLayout extends JFrame{
    
    private JPanel pnButtons;
    private JRadioButton rdLeft;
    private JRadioButton rdRight;
    private JButton btSubmit;
    private ButtonGroup orientationGroup = new ButtonGroup();
    private Font font = new Font("Tahoma", Font.PLAIN, 20);
    
    private final Container conn = this.getContentPane();
    private final FlowLayout flayout = new FlowLayout();

    public Ex01FlowLayout() {
        //UI
        initComponents();
        //Events
        initEvents();
    }
    
    private void initComponents() {
        setTitle("JAVA07 - HELLO APP");
        setSize(800, 300);
        setLocationRelativeTo(null);
        Image image = new ImageIcon(getClass().getResource("/images/48px_like.png")).getImage();
        setIconImage(image);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(flayout);
        addButtons(5);
        addForm();
    }
    
    private void addButtons(int nofButtons) {
        pnButtons = new JPanel();
        flayout.setHgap(10);
        flayout.setVgap(10);
        pnButtons.setLayout(flayout);
        Border insideBorder = BorderFactory.createEtchedBorder(Color.RED, Color.GRAY);
        Border ousideBorder = BorderFactory.createEmptyBorder(30, 0, 0, 0);
        System.out.println(ousideBorder.getClass());
        pnButtons.setBorder(insideBorder);
        pnButtons.setBorder(ousideBorder);
        for (int i = 1; i <= nofButtons; i++) {
            JButton button = new JButton();
            button.setFont(font);
            button.setFocusPainted(false);
            button.setText(i == 4 ? "Long-Named Button" + i : "Button" + i);
            pnButtons.add(button);
        }
        this.add(pnButtons);
    }
    
    private void addForm() {
        rdLeft = new JRadioButton();
        rdLeft.setText("Left to right");
        rdLeft.setFont(font);
        rdLeft.setFocusPainted(false);
        orientationGroup.add(rdLeft);
        conn.add(rdLeft);
        
        rdRight = new JRadioButton();
        rdRight.setText("Right to left");
        rdRight.setFocusPainted(false);
        rdRight.setFont(font);
        orientationGroup.add(rdRight);
        conn.add(rdRight);
        
        btSubmit = new JButton();
        btSubmit.setText("Submit");
        btSubmit.setFont(font);
        btSubmit.setFocusPainted(false);
        conn.add(btSubmit);
    }
    
    private void initEvents() {
        btSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                pnButtons.applyComponentOrientation(rdLeft.isSelected() ? ComponentOrientation.LEFT_TO_RIGHT: ComponentOrientation.RIGHT_TO_LEFT);
                pnButtons.revalidate();
            }            
        });
    }
    
    public static void main(String[] args) {
        Ex01FlowLayout app = new Ex01FlowLayout();
        app.setVisible(true);
    }
}
