/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import service.NumberService;
import service.NumberServiceImpl;
import static utils.CompUtils.getDWidth;
import static utils.CompUtils.getPreHeight;
import static utils.CompUtils.getPreWidth;

/**
 *
 * @author khanh
 */

public class Ex01 extends JFrame{
    private JLabel lbTitle;
    private JLabel lbInput;
    private JLabel lbResult;
    private JTextField tfResult;
    
    private JTextField tfInput;
    private JButton btnSubmit;
    private final NumberService service;
    private final Font font = new Font("Tahoma", Font.BOLD, 16);

    public Ex01() {
        service =new NumberServiceImpl();
        initComponents();
        
        initEvent();
        
    }
    
    private void initComponents(){
        setSize(440, 300);
        setTitle("Java07-HELLO APP");
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        
        
        Image image = new ImageIcon(getClass().getResource("/images/64px_flower.png")).getImage();
        setIconImage(image);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        lbTitle = new JLabel();
        lbTitle.setFont(font);
        lbTitle.setForeground(Color.green);
        lbTitle.setText("TRUNCATE-NUMBER");
        
        lbTitle.setBounds(120, 30, getPreWidth(lbTitle), getPreHeight(lbTitle));
        add(lbTitle);
        
        lbInput =new JLabel();
        lbInput.setText("Nhập dãy số : ");
        lbInput.setBounds(50, getPreHeight(lbTitle) + 30 * 2, getPreWidth(lbInput), 24);
        add(lbInput);
        
        tfInput = new JTextField();
        tfInput.setBounds(50 +getPreWidth(lbInput)+10, getPreHeight(lbTitle) + 30 * 2, getPreWidth(lbTitle), 24);
        add(tfInput);
        
        lbResult = new JLabel();
        lbResult.setText("Kết quả: ");
        lbResult.setBounds(50, getPreHeight(lbTitle) + getPreHeight(tfInput) + 30 * 3, getPreWidth(lbResult), 24);
        add(lbResult);
        

        tfResult = new JTextField();
        tfResult.setBounds(50 + getDWidth(lbResult) + 40, getPreHeight(lbTitle) + getPreHeight(tfInput) + 30 * 3, (getPreWidth(lbTitle) - 40), 24);
        tfResult.setEditable(false);
        add(tfResult);
        
        btnSubmit = new JButton();
        btnSubmit.setText("Thực hiện");
        btnSubmit.setFocusPainted(false);
        btnSubmit.setFont(font);
        btnSubmit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSubmit.setBounds(50 + getDWidth(lbResult)+getDWidth(tfResult) + 60, getPreHeight(lbTitle) + getPreHeight(tfInput) + 30 * 3, getPreWidth(btnSubmit), 24);
        add(btnSubmit);
        
    }
    
        private void initEvent() {
            btnSubmit.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                   tfResult.setText(service.getOnlyOneNumbers(tfInput.getText()));
                }
                        
            });
            
    }
        
    public static void main(String[] args) {
        Ex01 that = new Ex01();
        that.setVisible(true);
        
    }


}
