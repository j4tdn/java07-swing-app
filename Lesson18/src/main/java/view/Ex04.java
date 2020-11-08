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
 * @author OS
 */
public class Ex04 extends JFrame{

    Container contentPain = this.getContentPane();
    private JLabel lbTitle;
    private JTextField tfInput;
    private JButton btSubmit;
    private JTextField tfResult;
    private JLabel lbErrorMessage;
    private final Font titleFont = new Font("Tahoma", Font.BOLD, 26);
    private final Font textFont = new Font("Tahoma", Font.PLAIN, 20);
    private final Font textHighlightFont = new Font("Tahoma", Font.BOLD, 23);
    private final Font textError = new Font("Tahoma", Font.ITALIC, 20);
    
    private final ConverterService converter;

    public Ex04() {
        converter = new ConverterServiceImpl();
        //UI
        initComponents();
        //Events
        initEvents();
    }
    
    private void initComponents() {
        setTitle("JAVA07 - Text Converter App");
        setSize(670, 320);
        setResizable(false);
        setLocationRelativeTo(null);
        contentPain.setBackground(Color.GREEN);
        Image image = new ImageIcon(getClass().getResource("/images/48px_like.png")).getImage();
        setIconImage(image);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        //JFrame: layout default: border layout;
        //setLayout
        setLayout(null);
        
        lbTitle = new JLabel();
        lbTitle.setText("--- How to convert text - App ---");
        lbTitle.setFont(titleFont);
        lbTitle.setBounds(120, 30, getPreWidth(lbTitle),getPreHeight(lbTitle));
        add(lbTitle);
        
        tfInput = new JTextField();
        tfInput.setBounds(120, getPreHeight(lbTitle) + 30 * 2, getPreWidth(lbTitle), 32);
        tfInput.setFont(textFont);
        add(tfInput);
        
        btSubmit = new JButton();
        btSubmit.setBounds(120, getPreHeight(lbTitle) + getPreHeight(tfInput) + 30 * 3, (getPreWidth(lbTitle) - 40) / 2, 32);
        btSubmit.setFont(textFont);
        btSubmit.setFocusPainted(false);
        btSubmit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btSubmit.setText("Submit");
        add(btSubmit);
        
        tfResult = new JTextField();
        tfResult.setBounds(120 + getDWidth(btSubmit) + 40, getPreHeight(lbTitle) + getPreHeight(tfInput) + 30 * 3, (getPreWidth(lbTitle) - 40) / 2, 32);
        tfResult.setFont(textFont);
        tfResult.setEditable(false);
        add(tfResult);
        
        lbErrorMessage = new JLabel();
        lbErrorMessage.setText("Input value is not valid!!!");
        lbErrorMessage.setFont(textError);
        lbErrorMessage.setForeground(Color.RED);
        lbErrorMessage.setBounds(120, btSubmit.getY() + getDHeight(btSubmit) + 30 , getPreWidth(lbErrorMessage) + 5, getPreHeight(lbErrorMessage));
        lbErrorMessage.setVisible(false);
        add(lbErrorMessage);
    }
    
    private void initEvents() {
        tfInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    convertInput();
                }
            }      
        });
        
        btSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                convertInput();
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                btSubmit.setFont(textHighlightFont);
                btSubmit.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btSubmit.setFont(textFont);
                btSubmit.setForeground(Color.BLACK);
            }
       });
    }
    
    private void convertInput() {
        String input = tfInput.getText();
        if (input.isEmpty()) {
            lbErrorMessage.setVisible(false);
            return;
        }
        if (!input.trim().matches("[a-zA-Z\\s]{6,}")) {
            lbErrorMessage.setVisible(true);
        } else {
           tfResult.setText(converter.convert(input.trim()));
           lbErrorMessage.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        Ex04 app = new Ex04();
        app.setVisible(true);
    }
}
