/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author DangHoang
 */
public class Ex01 {
    
    public Ex01() {
//    UI
    initComponents();
//    Events
    initEvens();
    }
    
    public static void main(String[] args) {
        new Ex01();
    }
    
    private void initComponents(){
        JFrame frame = new JFrame();
        frame.setSize(440, 220);
//        set full screen
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
//        get screen size: width, height
//        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
//        int x = screen.width / 2 - frame.getWidth() / 2;
//        int y = screen.height / 2 - frame.getHeight()/ 2;
//        frame.setLocation(x, y);

        frame.setLocationRelativeTo(null);
        Image image = new ImageIcon(getClass().getResource("/images/64px_flower.png")).getImage();
        frame.setIconImage(image);

        frame.setTitle("Java-App");
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    private void initEvens(){
    }
}
