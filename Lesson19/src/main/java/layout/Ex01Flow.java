/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

/**
 *
 * @author ADMIN
 */
public class Ex01Flow extends JFrame {
//jframe la 1 cua so

    private JPanel pnButtons;
    private JRadioButton rdLtoR;
    private JRadioButton rdRtoL;
    private JButton btSubmit;
    private ButtonGroup orientationGroup = new ButtonGroup();

    private Container conn = getContentPane();
    private final Font font = new Font("Tahoma", Font.PLAIN, 20);
    private final FlowLayout flayout = new FlowLayout();

    //private static final String PROJECT_PATH=new File("").getAbsolutePath();
    //private static final String IMAGES_PATH=PROJECT_PATH+"\\src\\main\\java\\images";
    public Ex01Flow() {

        //ui
        initComponent();
        //event
        initEvent();
    }

    private void initComponent() {
        setTitle("JAVA07-Flow Layout");
        setSize(870, 300);
        //vi tri tuong doi
        setLocationRelativeTo(null);

        Image image = new ImageIcon(getClass().getResource("/images/48px_like.png")).getImage();
        setIconImage(image);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        conn.setLayout(flayout);
        addButtons(5);
        addForm();

    }

    private void addForm() {
        rdLtoR = new JRadioButton();
        rdLtoR.setText("Left to Right");
        rdLtoR.setFont(font);
        rdLtoR.setFocusPainted(false);
        conn.add(rdLtoR);

        rdRtoL = new JRadioButton();
        rdRtoL.setText("Right to Left");
        rdRtoL.setFont(font);
        rdRtoL.setFocusPainted(false);
        conn.add(rdRtoL);

        orientationGroup.add(rdLtoR);
        orientationGroup.add(rdRtoL);
        
        btSubmit = new JButton();
        btSubmit.setText("Submit");
        btSubmit.setFont(font);
        conn.add(btSubmit);
    }

    private void addButtons(int nofButton) {
        flayout.setHgap(15);
        flayout.setVgap(10);

        pnButtons = new JPanel();
        pnButtons.setLayout(flayout);
        //factory pattent

        Border insideBorder = BorderFactory.createEtchedBorder(Color.red, Color.GREEN);
        Border outsideBorder = BorderFactory.createEmptyBorder(30, 0, 0, 0);
        System.out.println("class " + outsideBorder.getClass());
        Border border = BorderFactory.createCompoundBorder(outsideBorder, insideBorder);
        pnButtons.setBorder(border);
        for (int i = 1; i <= nofButton; i++) {
            JButton button = new JButton();
            button.setFont(font);
            button.setFocusPainted(false);
            button.setText(i == 4 ? "Long name Button " + i : "Button " + i);
            pnButtons.add(button);

        }
        conn.add(pnButtons);
    }

    private void initEvent() {

    }

    public static void main(String[] args) {
        Ex01Flow that = new Ex01Flow();
        that.setVisible(true);
    }

}
