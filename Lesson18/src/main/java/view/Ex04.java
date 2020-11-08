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

    private final Font titleFont = new Font("Tahoma", Font.BOLD, 22);
        private final Font textFont = new Font("Tahoma", Font.PLAIN, 20);
        private final Font textHightlightFont = new Font("Tahoma", Font.BOLD, 20);
    private final Font textErrorMessageFont = new Font("Tahoma", Font.ITALIC, 20);
    private JLabel lbTitle;
    private JTextField tfInput;
    private JButton btSubmit;
    private JTextField tfResult;
    private JLabel lbErrorMessage;

    private final ConverterService converter;

    Container ContentPane = getContentPane();

    public Ex04() {
        converter = new ConverterServiceImpl();

        initComponent();
        initEvent();
    }

    private void initComponent() {
        setTitle("JAVA07 - Text Converter APP");
        ContentPane.setBackground(Color.GREEN);

        setSize(670, 320);
        setResizable(false);
        setLocationRelativeTo(null);
        Image img = new ImageIcon(getClass().getResource("/images/48px_like.png")).getImage();
        setIconImage(img);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // jframe layout default : border layout
        //set layout
        setLayout(null);

        lbTitle = new JLabel();
        lbTitle.setText("--- How to convert text - APP ---");
        lbTitle.setFont(titleFont);
        System.out.println("size : " + getPreWidth(lbTitle));
        System.out.println("size :" + lbTitle);

        lbTitle.setBounds(120, 30, getPreWidth(lbTitle) + 30, getPreHeight(lbTitle));
        add(lbTitle);

        tfInput = new JTextField();
        tfInput.setFont(textFont);
        tfInput.setBounds(120, getPreHeight(lbTitle) + 30 * 2, getPreWidth(lbTitle), 32);
        add(tfInput);

        btSubmit = new JButton();
        btSubmit.setText("Submit");
        btSubmit.setFocusPainted(false);
        btSubmit.setFont(textFont);
        btSubmit.setBounds(120, getPreHeight(lbTitle) + getPreWidth(tfInput) + 30 * 3, (getPreWidth(lbTitle) - 40) / 2, 32);
        btSubmit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(btSubmit);

        tfResult = new JTextField();
        tfResult.setFont(textFont);
        System.out.println("" + getPreWidth(btSubmit));
        System.out.println("" + btSubmit.getSize().width);
        tfResult.setBounds(120 + getDWidth(btSubmit) + 40, getPreHeight(lbTitle) + getPreWidth(tfInput) + 30 * 3, (getPreWidth(lbTitle) - 40) / 2, 32);
        add(tfResult);

        lbErrorMessage = new JLabel();
        lbErrorMessage.setText("Input value is not valid ? ");
        lbErrorMessage.setFont(textErrorMessageFont);
        lbErrorMessage.setForeground(Color.red);
        lbErrorMessage.setBounds(120, btSubmit.getY() + getPreHeight(btSubmit) + 30, getPreWidth(lbErrorMessage), getPreHeight(lbErrorMessage));
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
        // actionlistener : default 
        btSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                convertTfInput();

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btSubmit.setFont(textHightlightFont);
                btSubmit.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btSubmit.setFont(textFont);
                btSubmit.setForeground(Color.black);
            }

           

        }
        );
        
        

    }
     private void convertTfInput() {
                String input = tfInput.getText();
                if(input .isEmpty()){
                    return;
                }
                if(!input.trim().matches("[a-zA-Z\\s]{6,}")){
                    lbErrorMessage.setVisible(true);
                }
                else{
                tfResult.setText(converter.convert(input));
                lbErrorMessage.setVisible(false);
                }
            }

    public static void main(String[] args) {
        Ex04 that = new Ex04();
        that.setVisible(true);
    }

}
