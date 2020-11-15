/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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
import static utils.CompUtils.*;

/**
 *
 * @author ADMIN
 */
public class Bai4 extends JFrame {

    private JLabel lbImage;
    private JButton btStop;
    private Thread thread;
    private final Random rd = new Random();

    public Bai4() {
        initComponent();

        initEvent();
    }

    private void initComponent() {
        setResizable(false);
        setTitle("JAVA07-Random Background");
        setSize(600, 600);

        Image image = new ImageIcon(getClass().getResource("/images/48px_like.png")).getImage();
        setIconImage(image);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(null);
        Font font = new Font("Tahoma", Font.BOLD, 18);

        lbImage = new JLabel();
        lbImage.setBounds(150, 30, 300, 400);
        add(lbImage);

        btStop = new JButton();
        btStop.setText("STOP");
        btStop.setFont(font);
        btStop.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btStop.setFocusPainted(false);
        btStop.setBounds(240, 60 + getDHeight(lbImage), 120, getPreHeight(btStop));
        add(btStop);

        randomImage();

        setLocationRelativeTo(null);
    }

    private void randomImage() {
        thread = new Thread(() -> {
            Image lastImage = null;
            Image[] images = {
                new ImageIcon(getClass().getResource("/images/ghost/1.jpg")).getImage(),
                new ImageIcon(getClass().getResource("/images/ghost/2.jpg")).getImage(),
                new ImageIcon(getClass().getResource("/images/ghost/3.jpg")).getImage(),
                new ImageIcon(getClass().getResource("/images/ghost/4.jpg")).getImage(),
                new ImageIcon(getClass().getResource("/images/ghost/5.jpg")).getImage(),
                new ImageIcon(getClass().getResource("/images/ghost/6.jpg")).getImage(),
                new ImageIcon(getClass().getResource("/images/ghost/7.jpg")).getImage(),
                new ImageIcon(getClass().getResource("/images/ghost/8.jpg")).getImage()
            };
            while (true) {
                Image image = images[rd.nextInt(images.length)];
                if (image.equals(lastImage)) {
                    continue;
                }
                lastImage = image;
                lbImage.setIcon(new ImageIcon(image.getScaledInstance(300, 400, Image.SCALE_SMOOTH)));
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

    private void initEvent() {
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
        Bai4 that = new Bai4();
        that.setVisible(true);
    }
}
