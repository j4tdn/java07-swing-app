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
 * @author USER
 */
public class Ex01 {

//    private static final String PROJECT_PATH = new File("").getAbsolutePath();
//    private static final String IMAGES_PATH = PROJECT_PATH + "\\src\\images";
    public Ex01() {
        // ui
        initComponents();
        // events
        initEvents();
    }

    private void initComponents() {
        JFrame frame = new JFrame();
        frame.setTitle("JAVA07 - HELLO APP");

        frame.setSize(440, 220);
        // Set full screen
        // frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Get screeen size: width, height
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        int x = screenSize.width / 2 - frame.getWidth() / 2;
//        int y = screenSize.height / 2 - frame.getHeight() / 2;
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Image image = new ImageIcon(getClass().getResource("/images/64px_flower.png")).getImage();

        frame.setIconImage(image);
//        frame.setLocation(x, y);
        frame.setVisible(true);
    }

    private void initEvents() {

    }

    public static void main(String[] args) {
        new Ex01();
    }
}
