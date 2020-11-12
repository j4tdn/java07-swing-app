/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import static utils.CompUtils.*;

/**
 *
 * @author DangHoang
 */
public class Ex01 extends JFrame {

    private final Container conn = getContentPane();
    private JLabel lbText;
    private JButton btResult;

    public Ex01() {
//    UI
        initComponents();
//    Events
        initEvens();
    }

    public static void main(String[] args) {
        new Ex01().setVisible(true);

    }

    private void initComponents() {

        setSize(440, 220);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java-App");
        conn.setBackground(Color.red);
        lbText = new JLabel();
        lbText.setText("Random:GREEN");
        lbText.setBounds((440 - getPreWidth(lbText)) / 2, 40, getPreWidth(lbText), getPreHeight(lbText));
        add(lbText);

        btResult = new JButton();
        btResult.setText("stop");
        btResult.setBounds((440 - getPreWidth(btResult)) / 2 - 10, 120, getPreWidth(btResult), getPreHeight(btResult));
        add(btResult);

    }

    private void initEvens() {
    }
}
