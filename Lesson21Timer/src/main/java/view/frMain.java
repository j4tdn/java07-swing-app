/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import sevice.buttonView;

/**
 *
 * @author Asus
 */
public class frMain extends javax.swing.JFrame implements Runnable{

    private final JButton[] btViews = new JButton[6];
   
    private final buttonView btview;
    private final Font font = new Font("Tahoma", Font.PLAIN, 40);
    private JButton btNhan;
    private final Icon Gif = new ImageIcon(getClass().getResource("/images/dog.gif"));
    private final Icon Png = new ImageIcon(getClass().getResource("/images/dog.png"));
    private final Icon clap = new ImageIcon(getClass().getResource("/images/claps04.gif"));
    private final Icon pause = new ImageIcon(getClass().getResource("/images/pause.png"));
    private final Icon resume = new ImageIcon(getClass().getResource("/images/resume.png"));
    private boolean btStatus = true;
    private static Thread thread;
    private int second = 15;
    private int openAll ;
    private int count =0;

    /**
     * Creates new form frMain
     */
    public frMain() {
        btview = new buttonView();
        initComponents();
        initComponent();
        initEvents();
    }

    private void initComponent() {
        
        setSize(1080, 600);
        
        btResume.setIcon(pause);
        btResume.setBackground(new Color(0,0,0,0));
        btResume.setVisible(false);
        

        for (int i = 0; i < 6; i++) {
            btViews[i] = new JButton();
            btViews[i].setPreferredSize(new Dimension(60, 60));
            btViews[i].setFont(font);
        }
    }

    private void initEvents() {
        
        btViews[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                
                
                btview.getButtonview(0);
            }
            
        });
        btViews[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(--count==0){
                    lbGif.setIcon(clap);
                }
                btview.getButtonview(1);
            }
            
        });
        btViews[2].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(--count==0){
                    lbGif.setIcon(clap);
                }
                btview.getButtonview(2);
            }
            
        });
        btViews[3].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(--count==0){
                    lbGif.setIcon(clap);
                }
                btview.getButtonview(3);
            }
            
        });
        btViews[4].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(--count==0){
                    lbGif.setIcon(clap);
                }
                btview.getButtonview(4);
            }
            
        });
        btViews[5].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(--count==0){
                    lbGif.setIcon(clap);
                }
                
                btview.getButtonview(5);
            }
            
        });
        btQstar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                btNhan=btQstar;
                lbGif.setIcon(Png);
                lbQuestiom.setText("What is superpower make SO better ?");
                btview.getButton(btViews, "SLEEP", pnView);
                count=5;

            }

        });
        btQrect.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                btNhan=btQrect;
                lbGif.setIcon(Png);
                lbQuestiom.setText("What is the best thing in your life ?");
                btview.getButton(btViews, "HEALTH", pnView);
                count=6;

            }

        });
        btQtriangle.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                btNhan=btQtriangle;
                lbGif.setIcon(Png);
                lbQuestiom.setText("Why did SO leave their last job ?");
                btview.getButton(btViews, "SALARY", pnView);
                count=6;

            }

        });
        btQcicle.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                btNhan=btQcicle;
                lbGif.setIcon(Png);
                lbQuestiom.setText("What can travel around the world while staying in a corner ?");
                btview.getButton(btViews, "STAMP", pnView);
                count=5;

            }

        });
        btQspeciel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                btNhan = btQspeciel;
                lbGif.setIcon(Png);
                lbQuestiom.setText("I'm tall when I'm young and I'm short when I'm old. What am I ?");
                btview.getButton(btViews, "CANDEL", pnView);
                count=6;

            }

        });
        btStart.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(btNhan!= null){
                    
                    lbGif.setIcon(Gif);
                    btResume.setVisible(true);
                    second =15;
                    thread.resume();
                                        
                    
                    
                }
            }
            
        });
        btOpen.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                btview.openAnswer();
                lbGif.setIcon(clap);
                thread.suspend();
                
                
            }
            
        });
        btDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                btview.deleteAnswer();
                lbGif.setIcon(Png);
            }
            
        });
        btResume.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                
                if(btStatus){
                    
                    btStatus=false;
                    thread.suspend();
                    btResume.setIcon(resume);
                    
                }
                else{
                    
                    btResume.setIcon(pause);
                    thread.resume();
                    btStatus= true;
                    
                    
                }
                
                
                
            }
            
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel10 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btQstar = new javax.swing.JButton();
        btQrect = new javax.swing.JButton();
        btQtriangle = new javax.swing.JButton();
        btQcicle = new javax.swing.JButton();
        btQspeciel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        pnClock = new javax.swing.JPanel();
        lbsecond = new javax.swing.JLabel();
        lbClock = new javax.swing.JLabel();
        btResume = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        pnAnswer = new javax.swing.JPanel();
        lbQuestiom = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lbGif = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btStart = new javax.swing.JButton();
        btOpen = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        pnView = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));

        btQstar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/qstar.png"))); // NOI18N
        btQstar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btQstar.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(btQstar);

        btQrect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/qrect.png"))); // NOI18N
        btQrect.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btQrect.setPreferredSize(new java.awt.Dimension(50, 50));
        btQrect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btQrectActionPerformed(evt);
            }
        });
        jPanel1.add(btQrect);

        btQtriangle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/qtriangle.png"))); // NOI18N
        btQtriangle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btQtriangle.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(btQtriangle);

        btQcicle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/qcircle.png"))); // NOI18N
        btQcicle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btQcicle.setFocusPainted(false);
        btQcicle.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(btQcicle);

        btQspeciel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/qspecial.png"))); // NOI18N
        btQspeciel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btQspeciel.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(btQspeciel);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel6.setLayout(new java.awt.BorderLayout());

        pnClock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnClock.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbsecond.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        pnClock.add(lbsecond, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 65, -1, -1));

        lbClock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clock.png"))); // NOI18N
        pnClock.add(lbClock, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));
        pnClock.add(btResume, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, -1, -1));

        jPanel6.add(pnClock, java.awt.BorderLayout.LINE_END);

        jPanel4.setLayout(new java.awt.BorderLayout());

        pnAnswer.setBackground(new java.awt.Color(153, 153, 153));
        pnAnswer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnAnswer.setPreferredSize(new java.awt.Dimension(12, 60));
        pnAnswer.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        lbQuestiom.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pnAnswer.add(lbQuestiom);

        jPanel4.add(pnAnswer, java.awt.BorderLayout.PAGE_START);

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbGif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dog.png"))); // NOI18N
        jPanel9.add(lbGif);

        jPanel4.add(jPanel9, java.awt.BorderLayout.CENTER);

        jPanel6.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel6, java.awt.BorderLayout.PAGE_START);

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 20));

        btStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/defcon.png"))); // NOI18N
        btStart.setText("Bắt Đầu");
        btStart.setFocusPainted(false);
        btStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btStartActionPerformed(evt);
            }
        });
        jPanel7.add(btStart);

        btOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/defcon.png"))); // NOI18N
        btOpen.setText("Mở Ô Chữ");
        btOpen.setFocusPainted(false);
        jPanel7.add(btOpen);

        btDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/defcon.png"))); // NOI18N
        btDelete.setText("Xóa Ô Chữ");
        btDelete.setFocusPainted(false);
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });
        jPanel7.add(btDelete);

        jPanel2.add(jPanel7, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        pnView.setBackground(new java.awt.Color(0, 255, 51));
        pnView.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnView.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 30));
        getContentPane().add(pnView, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Tài Nguyên");

        jMenuItem1.setText("Gia Đình");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator2);

        jMenuItem2.setText("Sức Khỏe");
        jMenu1.add(jMenuItem2);
        jMenu1.add(jSeparator3);

        jMenuItem3.setText("Cuộc Sống");
        jMenu1.add(jMenuItem3);
        jMenu1.add(jSeparator1);

        jMenuItem4.setText("Khoa Học");
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Tác Giả");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btQrectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btQrectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btQrectActionPerformed

    private void btStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btStartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btStartActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btDeleteActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
           frMain  mainview =  new frMain();
           mainview.setVisible(true);
        thread = new Thread(mainview);
         thread.start();
         thread.suspend();
       
           
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btOpen;
    private javax.swing.JButton btQcicle;
    private javax.swing.JButton btQrect;
    private javax.swing.JButton btQspeciel;
    private javax.swing.JButton btQstar;
    private javax.swing.JButton btQtriangle;
    private javax.swing.JButton btResume;
    private javax.swing.JButton btStart;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JLabel lbClock;
    private javax.swing.JLabel lbGif;
    private javax.swing.JLabel lbQuestiom;
    private javax.swing.JLabel lbsecond;
    private javax.swing.JPanel pnAnswer;
    private javax.swing.JPanel pnClock;
    private javax.swing.JPanel pnView;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        while (true) {            
            if(second>=0){
                lbsecond.setText(String.valueOf(second--));
            
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            }
            else{
                
                btResume.setVisible(false);
                pnClock.revalidate();
                pnClock.repaint();
                thread.suspend();
                
                
            }
            
        }
    }
}
