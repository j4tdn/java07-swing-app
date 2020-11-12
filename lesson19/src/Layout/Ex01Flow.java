/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layout;


import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
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
 * @author Admin
 */
public class Ex01Flow extends JFrame{
    private final Container conn =  this.getContentPane() ;
    private JPanel pnButton;
    private JRadioButton rdLtoR;
    private JRadioButton rdRtoL;
    private JButton btSubmit; 
    
    private ButtonGroup orientionGroup = new ButtonGroup();
    private Font font =  new Font("Tahoma", Font.BOLD, 15);
    private final FlowLayout flayout = new FlowLayout();
    
    
    
    public Ex01Flow() {
        //ui
        initComponents();
        //event
        initEvents();
        
        addform();
    }
//    private static final String Project_Path = new File("").getAbsolutePath();
    private static final String Image_Path = "D:\\Java\\Workspace\\local_Git\\java07-repository-app\\lesson19\\src\\images";// set đường dẫn
    
    
    private void initComponents(){
        this.setTitle("FlowLayout");
         
        this.setSize(870, 300); ///set siz
        this.setLocationRelativeTo(null);
      
        Image image = new ImageIcon(Image_Path + File.separator +"48px_like.png").getImage(); // set hình ảnh cho iconImage
        this.setIconImage(image);
       
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // bắt event khi tắt chương trình cho khỏi chạy ngầm
        
        conn.setLayout(flayout);
        
        
        addBotton(5);
       
    }
    private void addform(){
        
        rdLtoR = new JRadioButton();
        rdLtoR.setText("Left To Right");
        rdLtoR.setFont(font);
         rdLtoR.setFocusPainted(false);
        conn.add(rdLtoR);
        orientionGroup.add(rdLtoR);
        rdRtoL = new JRadioButton();
        rdRtoL.setText(" Right To Left");
        rdRtoL.setFont(font);
        rdRtoL.setFocusPainted(false);
        conn.add(rdRtoL);
        
        orientionGroup.add(rdRtoL);
        btSubmit = new JButton();
        btSubmit.setText("Submit");
        btSubmit.setFont(font);
        btSubmit.setFocusPainted(false);
        conn.add(btSubmit);
        
    }
    
    private void addBotton(int nOfButton){
        flayout.setHgap(20);
        flayout.setVgap(20);
        pnButton = new JPanel();
        pnButton.setLayout(flayout);
        //factory botton
        Border insideBorder = BorderFactory.createEtchedBorder(Color.RED, Color.GREEN);
        Border outsideBorder = BorderFactory.createEmptyBorder(30,0,0,0);
        Border outBorder = BorderFactory.createCompoundBorder(outsideBorder, insideBorder);
       
        pnButton.setBorder(insideBorder);
        for( int i = 1 ;i <= nOfButton; i++){
            JButton button = new JButton();
            button.setFocusPainted(false);
            button.setFont(font);
            button.setText(i==4?"Long-Named Button"+ i:"Button " + i);
            pnButton.add(button);
        }
        conn.add(pnButton);
    }
    private void initEvents(){
        
    }
    
    public static void main(String[] args) {
        Ex01Flow that = new Ex01Flow();
        that.setVisible(true);
    }
}
