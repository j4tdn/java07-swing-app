/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import common.Colour;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import utils.CompUtils;

/**
 *
 * @author qphan
 */
public class Ex06 extends JFrame {

    private JLabel lbText;
    private JButton btStop;

    private Thread thread;
    private final Random rd = new Random();
    private final Container conn = getContentPane();

    public Ex06() {
        initComponents();
        initEvents();
    }

    private void initComponents() {
        setResizable(false);
        setTitle("JAVA07 - Random Background");

        setSize(440, 400);
        setLocationRelativeTo(null);

        Image image = new ImageIcon(getClass().getResource("/images/48px_like.png")).getImage();
        setIconImage(image);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(null);

        Font font = new Font("Tahoma", Font.BOLD, 18);

        lbText = new JLabel();
        lbText.setText("Random: GREEN");
        lbText.setFont(font);
        lbText.setBounds(145, 50,
                200,
                CompUtils.getPreHeight(lbText));
        conn.add(lbText);

        btStop = new JButton();
        btStop.setText("STOP");
        btStop.setFocusPainted(false);
        btStop.setFont(font);
        btStop.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btStop.setBounds(160, 150, 120,
                CompUtils.getPreHeight(btStop));
        conn.add(btStop);

        randomBackground();
    }

    private void randomBackground() {
        // create thread run parallel with main thread
        thread = new Thread(() -> {
            while (true) {
                Colour[] colours = Colour.values();
                Colour colour = colours[rd.nextInt(colours.length)];
                lbText.setText("Random: " + colour.name().toUpperCase());
                conn.setBackground(colour.getColor());
                sleep(1);
            }
        });
        thread.start();
    }

    private void sleep(long second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void initEvents() {
        btStop.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                thread.interrupt();
                sleep(3);
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        Ex06 that = new Ex06();
        that.setVisible(true);
    }
}
