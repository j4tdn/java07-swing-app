/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import static utils.CompUtils.*;

/**
 *
 * @author USER
 */
public class Ex03 extends JFrame {

    Container contentPane = this.getContentPane();

    public Ex03() {
        // ui
        initComponents();
        // events
        initEvents();
    }

    private void initComponents() {
        setTitle("JAVA07 - HELLO APP");

        setSize(500, 220);

        setLocationRelativeTo(null);

        Image image = new ImageIcon(getClass().getResource("/images/48px_like.png")).getImage();
        setIconImage(image);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // setLayout
        setLayout(null);

        contentPane.setBackground(Color.yellow);

        Font textFont = new Font("Tahoma", Font.BOLD, 16);

        JLabel lbFirst = new JLabel();
        lbFirst.setText("Hello world!!!");
        lbFirst.setFont(textFont);
        lbFirst.setBounds(120, 30, getPreWidth(lbFirst), getPreHeight(lbFirst));
        add(lbFirst);

        JLabel lbSecond = new JLabel();
        lbSecond.setText("Ho Duy Long");
        lbSecond.setFont(textFont);
        lbSecond.setBounds(120, 30 + getPreHeight(lbFirst) + 10, getPreWidth(lbSecond), getPreHeight(lbSecond));
        add(lbSecond);
    }

    private void initEvents() {

    }

    public static void main(String[] args) {
        Ex03 that = new Ex03();
        that.setVisible(true);
    }
}
