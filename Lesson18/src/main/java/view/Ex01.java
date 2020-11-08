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
 * @author qphan
 */
public class Ex01 {

    public Ex01() {
        // ui
        initComponents();
        // events
        initEvents();
    }
    
    private void initComponents() {
        JFrame frame = new JFrame();
        frame.setTitle("JAVA07 - HELLO APP");
        
        // set full screen
        // frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        frame.setSize(440, 220);
        
        // get scree size: width, height
        // Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // int x = screenSize.width/2 - frame.getWidth()/2;
        // int y = screenSize.height/2 - frame.getHeight()/2;
        // frame.setLocation(x, y);
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
