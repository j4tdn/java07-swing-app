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
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.util.List;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import static javax.swing.JSplitPane.*;
import view.sub.pnEmployee;
import view.sub.pnHomePage;

/**
 *
 * @author DangHoang
 */
@SuppressWarnings("serial")
public class Ex04CardLayout extends JFrame {

    private JPanel pnTop;
    private JPanel pnLeftTop;
    private JPanel pnLeftBottom;
    private JPanel pnCenter;
    private JSplitPane splitPane;
    private JSplitPane splitPanePnLeft;
    private final Font font = new Font("Tahoma", Font.BOLD, 20);
    private final Container conn = getContentPane();
    private final BorderLayout borderlayout = new BorderLayout();
    private final GridLayout gridlayout=new GridLayout(4, 0);
    private final CardLayout cardLayout=new CardLayout();

    public Ex04CardLayout() {
//    UI
        initComponents();
//    Events
        initEvens();
    }

    public static void main(String[] args) {
        Ex04CardLayout that = new Ex04CardLayout();
        that.setVisible(true);
    }

    private void initComponents() {
        setSize(870, 700);

        setLocationRelativeTo(null);
        Image image = new ImageIcon(getClass().getResource("/images/64px_flower.png")).getImage();
        setIconImage(image);

        setTitle("Java-BorderLayout");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        conn.setLayout(borderlayout);
        addPanels();

    }

    private void addPanels() {

        pnTop = new JPanel();
        pnTop.setPreferredSize(new Dimension(0, 100));
        pnTop.setBackground(Color.GREEN);
        conn.add(pnTop, BorderLayout.NORTH);

        pnLeftTop = new JPanel();
        pnLeftTop.setPreferredSize(new Dimension(180, 300));
        pnLeftTop.setBackground(Color.BLACK);
        pnLeftTop.setLayout(gridlayout);
        
        List<String> buttons =Arrays.asList("Home Page","Employee");
        for(String btText:buttons){
            JButton button=new JButton();
            button.setText(btText);
            pnLeftTop.add(button);
        
        }

        pnLeftBottom = new JPanel();
        pnLeftBottom.setPreferredSize(new Dimension(180, 0));
        pnLeftBottom.setBackground(Color.YELLOW);

        splitPanePnLeft = new JSplitPane();
        splitPanePnLeft.setOneTouchExpandable(true);
        splitPanePnLeft.setOrientation(VERTICAL_SPLIT);
        splitPanePnLeft.add(pnLeftTop, TOP);
        splitPanePnLeft.add(pnLeftBottom, BOTTOM);

        pnCenter = new JPanel();
        pnCenter.setBackground(Color.PINK);
        pnCenter.setLayout(cardLayout);
        
        pnCenter.add(new pnHomePage(),"HOMEPAGE");
        pnCenter.add(new pnEmployee(),"EMPLOYEE");
        cardLayout.show(pnCenter, "EMPLOYEE");

        splitPane = new JSplitPane();
        splitPane.setOneTouchExpandable(true);
        splitPane.setOrientation(HORIZONTAL_SPLIT);
        splitPane.add(splitPanePnLeft, LEFT);
        splitPane.add(pnCenter, RIGHT);
        
        conn.add(splitPane,CENTER);
    }

    private void initEvens() {
    }

}
