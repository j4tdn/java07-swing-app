/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import static utils.CompUtils.*;

/**
 *
 * @author Admin
 */
public class Ex03 extends JFrame{

    public Ex03() {
        //ui
        initComponents();
        //event
        initEvents();
    }
    Container contenPane = getContentPane();
    
    
    
    
    
//    private static final String Project_Path = new File("").getAbsolutePath();
    private static final String Image_Path = "D:\\Java\\Workspace\\local_Git\\java07-repository-app\\image\\images";// set đường dẫn
    private void initComponents(){
         setTitle("Lê Nhật Phi");
         
        setSize(500, 320); ///set size
       setLocationRelativeTo(null);
       Image image = new ImageIcon(Image_Path + File.separator +"48px_like.png").getImage(); // set hình ảnh cho iconImage
       setIconImage(image);
       setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // bắt event khi tắt chương trình cho khỏi chạy ngầm
       
       //setcolor
       contenPane.setBackground(Color.BLUE);
       //set layout
        setLayout(null);
       Font textFont = new Font("tahoma",Font.BOLD, 15);
       JLabel lbfirt = new JLabel();
        lbfirt.setText(" --- hello my name JAVA 07 Class ----");
        lbfirt.setFont(textFont);
        lbfirt.setBounds(120, 30,getPreWidth(lbfirt),getPreHeight(lbfirt));
        add(lbfirt);
        
         JLabel lbSecond = new JLabel();
        lbSecond.setText(" --- hello my  ----");
          lbSecond.setBounds(150, 30+ getPreHeight(lbfirt)+ 30,getPreWidth(lbSecond),getPreHeight(lbSecond));
        add(lbSecond);
        
        JLabel lbThird = new JLabel();
        lbThird.setText(" --- hello my JAVA 07 Class ----");
          lbfirt.setBounds(150, 30,getPreWidth(lbThird),getPreHeight(lbThird));
        add(lbThird);
        
    }
    private void initEvents(){
    }
    
    public static void main(String[] args) {
        Ex03 that = new Ex03();
        that.setVisible(true);
    }
}
