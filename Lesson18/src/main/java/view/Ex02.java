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
public class Ex02 extends JFrame {

    public Ex02() {
        // ui
        initComponents();
        // events
        initEvents();
    }

    private void initComponents() {
        setTitle("JAVA07 - HELLO APP");

        // set full screen
        // frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(440, 220);

        // get scree size: width, height
        // Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // int x = screenSize.width/2 - frame.getWidth()/2;
        // int y = screenSize.height/2 - frame.getHeight()/2;
        // frame.setLocation(x, y);
        setLocationRelativeTo(null);

        Image image = new ImageIcon(getClass().getResource("/images/48px_like.png")).getImage();
        setIconImage(image);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initEvents() {

    }

    public static void main(String[] args) {
        Ex02 that = new Ex02();
        that.setVisible(true);
    }
}
