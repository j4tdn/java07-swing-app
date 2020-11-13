/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import service.TruncateService;
import service.TruncateServiceImpl;

/**
 *
 * @author ADMIN
 */
public class Ex01 extends JFrame {

    Container contentPane = getContentPane();

    private final Font titleFont = new Font("Tahoma", Font.BOLD, 30);
    private final Font lbFont = new Font("Tahoma", Font.BOLD, 20);
    private final Font textFont = new Font("Tahoma", Font.PLAIN, 20);
 private final Font textHighlightFont = new Font("Tahoma", Font.BOLD, 23);

    private JLabel lbTitle;
    private JLabel lbInput;
    private JLabel lbResult;
    private JTextField tfInput;
    private JTextField tfResult;
    private JButton btSubmit;

    private final TruncateService truncater;

    public Ex01() {
        truncater = new TruncateServiceImpl();
        initComponnent();
        initEvent();
    }

    public static void main(String[] args) {
        Ex01 view = new Ex01();
        view.setVisible(true);
    }

    private void initComponnent() {
        setTitle("Ex01-Truncate");

        setSize(670, 320);
        setResizable(false);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        contentPane.setBackground(Color.GRAY);
        setLayout(null);

        lbTitle = new JLabel();
        lbTitle.setText("TRUNCATE-NUMBER");
        lbTitle.setFont(titleFont);
        lbTitle.setBounds(200, 30, 500, lbTitle.getPreferredSize().height);
        add(lbTitle);

        lbInput = new JLabel();
        lbInput.setText("Nhập dãy số");
        lbInput.setFont(lbFont);
        lbInput.setBounds(120, 30 * 2 + lbTitle.getPreferredSize().height, lbTitle.getPreferredSize().width / 2, 32);
        add(lbInput);

        tfInput = new JTextField();
        tfInput.setFont(textFont);
        tfInput.setBounds(120 + lbTitle.getPreferredSize().width / 2, lbTitle.getPreferredSize().height + 30 * 2, 200, 32);
        add(tfInput);

        lbResult = new JLabel();
        lbResult.setText("Kết quả");
        lbResult.setFont(lbFont);
        lbResult.setBounds(120, 30 * 3 + lbTitle.getPreferredSize().height + lbInput.getPreferredSize().height, lbTitle.getPreferredSize().width / 2, 32);
        add(lbResult);

        tfResult = new JTextField();
        tfResult.setFont(textFont);
        tfResult.setEditable(false);
        tfResult.setBounds(120 + lbTitle.getPreferredSize().width / 2, 30 * 3 + lbTitle.getPreferredSize().height + lbInput.getPreferredSize().height, lbTitle.getPreferredSize().width / 2, 32);
        add(tfResult);

        btSubmit = new JButton();
        btSubmit.setText("Submit");
        btSubmit.setBounds(120 + lbTitle.getPreferredSize().width + 20, lbTitle.getPreferredSize().height + lbInput.getPreferredSize().height + 30 * 3, 100, 32);
        btSubmit.setFont(textFont);
        btSubmit.setFocusPainted(false);
        btSubmit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(btSubmit);

    }

    private void initEvent() {

        tfInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    tfResult.setText(truncater.truncate(tfInput.getText()));
                }
            }
        });

        btSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tfResult.setText(truncater.truncate(tfInput.getText()));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btSubmit.setFont(textHighlightFont);
                btSubmit.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btSubmit.setFont(textFont);
                btSubmit.setForeground(Color.black);
            }

        });

    }

}
