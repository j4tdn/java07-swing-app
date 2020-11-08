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
 * @author OS
 */
public class Ex01 {
    
//    private static final String PROJECT_PATH = new File("D:\\Program\\workspace2\\java\\workspace-git\\java07-repository-app\\Lesson18").getAbsolutePath();
//    private static final String IMAGE_PATH = PROJECT_PATH + "\\src\\main\\java\\images";

    public Ex01() {
        //UI
        initComponents();
        //Events
        initEvents();
    }
    
    private void initComponents() {
        JFrame frame = new JFrame();
//      set full screen
//      frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setTitle("JAVA07 - HELLO APP");
        frame.setSize(440, 220);
        
        // get screnn size: width, height
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        int x = screenSize.width / 2 - frame.getWidth() / 2;
//        int y = screenSize.height / 2 - frame.getHeight() / 2;
//        frame.setLocation(x, y);
        frame.setLocationRelativeTo(null);
        
        Image image = new ImageIcon(getClass().getResource("/images/64px_flower.png")).getImage();
        frame.setIconImage(image);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    private void initEvents() {
        
    }
    
    public static void main(String[] args) {
        new Ex01();
    }
}
