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
import static utils.CompUtils.*;

/**
 *
 * @author OS
 */
public class Ex03 extends JFrame {

    private final Container conn = this.getContentPane();
    private final Random rd = new Random();
    private Thread thread;
    private JLabel lbText;
    private JButton btStop;

    public Ex03() {
        //UI
        initComponents();
        //Events
        initEvents();
    }

    private void initComponents() {
        setTitle("JAVA07 - Random Background");

        setSize(440, 440);
        setLocationRelativeTo(null);

        Image image = new ImageIcon(getClass().getResource("/images/48px_like.png")).getImage();
        setIconImage(image);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        Font font = new Font("Tahoma", Font.BOLD, 18);

        lbText = new JLabel();
        lbText.setText("Random: GREEN");
        lbText.setBounds(145, 50, 200, getPreWidth(lbText));
        lbText.setFont(font);
        add(lbText);

        btStop = new JButton();
        btStop.setText("Stop");
        btStop.setBounds(160, 180, 120, getPreHeight(btStop));
        btStop.setFocusPainted(false);
        btStop.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btStop.setFont(font);
        add(btStop);
        randomBackground();
    }

    private void randomBackground() {
        //create thread run parallel with main thread
        thread = new Thread(() -> {
            while (true) {
                Colour[] colours = Colour.values();
                Colour colour = colours[rd.nextInt(colours.length)];
                lbText.setText("Random: " + colour.name().toUpperCase());
                conn.setBackground(colour.getColour());
                sleep(1000);
            }
        });

        thread.start();
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            Logger.getLogger(Ex03.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initEvents() {
        btStop.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                thread.interrupt();
                sleep(3000);
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        Ex03 app = new Ex03();
        app.setVisible(true);
    }
}