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
import java.awt.HeadlessException;

import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import service.ConverterService;
import static utils.CompUtils.*;

/**
 *
 * @author Admin
 */
public class Ex04 extends JFrame {

    Container contenPane = getContentPane();
    private final Font textFont = new Font("tahoma", Font.BOLD, 26); // font cỡ chữ
    private final Font title = new Font("tahoma", Font.PLAIN, 22);
    private final Font submit = new Font("tahoma", Font.PLAIN, 22);
    private final Font textHightLightFont = new Font("tahoma", Font.BOLD, 25);
    private final Font textError = new Font("tahoma", Font.ITALIC, 25);
    private JLabel lbTitle;
    private JTextField tfTnput;
    private JLabel lbError;
    private JButton btSumit;
    private JTextField tfResult;

    private final ConverterService converter;

    public Ex04() throws HeadlessException {
        this.converter = null;
        initComponents();
        //event
        initEvents();
    }

//    private static final String Project_Path = new File("").getAbsolutePath();
    private static final String Image_Path = "D:\\Java\\Workspace\\local_Git\\java07-repository-app\\image\\images";// set đường dẫn

    private void initComponents() {

        setTitle("JAVA07 - Text Converter App");

        setSize(670, 320); ///set size
        setResizable(false); // tắt chức năng phóng to thu nho 
        setLocationRelativeTo(null);

        Image image = new ImageIcon(Image_Path + File.separator + "48px_like.png").getImage(); // set hình ảnh cho iconImage
        setIconImage(image);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // bắt event khi tắt chương trình cho khỏi chạy ngầm

        contenPane.setBackground(Color.GREEN); //set màu 
        //set layout
        setLayout(null);

        //title
        lbTitle = new JLabel();
        lbTitle.setText(" --- How to convert text - App --- ");
        lbTitle.setFont(textFont);
        lbTitle.setBounds(120, 30, getPreWidth(lbTitle), getPreHeight(lbTitle));
        add(lbTitle);

        // TF
        tfTnput = new JTextField();
        tfTnput.setBounds(120, getPreHeight(lbTitle) + 30 * 2, getPreWidth(lbTitle), 32);
        tfTnput.setFont(title);
        add(tfTnput);

        btSumit = new JButton();
        btSumit.setText("Submit");
        btSumit.setBounds(120, getPreHeight(lbTitle) + getPreHeight(tfTnput) + 30 * 3, (getPreWidth(lbTitle) - 40) / 2, 32);
        btSumit.setFont(submit);
        btSumit.setFocusPainted(false);
        btSumit.setCursor(new Cursor(Cursor.HAND_CURSOR));// khi kich vào thì ra con trỏ bàn tay 
        add(btSumit);

        tfResult = new JTextField();
        tfResult.setBounds(120 + getDWidth(btSumit) + 40, getPreHeight(lbTitle) + getPreHeight(tfTnput) + 30 * 3, (getPreWidth(lbTitle) - 40) / 2, 32);
        tfResult.setEditable(false); // khoá lại ko cho kích vào 
        add(tfResult);

        lbError = new JLabel();
        lbError.setText("input vale is not valid!!");
        lbError.setFont(textError);
        lbError.setForeground(Color.red);
        lbError.setBounds(120, btSumit.getY() + 40, getPreWidth(lbError) + 5, getPreHeight(lbError));
        lbError.setVisible(false);

        add(lbError);

    }

    private void initEvents() {

        tfTnput.addKeyListener(new KeyAdapter() {
            
        });


        btSumit.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                String input = tfTnput.getText().trim();
                tfResult.setText(converter.convert(input));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e); //To change body of generated methods, choose Tools | Templates.
                btSumit.setFont(textHightLightFont);
                btSumit.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e); //To change body of generated methods, choose Tools | Templates.
                btSumit.setFont(submit);
                btSumit.setForeground(Color.black);
            }

        });
    }

    private void convertTfInput() {
        String input = tfTnput.getText().trim();
        if (input.isEmpty()) {
             lbError.setVisible(false);
            return;
        }
        if (!input.trim().matches("[a-zA-Z\\s]{6,}")) {
            lbError.setVisible(true);
        } else {
            lbError.setVisible(false);
        }

        tfResult.setText(converter.convert(input));

    }

    public static void main(String[] args) {
        Ex04 that = new Ex04();
        that.setVisible(true);
    }
}
