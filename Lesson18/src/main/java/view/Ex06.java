/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import common.Colour;
import java.awt.Color;
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
 * @author ADMIN
 */
public class Ex06 extends JFrame {

    private JLabel lbText;
    private JButton btStop;
    Font font = new Font("Tahoma", Font.BOLD, 18);
    private Container conn = getContentPane();
    private final Random rd = new Random();
    private Thread thread;

    //private static final String PROJECT_PATH=new File("").getAbsolutePath();
    //private static final String IMAGES_PATH=PROJECT_PATH+"\\src\\main\\java\\images";
    public Ex06() {

        //ui
        initComponent();
        //event
        initEvent();
    }

    private void initComponent() {
        setResizable(false);
        setTitle("JAVA07-Random Background");
        setSize(840, 800);

//        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
//        int x=screenSize.width/2-frame.getWidth()/2;
//        int y=screenSize.height/2-frame.getHeight()/2;
//        frame.setLocation(x,y);
        //full screen
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //ss url uri
        Image image = new ImageIcon(getClass().getResource("/images/48px_like.png")).getImage();
        setIconImage(image);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        lbText = new JLabel();
        lbText.setText("Random: YELLOW");
        lbText.setBounds(145, 50, 200, CompUtils.getPreHeight(lbText));
        lbText.setFont(font);
        conn.add(lbText);

        btStop = new JButton();
        btStop.setText("STOP");
        btStop.setFocusPainted(false);
        btStop.setBounds(160, 150, 120, CompUtils.getPreHeight(btStop));
        btStop.setFont(font);
        btStop.setCursor(new Cursor(Cursor.HAND_CURSOR));
        conn.add(btStop);

        randomBackground();
        //vi tri tuong doi
        setLocationRelativeTo(null);

    }

    private void randomBackground() {
        //creat

        thread = new Thread(() -> {
            while (true) {
                Colour[] colours = Colour.values();
                Colour colour = colours[rd.nextInt(colours.length)];
                lbText.setText("Random: " + colour.name().toUpperCase());
                conn.setBackground(colour.getColor());
                sleep(1);
            }
//han che cua thread tra ve void
//future task
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
        Ex06 that = new Ex06();
        that.setVisible(true);
    }

}
