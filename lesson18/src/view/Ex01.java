/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Admin
 */
public class Ex01 {

    public Ex01() {
        //ui
        initComponents();
        //event
        initEvents();
    }
//    private static final String Project_Path = new File("").getAbsolutePath();
    private static final String Image_Path = "D:\\Java\\Workspace\\local_Git\\java07-repository-app\\image\\images";// set đường dẫn
    
    
    private void initComponents(){
        JFrame frame = new JFrame();
         frame.setTitle("Lê Nhật Phi");
         
        // get screen size (with heigh))
        frame.setSize(500, 320); ///set size
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //full set screen
       // Dimension screenSize =  Toolkit.getDefaultToolkit().getScreenSize();
        //int x = screenSize.width/2- frame.getWidth()/2;
       // int y = screenSize.height/2- frame.getHeight()/2;
       // frame.setLocation(x, y);
        
       frame.setLocationRelativeTo(null);
      // ImageIcon image = new ImageIcon(getClass().getResource("/image/64px_flower.png"));
       Image image = new ImageIcon(Image_Path + File.separator +"64px_flower.png").getImage(); // set hình ảnh cho iconImage
       frame.setIconImage(image);
       
       frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // bắt event khi tắt chương trình cho khỏi chạy ngầm
        frame.setVisible(true);
        
    }
    private void initEvents(){
        
    }
    
    public static void main(String[] args) {
         new Ex01();
    }
}
