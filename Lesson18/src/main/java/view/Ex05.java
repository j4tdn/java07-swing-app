/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Period;
import java.util.Date;
import javax.swing.ImageIcon;
import service.TimeService;
import service.TimeServiceImpl;

/**
 *
 * @author OS
 */
public class Ex05 extends javax.swing.JFrame {

    Container conn = getContentPane();
    private final TimeService timeService;
    
    public Ex05() {
        timeService = new TimeServiceImpl();
        initComponents();
        initComponentsManually();
        initEvents();
    }
    
    private void initComponentsManually() {
        setResizable(false);
        setLocationRelativeTo(null);
        Image image = new ImageIcon(getClass().getResource("/images/48px_love.png")).getImage();
        setIconImage(image);
        conn.setBackground(Color.BLACK);
        dcFinish.setDate(new Date());
    }

    private void initEvents() {
        btLoveEvents();
    }
    
    private void btLoveEvents() {
        btLove.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                final String firstName = tfFirstPersion.getText();
                final String secondName = tSecondPersion.getText();
                final Date start = dcStart.getDate();
                final Date finish = dcFinish.getDate();
                Period period = timeService.getPeriod(start, finish);
                lbResult2.setText("Kết quả: "
                                + firstName 
                                + " & " 
                                + secondName 
                                + " đã quen nhau "
                                + period.getYears() + " năm "
                                + period.getMonths() + " tháng"
                                + period.getDays() + " ngày");
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

        lbTitle = new javax.swing.JLabel();
        tfFirstPersion = new javax.swing.JTextField();
        lbError1 = new javax.swing.JLabel();
        btLike = new javax.swing.JButton();
        lbSecondPerson1 = new javax.swing.JLabel();
        tSecondPersion = new javax.swing.JTextField();
        lbError2 = new javax.swing.JLabel();
        btLove = new javax.swing.JButton();
        lbStart = new javax.swing.JLabel();
        dcStart = new com.toedter.calendar.JDateChooser();
        lbFinish = new javax.swing.JLabel();
        dcFinish = new com.toedter.calendar.JDateChooser();
        lbResult = new javax.swing.JLabel();
        lbResult2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Love time - application");

        lbTitle.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(204, 0, 204));
        lbTitle.setText("Love Time Application");

        tfFirstPersion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfFirstPersion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFirstPersionActionPerformed(evt);
            }
        });

        lbError1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbError1.setForeground(new java.awt.Color(255, 51, 51));
        lbError1.setText("Chưa nhập tên");

        btLike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/48px_like.png"))); // NOI18N

        lbSecondPerson1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbSecondPerson1.setForeground(new java.awt.Color(255, 255, 255));
        lbSecondPerson1.setText("-Người thứ hai-");

        tSecondPersion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tSecondPersion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tSecondPersionActionPerformed(evt);
            }
        });

        lbError2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbError2.setForeground(new java.awt.Color(255, 51, 51));
        lbError2.setText("Chưa nhập tên");

        btLove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/48px_love.png"))); // NOI18N
        btLove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoveActionPerformed(evt);
            }
        });

        lbStart.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbStart.setForeground(new java.awt.Color(255, 255, 255));
        lbStart.setText("Ngày bắt đầu");

        lbFinish.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbFinish.setForeground(new java.awt.Color(255, 255, 255));
        lbFinish.setText("Ngày bắt đầu");

        lbResult.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbResult.setForeground(new java.awt.Color(255, 255, 255));
        lbResult.setText("-Người thứ nhất-");

        lbResult2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbResult2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbError1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(btLike, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(tfFirstPersion, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbFinish, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dcStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dcFinish, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(lbStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(tSecondPersion, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbError2)
                                .addGap(115, 115, 115))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btLove, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(133, 133, 133))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(lbSecondPerson1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTitle)
                .addGap(122, 122, 122))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lbResult2, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(69, 69, 69)
                    .addComponent(lbResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(548, 548, 548)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitle)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbStart)
                    .addComponent(lbSecondPerson1))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER, false)
                    .addComponent(tfFirstPersion, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(dcStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tSecondPersion))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbError1)
                    .addComponent(lbError2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lbFinish)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btLike, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dcFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btLove, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(lbResult2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(124, 124, 124)
                    .addComponent(lbResult)
                    .addContainerGap(304, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfFirstPersionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFirstPersionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFirstPersionActionPerformed

    private void tSecondPersionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tSecondPersionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tSecondPersionActionPerformed

    private void btLoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btLoveActionPerformed

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
            java.util.logging.Logger.getLogger(Ex05.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ex05.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ex05.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ex05.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ex05().setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLike;
    private javax.swing.JButton btLove;
    private com.toedter.calendar.JDateChooser dcFinish;
    private com.toedter.calendar.JDateChooser dcStart;
    private javax.swing.JLabel lbError1;
    private javax.swing.JLabel lbError2;
    private javax.swing.JLabel lbFinish;
    private javax.swing.JLabel lbResult;
    private javax.swing.JLabel lbResult2;
    private javax.swing.JLabel lbSecondPerson1;
    private javax.swing.JLabel lbStart;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JTextField tSecondPersion;
    private javax.swing.JTextField tfFirstPersion;
    // End of variables declaration//GEN-END:variables

    
}
