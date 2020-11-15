package Layout;

import java.awt.Color;
import static java.awt.ComponentOrientation.*;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javafx.scene.layout.Border;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

/**
 *
 * @author DangHoang
 */
@SuppressWarnings("serial")
public class Ex01Flow extends JFrame {

    private final Font font = new Font("Tahoma", Font.BOLD, 20);
    private final FlowLayout flowlayout = new FlowLayout();
    private JRadioButton rdLtoR;
    private JRadioButton rdRtoL;
    private JButton btSubmit;
    private JPanel pnButtons;
    private ButtonGroup btgroup = new ButtonGroup();

    private final Container conn = getContentPane();

    public Ex01Flow() {
//    UI
        initComponents();
//    Events
        initEvens();
    }

    public static void main(String[] args) {
        Ex01Flow that = new Ex01Flow();
        that.setVisible(true);
    }

    private void initComponents() {
        setSize(870, 400);

        setLocationRelativeTo(null);
        Image image = new ImageIcon(getClass().getResource("/images/64px_flower.png")).getImage();
        setIconImage(image);

        setTitle("Java-App");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        conn.setLayout(flowlayout);

        addButtons(5);
        addForm();
    }

    private void addButtons(int noffButton) {
        flowlayout.setHgap(15);
        flowlayout.setVgap(10);
        pnButtons = new JPanel();
        pnButtons.setLayout(flowlayout);

        javax.swing.border.Border insideBorder = BorderFactory.createEtchedBorder(Color.magenta, Color.red);
        javax.swing.border.Border outsideBorder = BorderFactory.createEmptyBorder(30, 0, 0, 0);
        System.out.println(outsideBorder.getClass());
        javax.swing.border.Border border = BorderFactory.createCompoundBorder(outsideBorder, insideBorder);
        pnButtons.setBorder(border);
        for (int i = 1; i <= 5; i++) {
            JButton button = new JButton();
            button.setFont(font);
            button.setFocusPainted(false);
            if (i == 4) {
                button.setText("long-named Button " + i);
            } else {
                button.setText("Button " + i);
            }
            pnButtons.add(button);
        }
        conn.add(pnButtons);
    }

    private void initEvens() {
        btSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                pnButtons.applyComponentOrientation(rdLtoR.isSelected() ? LEFT_TO_RIGHT : RIGHT_TO_LEFT);
                pnButtons.revalidate();
            }

        });
    }

    private void addForm() {
        rdLtoR = new JRadioButton();
        rdLtoR.setText("Left to Right");
        rdLtoR.setFont(font);
        rdLtoR.setFocusPainted(false);
        rdLtoR.setSelected(true);
        conn.add(rdLtoR);

        rdRtoL = new JRadioButton();
        rdRtoL.setText("Right to Left");
        rdRtoL.setFont(font);
        conn.add(rdRtoL);

        btgroup.add(rdLtoR);
        btgroup.add(rdRtoL);

        btSubmit = new JButton();
        btSubmit.setText("submit");
        btSubmit.setFont(font);
        conn.add(btSubmit);

    }
}
