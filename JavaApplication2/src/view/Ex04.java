/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import service.ConverterService;
import service.ConverterServiceImpl;
import static utils.CompUtils.*;

/**
 *
 * @author khanh
 */
public class Ex04 extends JFrame {

    Container contentpane = getContentPane();
    private final Font font = new Font("Tahoma", Font.BOLD, 20);
    private final Font titleFont = new Font("Tahoma", Font.BOLD, 26);
    private final Font textHighLightFont = new Font("Tahoma", Font.BOLD, 26);
    private final Font errorFont = new Font("Tahoma", Font.ITALIC, 26);

    private JLabel lbTitle;
    private JLabel lbErrorMessage;
    private JTextField tfInput;
    private JTextField tfResult;
    private JButton btnSubmit;

    private final ConverterService service;

    public Ex04() {
        service = new ConverterServiceImpl();
        initComponents();

        initEvent();

    }

    private void initComponents() {
        setSize(640, 300);
        setResizable(false);
        setLayout(null);
        setTitle("Java07-Text Converter App");
        setLocationRelativeTo(null);

        Image image = new ImageIcon(getClass().getResource("/images/64px_flower.png")).getImage();
        setIconImage(image);
        contentpane.setBackground(Color.green);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        lbTitle = new JLabel();
        lbTitle.setFont(font);
        lbTitle.setText("-----How to convert text - App-----");
        lbTitle.setBounds(120, 30, getPreWidth(lbTitle), getPreHeight(lbTitle));
        add(lbTitle);

        tfInput = new JTextField();
        tfInput.setFont(titleFont);
        tfInput.setBounds(120, getPreHeight(lbTitle) + 30 * 2, getPreWidth(lbTitle), 32);
        add(tfInput);

        btnSubmit = new JButton();
        btnSubmit.setText("Submit");
        btnSubmit.setFocusPainted(false);
        btnSubmit.setFont(font);
        btnSubmit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSubmit.setBounds(120, getPreHeight(lbTitle) + getPreHeight(tfInput) + 30 * 3, (getPreWidth(lbTitle) - 40) / 2, 32);
        add(btnSubmit);

        tfResult = new JTextField();
        tfResult.setFont(titleFont);
        tfResult.setBounds(120 + getDWidth(btnSubmit) + 40, getPreHeight(lbTitle) + getPreHeight(tfInput) + 30 * 3, (getPreWidth(lbTitle) - 40) / 2, 32);
        tfResult.setEditable(false);
        add(tfResult);

        lbErrorMessage = new JLabel();
        lbErrorMessage.setText("input value is not valid ");
        lbErrorMessage.setForeground(Color.red);
        lbErrorMessage.setFont(errorFont);
        lbErrorMessage.setBounds(120, btnSubmit.getY() + getPreHeight(btnSubmit) + 30, getPreWidth(lbErrorMessage), getPreHeight(lbErrorMessage));
        lbErrorMessage.setVisible(false);
        add(lbErrorMessage);

    }

    private void initEvent() {

        tfInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    convertTfInput();
                }
            }

        });

        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnSubmit.setFont(textHighLightFont);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSubmit.setFont(font);
                btnSubmit.setForeground(Color.red);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                convertTfInput();
            }

        });
    }

    private void convertTfInput() {
        String input = tfInput.getText();
        if(input.isEmpty()){
            lbErrorMessage.setVisible(false);
            return;
        }
        if(!input.trim().matches("[a-zA-z\\s]{6,}")){
            lbErrorMessage.setVisible(true);
        }else{
            tfResult.setText(service.convert(input));
            lbErrorMessage.setVisible(false);
        }
        
    }

    public static void main(String[] args) {
        Ex04 that = new Ex04();
        that.setVisible(true);

    }

}
