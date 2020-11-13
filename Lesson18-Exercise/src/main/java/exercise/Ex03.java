/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise;

import common.Colour;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import utils.CompUtils;

/**
 *
 * @author ADMIN
 */
public class Ex03 extends JFrame {

    private JLabel lbText;
    private JButton btStop;
    Font font = new Font("Tahoma", Font.BOLD, 18);
    private Container conn = getContentPane();
    private final Random rd = new Random();
    private Thread thread;

    //private static final String PROJECT_PATH=new File("").getAbsolutePath();
    //private static final String IMAGES_PATH=PROJECT_PATH+"\\src\\main\\java\\images";
    public Ex03() {

        //ui
        initComponent();
        //event
        initEvent();
    }

    private void initComponent() {
        setResizable(false);
        setTitle("JAVA07-Random Background");
        setSize(440, 400);

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
            int tmp=0;
            while (true) {
                Colour[] colours = Colour.values();
                int c= rd.nextInt(colours.length);
                Colour colour = colours[c];
                while (c!=tmp) {
                    lbText.setText("Random: " + colour.name().toUpperCase());
                    conn.setBackground(colour.getColor());
                    tmp=c;
                    sleep(1);
                }
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
        Ex03 that = new Ex03();
        that.setVisible(true);
    }

}
