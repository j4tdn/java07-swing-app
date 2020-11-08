package view;
import java.awt.Container;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class vd extends JFrame
{
  Container contentPane = getContentPane();
            JPanel jp = new JPanel();
       JLabel jl = new JLabel();

       public vd()
       {
              setTitle("Tutorial");
              setVisible(true);
              setSize(400, 200);
              setDefaultCloseOperation(EXIT_ON_CLOSE);

              jl.setIcon(new ImageIcon("/images/48px_like.png"));
              
              jl.setBounds(10, 10, 200, 200);
              add(jl);
                                                            // /images/48px_like.png
              add(jp);

              validate();
       }

       public static void main(String[] args)
       {
             vd t = new vd();
       }
}