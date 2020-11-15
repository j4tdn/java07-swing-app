/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.JSplitPane;

import static java.awt.BorderLayout.*;
import java.awt.GridLayout;
import javax.swing.JButton;
import static javax.swing.JSplitPane.*;

/**
 *
 * @author ADMIN
 */
public class Ex03Grid extends JFrame {
//jframe la 1 cua so

    private Container conn = getContentPane();

    private GridLayout gridLayout = new GridLayout(5, 6);

    private Font font=new Font("Tahoma", Font.PLAIN, 15);
    public Ex03Grid() {
        
        initComponent();
        initEvent();
    }

    private void initComponent() {
        setTitle("JAVA07-Grid Layout");
        setSize(1080, 700);
        setLocationRelativeTo(null);

        Image image = new ImageIcon(getClass().getResource("/images/48px_like.png")).getImage();
        setIconImage(image);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(gridLayout);
        addRoom(36);
    }

    private void addRoom(int room) {
        for (int i = 0; i < room; i++) {
            JButton button = new JButton();
            button.setText("Room: " + (100 + i));
            button.setFont(font);
            button.setFocusPainted(true);
            conn.add(button);
        }
    }

    private void initEvent() {

    }

    public static void main(String[] args) {
        Ex03Grid that = new Ex03Grid();
        that.setVisible(true);
    }

}
