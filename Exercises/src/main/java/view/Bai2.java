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
public class Bai2 extends JFrame {

    Container contentPane = getContentPane();
    private final Font textFont = new Font("Tahoma", Font.PLAIN, 20);
    private final Font textHighlightFont = new Font("Tahoma", Font.BOLD, 23);
    private final Font errorFont = new Font("Tahoma", Font.ITALIC, 23);
    private JLabel lbInput;
    private JLabel lbAction;
    private JLabel lbResult;
    private JLabel lbErrorMessage;
    private JTextField tfInput;
    private JButton btView;
    private JButton btReset;
    private JButton btExit;
    private JTextField tfResult;

    private final ConverterService converter;

    public Bai2() {
        converter = new ConverterServiceImpl();

        //UI
        initComponents();
        //events
        initEvents();
    }

    private void initComponents() {
        setTitle("Exercise2");

        setSize(695, 630);
        setResizable(false);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(null);

        lbInput = new JLabel();
        lbInput.setText("Nhập chuỗi:");
        lbInput.setFont(textFont);
        lbInput.setBounds(90, 40, getPreWidth(lbInput), getPreHeight(lbInput));
        add(lbInput);

        tfInput = new JTextField();
        tfInput.setFont(textFont);
        tfInput.setBounds(90 + getPreWidth(lbInput) + 30, 40, 355, 32);
        add(tfInput);

        lbAction = new JLabel();
        lbAction.setText("Thực hiện:");
        lbAction.setFont(textFont);
        lbAction.setBounds(90, 40 + getPreHeight(lbInput) + 30, getPreWidth(lbAction), getPreHeight(lbAction));
        add(lbAction);

        //
        lbResult = new JLabel();
        lbResult.setText("Kết quả:");
        lbResult.setFont(textFont);
        lbResult.setBounds(90, 40 + getPreHeight(lbInput) + getPreHeight(lbAction) + 30 * 2, getPreWidth(lbResult), getPreHeight(lbResult));
        add(lbResult);

        tfResult = new JTextField();
        tfResult.setFont(textFont);
        tfResult.setBounds(90 + getPreWidth(lbInput) + 30, 40 + getPreHeight(lbInput) + getPreHeight(lbAction) + 30 * 2, 355, 250);
        tfResult.setEditable(false);
        add(tfResult);
        
        btView = new JButton();
        btView.setBounds(90, 40 + getPreHeight(lbInput) + getPreHeight(lbAction) +getDHeight(tfResult)+ 30 * 3, 150, 32);
        btView.setFont(textFont);
        btView.setFocusPainted(false);
        btView.setText("View");
        btView.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(btView);
        
        btReset = new JButton();
        btReset.setBounds(90 + getDWidth(btView)+20, 40 + getPreHeight(lbInput) + getPreHeight(lbAction) +getDHeight(tfResult)+ 30 * 3, 150, 32);
        btReset.setFont(textFont);
        btReset.setFocusPainted(false);
        btReset.setText("Reset");
        btReset.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(btReset);
        
        btExit = new JButton();
        btExit.setBounds(90 + getDWidth(btView)+getDWidth(btReset)+20*2, 40 + getPreHeight(lbInput) + getPreHeight(lbAction) +getDHeight(tfResult)+ 30 * 3, 150, 32);
        btExit.setFont(textFont);
        btExit.setFocusPainted(false);
        btExit.setText("Exit");
        btExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(btExit);
        
        lbErrorMessage = new JLabel();
        lbErrorMessage.setText("Input value is not valid !!!");
        lbErrorMessage.setForeground(Color.red);
        lbErrorMessage.setFont(errorFont);
        lbErrorMessage.setBounds(210, btExit.getY() + getPreHeight(btExit) + 30, getPreWidth(lbErrorMessage) + 5, getPreHeight(lbErrorMessage));
        lbErrorMessage.setVisible(false);
        add(lbErrorMessage);
    }

    private void initEvents() {/*
        // ActionListener is default event of every component
        btExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                convertTfInput();
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
            tfResult.setText(converter.truncate(input));
            lbErrorMessage.setVisible(false);
        }*/
    }

    public static void main(String[] args) {
        Bai2 that = new Bai2();
        that.setVisible(true);
    }
}
