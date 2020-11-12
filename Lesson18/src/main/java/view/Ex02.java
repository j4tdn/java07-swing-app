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
@SuppressWarnings("serial")
public class Ex02 extends JFrame {

	public Ex02() {
//    UI
		initComponents();
//    Events
		initEvens();
	}

	public static void main(String[] args) {
		Ex02 that = new Ex02();
		that.setVisible(true);
	}

	private void initComponents() {
		setSize(440, 220);
//        set full screen
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

//        get screen size: width, height
//        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
//        int x = screen.width / 2 - frame.getWidth() / 2;
//        int y = screen.height / 2 - frame.getHeight()/ 2;
//        frame.setLocation(x, y);

		setLocationRelativeTo(null);
		Image image = new ImageIcon(getClass().getResource("/images/64px_flower.png")).getImage();
		setIconImage(image);

		setTitle("Java-App");

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	private void initEvens() {
	}
}
