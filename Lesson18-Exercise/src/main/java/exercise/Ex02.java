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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.CompoundBorder;
import service.ProcessString;
import service.ProcessStringImpl;
import service.TruncateService;
import service.TruncateServiceImpl;

/**
 *
 * @author ADMIN
 */
public class Ex02 extends JFrame {

    Container contentPane = getContentPane();
    private final ProcessString process;

    private final Font lbFont = new Font("Tahoma", Font.BOLD, 20);
    private final Font textFont = new Font("Tahoma", Font.PLAIN, 20);
    private final Font textHighlightFont = new Font("Tahoma", Font.BOLD, 23);
    private final Font cbFont = new Font("Tahoma", Font.PLAIN, 18);

    private JLabel lbPreform;
    private JLabel lbInput;
    private JLabel lbResult;
    private JTextField tfInput;
    private JTextField tfResult;
    private JButton btSubmit;
    private JButton btReset;
    private JButton btExit;
    private JComboBox cbPerform;
    private JTextArea taResult;

    private final TruncateService truncater;

    public Ex02() {
        truncater = new TruncateServiceImpl();
        process = new ProcessStringImpl();
        initComponnent();
        initEvent();
    }

    public static void main(String[] args) {
        Ex02 view = new Ex02();
        view.setVisible(true);
    }

    private void initComponnent() {
        setTitle("Ex02");

        setSize(670, 550);
        setResizable(false);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        contentPane.setBackground(Color.GRAY);
        setLayout(null);

        lbInput = new JLabel();
        lbInput.setText("Nhập chuỗi ");
        lbInput.setFont(lbFont);
        lbInput.setBounds(120, 30, lbInput.getPreferredSize().width, 32);
        add(lbInput);

        tfInput = new JTextField();
        tfInput.setFont(textFont);
        tfInput.setBounds(120 + lbInput.getPreferredSize().width, 30, 300, 32);
        add(tfInput);

        lbPreform = new JLabel();
        lbPreform.setText("Thực hiện");
        lbPreform.setFont(lbFont);
        lbPreform.setBounds(120, 30 * 2 + lbPreform.getPreferredSize().height, lbPreform.getPreferredSize().width, 32);
        add(lbPreform);

        String pf[] = {"Đếm từ", "Đếm từ trùng lặp", "Chuyển sang tiếng việt không dấu"};
        cbPerform = new JComboBox(pf);
        cbPerform.setSelectedItem("Đếm từ");
        cbPerform.setFont(cbFont);
        cbPerform.setBounds(120 + lbInput.getPreferredSize().width, 30 * 2 + lbPreform.getPreferredSize().height, 300, 32);
        add(cbPerform);

        lbResult = new JLabel();
        lbResult.setText("Kết quả");
        lbResult.setFont(lbFont);
        lbResult.setBounds(120, 30 * 3 + 32 * 2, lbPreform.getPreferredSize().width, 32);
        add(lbResult);

        tfResult = new JTextField();
        tfResult.setFont(textFont);
        tfResult.setEditable(false);
        tfResult.setBounds(120 + lbInput.getPreferredSize().width, 30 * 3 + 32 * 2, 300, 32);
        add(tfResult);

        taResult = new JTextArea(6, 20);
        taResult.setFont(textFont);
        taResult.setEditable(false);
        taResult.setBounds(120 + lbInput.getPreferredSize().width, 30 * 3 + 32 * 2, 300, taResult.getPreferredSize().height);

        btSubmit = new JButton();
        btSubmit.setText("Submit");
        btSubmit.setBounds(130, 30 * 4 + 32 * 3, 130, 32);
        btSubmit.setFont(textFont);
        btSubmit.setFocusPainted(false);
        btSubmit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(btSubmit);

        btReset = new JButton();
        btReset.setText("Reset");
        btReset.setBounds(130 + 130 + 10, 30 * 4 + 32 * 3, 130, 32);
        btReset.setFont(textFont);
        btReset.setFocusPainted(false);
        btReset.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(btReset);

        btExit = new JButton();
        btExit.setText("Exit");
        btExit.setBounds(130 + 130 * 2 + 10 * 2, 30 * 4 + 32 * 3, 130, 32);
        btExit.setFont(textFont);
        btExit.setFocusPainted(false);
        btExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btExit.setBorder(new CompoundBorder());
        add(btExit);

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
                if (cbPerform.getSelectedItem().equals("Đếm từ")) {
                    taResult.setVisible(false);
                    tfResult.setVisible(true);
                    btSubmit.setBounds(130, 30 * 4 + 32 * 3, 130, 32);
                    btReset.setBounds(130 + 130 + 10, 30 * 4 + 32 * 3, 130, 32);
                    btExit.setBounds(130 + 130 * 2 + 10 * 2, 30 * 4 + 32 * 3, 130, 32);
                    tfResult.setText("Có " + process.count(tfInput.getText()));
                }
                if (cbPerform.getSelectedItem().equals("Đếm từ trùng lặp")) {
                    tfResult.setVisible(false);
                    taResult.setVisible(true);
                    add(taResult);
                    btSubmit.setBounds(130, 30 * 4 + 32 * 3 + 100, 130, 32);
                    btReset.setBounds(130 + 130 + 10, 30 * 4 + 32 * 3 + 100, 130, 32);
                    btExit.setBounds(130 + 130 * 2 + 10 * 2, 30 * 4 + 32 * 3 + 100, 130, 32);

                    taResult.setText(process.countDuplicate(tfInput.getText()));

                }
                if (cbPerform.getSelectedItem().equals("Chuyển sang tiếng việt không dấu")) {
                    taResult.setVisible(false);
                    btSubmit.setBounds(130, 30 * 4 + 32 * 3, 130, 32);
                    btReset.setBounds(130 + 130 + 10, 30 * 4 + 32 * 3, 130, 32);
                    btExit.setBounds(130 + 130 * 2 + 10 * 2, 30 * 4 + 32 * 3, 130, 32);
                    tfResult.setVisible(true);
                    tfResult.setText(process.changeVietnamese(tfInput.getText()));
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Click.......");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("release.......");
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
        btReset.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                taResult.setVisible(false);
                tfResult.setVisible(true);
                tfResult.setText("");
                tfInput.setText("");
                cbPerform.setSelectedIndex (0);
                tfInput.requestFocus();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Click.......");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("release.......");
            }

            @Override
            public void mouseEntered(MouseEvent e) {

                btReset.setFont(textHighlightFont);
                btReset.setForeground(Color.red);

            }

            @Override
            public void mouseExited(MouseEvent e) {

                btReset.setFont(textFont);
                btReset.setForeground(Color.black);

            }

        });
        btExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btExit.setFont(textHighlightFont);
                btExit.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btExit.setFont(textFont);
                btExit.setForeground(Color.black);
            }
        });
    }

}
