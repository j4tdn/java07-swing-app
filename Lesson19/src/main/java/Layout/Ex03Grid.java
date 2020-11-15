package Layout;

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
import static java.awt.BorderLayout.*;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import static javax.swing.JSplitPane.*;

/**
 *
 * @author DangHoang
 */
@SuppressWarnings("serial")
public class Ex03Grid extends JFrame {
    
    private final GridLayout gridlayout = new GridLayout(5, 5);
    private final Font font = new Font("Tahoma", Font.BOLD, 20);
    private final Container conn = getContentPane();

    public Ex03Grid() {
//    UI
        initComponents();
//    Events
        initEvens();
    }
    
    public static void main(String[] args) {
        Ex03Grid that = new Ex03Grid();
        that.setVisible(true);
    }
    
    private void initComponents() {
        setSize(1080, 700);
        
        setLocationRelativeTo(null);
        Image image = new ImageIcon(getClass().getResource("/images/64px_flower.png")).getImage();
        setIconImage(image);
        
        setTitle("Java-GridLayout");
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        conn.setLayout(gridlayout);
        addRooms(26);
    }

    private void addRooms(int rooms) {
        for (int i = 1; i <= rooms; i++) {
            JButton button = new JButton();
            button.setText("Room " + (100 + i));
            button.setFont(font);
            button.setFocusPainted(false);
            button.setBackground(Color.GREEN);
            button.setForeground(Color.BLUE);
            conn.add(button);
        }
    }
    
    private void initEvens() {
    }
    
}
