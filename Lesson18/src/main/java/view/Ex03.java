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
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import static utils.CompUtils.*;

/**
 *
 * @author DangHoang
 */
@SuppressWarnings("serial")
public class Ex03 extends JFrame {

	Container contentPane = getContentPane();

	public Ex03() {
//    UI
		initComponents();
//    Events
		initEvens();
	}

	public static void main(String[] args) {
		Ex03 that = new Ex03();
		that.setVisible(true);
	}

	private void initComponents() {
		setSize(440, 220);

		setLocationRelativeTo(null);

		Image image = new ImageIcon(getClass().getResource("/images/64px_flower.png")).getImage();
		setIconImage(image);

		setTitle("Java-App");

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        JFrame layout default : border layout
//        setLayout
		setLayout(null);

//        set foreground - brackground
		contentPane.setBackground(Color.BLUE);

		Font textFont = new Font("Tahoma", Font.BOLD, 16);

		JLabel lbFirst = new JLabel();
		lbFirst.setFont(textFont);
		lbFirst.setText("xxxxxxx WELCOME xxxxxxx");
		lbFirst.setBounds(110, 30, getPreWidth(lbFirst), getPreHeight(lbFirst));
		add(lbFirst);

		JLabel lbSecond = new JLabel();
		lbSecond.setFont(textFont);
		lbSecond.setText("JAVA07-APP");
		lbSecond.setBounds(180, 30 + getPreHeight(lbFirst), getPreWidth(lbSecond), getPreHeight(lbSecond));
		add(lbSecond);
	}

	private void initEvens() {
	}
}
