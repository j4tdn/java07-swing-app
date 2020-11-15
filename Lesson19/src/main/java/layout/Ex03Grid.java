/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author ADMIN
 */
public class Ex03Grid extends JFrame {
    private final GridLayout gridLayout=new GridLayout(5, 5);// rows != 0 => ignore columns
                                                                      //  cols = total / rows  
                                                             // rows = 0 & cols = 0 => error
                                                                      // & cols != 0 => rows = total / cols
    private final Font font = new Font("Tahoma", Font.PLAIN, 20);
    private final Container conn = getContentPane();
    
    public Ex03Grid() {
        //UI
        initComponents();
        //events
        initEvents();
    }

    private void initComponents() {
        setTitle("JAVA07 - GridLayout");
        setResizable(false);
        setSize(1080, 700);

        setLocationRelativeTo(null);

        Image image = new ImageIcon(getClass().getResource("/images/48px_like.png")).getImage();
        setIconImage(image);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(gridLayout);
        
        addRoom(26);
    }

    private void addRoom(int room){
        for (int i=1;i<=room;i++){
            JButton button=new JButton();
            button.setText("Room "+(100+i));
            button.setFont(font);
            button.setFocusPainted(false);
            conn.add(button);
        }
    }
    
    private void initEvents() {

    }

    public static void main(String[] args) {
        Ex03Grid that = new Ex03Grid();
        that.setVisible(true);
    }
}
