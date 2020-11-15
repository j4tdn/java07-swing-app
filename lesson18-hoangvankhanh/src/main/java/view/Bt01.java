/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Container;
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
 * @author Asus
 */
public class Bt01 extends JFrame{
    private final Font titleFont = new Font("Tahoma", Font.BOLD, 22);
    private final Font textFont = new Font("Tahoma", Font.PLAIN, 20);
    private final Font textHightlightFont = new Font("Tahoma", Font.BOLD, 20);
    private final Font textErrorMessageFont = new Font("Tahoma", Font.ITALIC, 20);
    private JLabel lbTitle;
    private JLabel lbInput;
    private JLabel lbSubmit;
    private JTextField tfInput;
    private JTextField tfSubmit;
    private JButton btSubmit;
    private JTextField tfResult;
    private JLabel lbErrorMessage;
    Container Contentpane = getContentPane();
    private final ConverterService converter;

    public Bt01() {
        converter = new ConverterServiceImpl();
        initcomponent();
        initEvent();
        
    }
    public void initcomponent(){
        setTitle("Bt1-java07");
        setSize(670, 320);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        
        
        lbTitle = new JLabel();
        lbTitle.setText("TRUNCATE - NUMBER");
        lbTitle.setFont(titleFont);
        lbTitle.setForeground(Color.GREEN);
        lbTitle.setBounds(120, 30, getPreWidth(lbTitle)+30,getPreHeight(lbTitle));
        add(lbTitle);
        
        
        lbInput = new JLabel();
        lbInput.setText("Nhập Dãy Số :");
        lbInput.setFont(textFont);
        lbInput.setBounds(60,getPreHeight(lbInput) + 30*2, getPreWidth(lbInput) + 30, getPreHeight(lbInput));
        add(lbInput);
        
        
        tfInput = new JTextField();
        lbInput.setFont(textFont);
        tfInput.setBounds(90 + getPreWidth(lbInput), getPreHeight(lbInput) + 30*2, 300, getPreHeight(lbInput));
        add(tfInput);
        
        lbSubmit = new JLabel();
        lbSubmit.setText("Kết quả :");
        lbSubmit.setFont(textFont);
        lbSubmit.setBounds(107,getPreHeight(lbInput) + 30*3, getPreWidth(lbSubmit) + 30, getPreHeight(lbSubmit));
        add(lbSubmit);
        
        tfSubmit = new JTextField();
        tfSubmit.setFont(textFont);
        tfSubmit.setBounds(90 + getPreWidth(lbSubmit)+30, getPreHeight(lbSubmit) + 30*3, 150, getPreHeight(lbSubmit));
        add(tfSubmit);
        
        
        btSubmit = new JButton();
        btSubmit.setText("Thực Hiện");
        btSubmit.setFocusable(false);
        btSubmit.setFont(textFont);
        btSubmit.setBounds(275+ getPreWidth(lbSubmit), getPreHeight(lbSubmit) + 30*3, 140,22);
        add(btSubmit);
        
        
        
        
        
        
        
        
        
    }
    public void initEvent(){
            
            
          
    
            
            
            btSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String input = tfInput.getText();
                tfSubmit.setText(converter.getResult(input));

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
    
   
    public static void main(String[] args) {
        Bt01 that = new Bt01();
        that.setVisible(true);
        
    }
    
}
