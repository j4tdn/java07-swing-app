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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import static utils.CompUtils.*;

/**
 *
 * @author OS
 */
public class Ex04 extends JFrame {

    private final Container conn = this.getContentPane();
    private final Random rd = new Random();
    private Image imageRandom;
    private JLabel lbImage;
    private Thread threadBackground;
    private Thread threadImage;
    private JLabel lbText;
    private JButton btStop;

    public Ex04() {
        //UI
        initComponents();
        //Events
        initEvents();
    }

    private void initComponents() {
        setTitle("JAVA07 - Random Background");

        setSize(800, 800);
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
        
        imageRandom = new ImageIcon(getClass().getResource("/images/ghost/1.jpg")).getImage();
        lbImage = new JLabel(new ImageIcon(imageRandom));
        lbImage.setBounds(100, 150, getPreWidth(lbImage), 500);
        add(lbImage);

        btStop = new JButton();
        btStop.setText("Stop");
        btStop.setBounds(300, 80, 120, getPreHeight(btStop));
        btStop.setFocusPainted(false);
        btStop.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btStop.setFont(font);
        add(btStop);
        randomBackgroundAndImage();
    }

    private void randomBackgroundAndImage() {
        //create thread run parallel with main thread
        threadBackground = new Thread(() -> {
            while (true) {
                Colour[] colours = Colour.values();
                Colour colour = colours[rd.nextInt(colours.length)];
                lbText.setText("Random: " + colour.name().toUpperCase());
                conn.setBackground(colour.getColour());
                sleep(1000);
            }
        });
        
        threadImage = new Thread(() -> {
            while(true) {
                int index = 1+ rd.nextInt(8);
                imageRandom = new ImageIcon(getClass().getResource("/images/ghost/" + index + ".jpg")).getImage();
                lbImage.setIcon(new ImageIcon(imageRandom));
                sleep(1000);
            }
        });
        
        threadImage.start();
        threadBackground.start();
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            Logger.getLogger(Ex04.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initEvents() {
        btStop.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                threadImage.interrupt();
                threadBackground.interrupt();
                sleep(3000);
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        Ex04 app = new Ex04();
        app.setVisible(true);
    }
}