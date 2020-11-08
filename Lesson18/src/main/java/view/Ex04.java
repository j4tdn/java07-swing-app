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
 * @author ADMIN
 */
public class Ex04 extends JFrame {

    Container contentPane = getContentPane();
    private final Font titleFont = new Font("Tahoma", Font.BOLD, 26);
    private final Font textFont = new Font("Tahoma", Font.PLAIN, 20);
    private final Font textHighlightFont = new Font("Tahoma", Font.BOLD, 23);
    private final Font errorFont = new Font("Tahoma", Font.ITALIC, 23);

    private JLabel lbTitle;
    private JLabel lbErrorMesssage;
    private JTextField tfInput;
    private JTextField tfResult;
    private JButton btSubmit;

    private final ConverterService converter;

    public Ex04() {
        converter = new ConverterServiceImpl();
        //UI
        initComponents();
        //events
        initEvents();
    }

    private void initComponents() {
        setTitle("JAVA07 - Text Converter App");

        setSize(670, 320);
        setResizable(false);
        setLocationRelativeTo(null);

        Image image = new ImageIcon(getClass().getResource("/images/48px_like.png")).getImage();
        setIconImage(image);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        contentPane.setBackground(Color.green);
        setLayout(null);

        lbTitle = new JLabel();
        lbTitle.setText("--- How to convert text - App ---");
        lbTitle.setFont(titleFont);
        lbTitle.setBounds(120, 30, getPreWidth(lbTitle), getPreHeight(lbTitle));
        add(lbTitle);

        tfInput = new JTextField();
        tfInput.setFont(textFont);
        tfInput.setBounds(120, getPreHeight(lbTitle) + 30 * 2, getPreWidth(lbTitle), 32);
        add(tfInput);

        btSubmit = new JButton();
        btSubmit.setText("Submit");
        btSubmit.setBounds(120, getPreHeight(lbTitle) + getPreHeight(tfInput) + 30 * 3, (getPreWidth(lbTitle) - 40) / 2, 32);
        btSubmit.setFont(textFont);
        btSubmit.setFocusPainted(false);
        btSubmit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(btSubmit);

        tfResult = new JTextField();
        tfResult.setFont(textFont);
        tfResult.setBounds(120 + getDWidth(btSubmit) + 40, getPreHeight(lbTitle) + getPreHeight(tfInput) + 30 * 3, (getPreWidth(lbTitle) - 40) / 2, 32);
        //getPreWidth(lbTitle)/2+20
        tfResult.setEditable(false);//chinh sua hay ko
        add(tfResult);

        lbErrorMesssage = new JLabel();
        lbErrorMesssage.setText("Input value is not valid !!!");
        lbErrorMesssage.setForeground(Color.red);
        lbErrorMesssage.setFont(errorFont);
        lbErrorMesssage.setBounds(120, btSubmit.getY() + getPreHeight(btSubmit) + 30, getPreWidth(lbErrorMesssage) + 5, getPreHeight(lbErrorMesssage));
        lbErrorMesssage.setVisible(false);
        add(lbErrorMesssage);
    }

    private void initEvents() {

        tfInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                   convertTfInput();
                }
            }
        });

        //ActionListener : defualt event of each component
        btSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
               convertTfInput();
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

    }

    private void convertTfInput() {
        String input = tfInput.getText();
        if (input.isEmpty()) {
            lbErrorMesssage.setVisible(false);
            return;
        }
        if (!input.trim().matches("[a-zA-Z\\s]{6,}")) {
            lbErrorMesssage.setVisible(true);
        } else {
            tfResult.setText(converter.convert(input));
            lbErrorMesssage.setVisible(false);
        }
    }

    public static void main(String[] args) {
        Ex04 that = new Ex04();
        that.setVisible(true);
    }
}
