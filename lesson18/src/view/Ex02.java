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
public class Ex02 extends JFrame{

    public Ex02() {
        //ui
        initComponents();
        //event
        initEvents();
    }
//    private static final String Project_Path = new File("").getAbsolutePath();
    private static final String Image_Path = "D:\\Java\\Workspace\\local_Git\\java07-repository-app\\image\\images";// set đường dẫn
    
    
    private void initComponents(){
         this.setTitle("Lê Nhật Phi");
         
        // get screen size (with heigh))
        this.setSize(500, 320); ///set size
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //full set screen
       // Dimension screenSize =  Toolkit.getDefaultToolkit().getScreenSize();
        //int x = screenSize.width/2- frame.getWidth()/2;
       // int y = screenSize.height/2- frame.getHeight()/2;
       // frame.setLocation(x, y);
        
       this.setLocationRelativeTo(null);
      // ImageIcon image = new ImageIcon(getClass().getResource("/image/64px_flower.png"));
       Image image = new ImageIcon(Image_Path + File.separator +"48px_like.png").getImage(); // set hình ảnh cho iconImage
       this.setIconImage(image);
       
       this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // bắt event khi tắt chương trình cho khỏi chạy ngầm
        
        
    }
    private void initEvents(){
        
    }
    
    public static void main(String[] args) {
        Ex02 that = new Ex02();
        that.setVisible(true);
    }
}
