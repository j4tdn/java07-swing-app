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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
 * @author
 */
public class Bai1 extends JFrame {

    Container contentPane = getContentPane();
    private final Font titleFont = new Font("Tahoma", Font.BOLD, 26);
    private final Font textFont = new Font("Tahoma", Font.PLAIN, 20);
    private final Font textHighlightFont = new Font("Tahoma", Font.BOLD, 23);
    private final Font errorFont = new Font("Tahoma", Font.ITALIC, 23);
    private JLabel lbTitle;
    private JLabel lbMessage;
    private JLabel lbResult;
    private JLabel lbErrorMessage;
    private JTextField tfInput;
    private JButton btSubmit;
    private JTextField tfResult;

    private final ConverterService converter;

    public Bai1() {
        converter = new ConverterServiceImpl();

        //UI
        initComponents();
        //events
        initEvents();
    }

    private void initComponents() {
        setTitle("Exercise1");

        setSize(700, 420);
        setResizable(false);
        setLocationRelativeTo(null);

        //Image image = new ImageIcon(getClass().getResource("/images/48px_like.png")).getImage();
        //setIconImage(image);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //JFrame layout default : BorderLayout
        //setLayout
        setLayout(null);
        // Foreground : mau chu
        // background : mau nen
        //contentPane.setBackground(Color.green);

        lbTitle = new JLabel();
        lbTitle.setText("TRUNCATE - NUMBER");
        lbTitle.setForeground(Color.green);
        lbTitle.setFont(titleFont);
        lbTitle.setBounds(225, 30, getPreWidth(lbTitle), getPreHeight(lbTitle));
        add(lbTitle);

        lbMessage = new JLabel();
        lbMessage.setText("Nhập dãy số:");
        lbMessage.setFont(textFont);
        lbMessage.setBounds(90, getPreHeight(lbTitle) + 30 * 2, getPreWidth(lbMessage), getPreHeight(lbMessage));
        add(lbMessage);
        
        tfInput = new JTextField();
        tfInput.setFont(textFont);
        tfInput.setBounds(90+getDWidth(lbMessage)+30, getPreHeight(lbTitle) + 30 * 2, 360, 32);
        add(tfInput);
        
        lbResult = new JLabel();
        lbResult.setText("Kết quả:");
        lbResult.setFont(textFont);
        lbResult.setBounds(130, getPreHeight(lbTitle)+ getPreHeight(lbMessage) + 30 * 3, getPreWidth(lbResult), getPreHeight(lbResult));
        add(lbResult);
        
        tfResult = new JTextField();
        tfResult.setFont(textFont);
        tfResult.setBounds(130 + getPreWidth(lbResult) + 30, getPreHeight(lbTitle)+ getPreHeight(lbMessage) + 30 * 3, 190, 32);
        tfResult.setEditable(false);
        add(tfResult);
        
        btSubmit = new JButton();
        btSubmit.setBounds(130 + getPreWidth(lbResult) + getDWidth(tfResult)+50, getPreHeight(lbTitle)+ getPreHeight(lbMessage) + 30 * 3, 150, 32);
        btSubmit.setFont(textFont);
        btSubmit.setFocusPainted(false);
        btSubmit.setText("Thực hiện");
        btSubmit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(btSubmit);
        
        lbErrorMessage = new JLabel();
        lbErrorMessage.setText("Input value is not valid !!!");
        lbErrorMessage.setForeground(Color.red);
        lbErrorMessage.setFont(errorFont);
        lbErrorMessage.setBounds(225, btSubmit.getY() + getPreHeight(btSubmit) + 30, getPreWidth(lbErrorMessage) + 5, getPreHeight(lbErrorMessage));
        lbErrorMessage.setVisible(false);
        add(lbErrorMessage);
    }

    private void initEvents() {
        // ActionListener is default event of every component
        btSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                convertTfInput();
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

        tfInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    convertTfInput();
                }
            }
        });
    }

    private void convertTfInput() {
        String input = tfInput.getText().trim();
        if (input.isEmpty()){
            lbErrorMessage.setVisible(false);
            return ;
        }
        if (!input.trim().matches("[0-9,\\s]{1,}")){
            lbErrorMessage.setVisible(true);
        } else {
            //tfResult.setText(converter.truncate(input));
            lbErrorMessage.setVisible(false);
        }
    }

    public static void main(String[] args) {
        Bai1 that = new Bai1();
        that.setVisible(true);
    }
}
