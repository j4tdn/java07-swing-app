package view;


import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import service.RandomColorsService;
import service.RandomColorsServiceImpl;

import static utils.CompUtils.*;

public class Ex06 extends JFrame {

    private JLabel lbTitle;
    private JButton btStop;
    private Container con = getContentPane();

    private final RandomColorsService ran;

    public Ex06() {
        ran = new RandomColorsServiceImpl();

        initComponents();
        initEvents();
    }

    private void initEvents() {

        btStop.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                System.exit(0);
            }
        });

        setBackgrounds();
    }

    private void setBackgrounds() {
        Random rd = new Random();
        int tmp = -1;
        while (true) {
            int n = rd.nextInt(6);
            if (tmp != n) {
                setVisible(true);
                con.setBackground(ran.getColor(n));
                lbTitle.setText(ran.getColorName(n));
                lbTitle.setBounds((600 - getPreWidth(lbTitle)) / 2, 30, getPreWidth(lbTitle), getPreHeight(lbTitle));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tmp = n;
            }

        }
    }

    private void initComponents() {
        setSize(600, 400);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        lbTitle = new JLabel();
        btStop = new JButton();

        lbTitle.setFont(new Font("Tahoma", Font.BOLD, 36));
        add(lbTitle);

        btStop.setFont(new Font("Tahoma", Font.BOLD, 26));
        btStop.setText("STOP");
        btStop.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btStop.setBounds((600 - getPreWidth(btStop)) / 2 - 10, 300, getPreWidth(btStop), getPreHeight(btStop));
        btStop.setFocusable(false);
        add(btStop);

    }

    public static void main(String[] args) {

        new Ex06().setVisible(true);

    }
}
