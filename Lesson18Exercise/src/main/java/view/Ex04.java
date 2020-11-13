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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import utils.CompUtils;

/**
 *
 * @author LONG
 */
public class Ex04 extends JFrame {

    private JLabel lbText;
    private JButton btStop;

    private Thread thread;
    private Thread thread2;

    private final Random rd = new Random();
    private final Container conn = getContentPane();

    public Ex04() {
        initComponents();
        initEvents();
    }

    private void initComponents() {
        setResizable(false);

        setTitle("JAVA07 - RANDOM BACKGROUND & IMAGE");

        setSize(440, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Image image = new ImageIcon(getClass().getResource("/images/48px_like.png")).getImage();

        setIconImage(image);

        setLayout(null);

        Font font = new Font("Tahoma", Font.BOLD, 18);

        lbText = new JLabel();
        lbText.setBounds(120, 50, 200, 200);
        Image image2 = new ImageIcon(getClass().getResource("/images/1.jpg")).getImage();
        ImageIcon imageIcon = new ImageIcon(image2.getScaledInstance(lbText.getWidth(), lbText.getHeight(), Image.SCALE_SMOOTH));
        lbText.setIcon(imageIcon);
        conn.add(lbText);

        btStop = new JButton();
        btStop.setText("STOP");
        btStop.setFont(font);
        btStop.setCursor(new Cursor(Cursor.HAND_CURSOR) {
        });
        btStop.setFocusPainted(false);
        btStop.setBounds(160, 300, 120, CompUtils.getPreHeight(btStop));
        conn.add(btStop);

        randomBackground();
        randomImage();
    }

    private void randomBackground() {
        // create thread run parallel with main thread
        thread = new Thread(() -> {
            while (true) {
                Colour[] colours = Colour.values();
                Colour colour = colours[rd.nextInt(colours.length)];
                conn.setBackground(colour.getColor());
                sleep(1);
            }
        });
        thread.start();
    }

    private void randomImage() {
        thread2 = new Thread(() -> {
            while (true) {
                int numberOfImages = rd.nextInt(7) + 1;
                Image imageRandom = new ImageIcon(getClass().getResource("/images/" + numberOfImages + ".jpg")).getImage();
                ImageIcon imageIconRandom = new ImageIcon(imageRandom.getScaledInstance(lbText.getWidth(), lbText.getHeight(), Image.SCALE_SMOOTH));
                lbText.setIcon(imageIconRandom);
                sleep(1);
            }
        });
        thread2.start();
    }

    private void sleep(long second) {
        try {
            Thread.sleep(1000 * second);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void initEvents() {
        btStop.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                thread.interrupt();
                thread2.interrupt();
                sleep(3);
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        Ex04 that = new Ex04();
        that.setVisible(true);
    }
}
