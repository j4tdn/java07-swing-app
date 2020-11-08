/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Period;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import service.TimeService;
import service.TimeServiceImpl;

/**
 *
 * @author Asus
 */
public class Ex05 extends javax.swing.JFrame {
    Container conn = getContentPane();
    private final  TimeService timeService;

    /**
     * Creates new form Ex05
     */
    public Ex05() {
        timeService = new TimeServiceImpl();
        initComponents();
        initComponentsManually();
        initEvent();
    }
    private void initComponentsManually(){
        setResizable(false);
        setLocationRelativeTo(null);
        Image img = new ImageIcon(getClass().getResource("/images/48px_love.png")).getImage();
        setIconImage(img);
        
        
        
        conn.setBackground(Color.BLACK);
        
        
        dcEnd.setDate(new Date());
        
    }
    private void initEvent(){
        btLoveEvent();
        
        
    }
    private void btLoveEvent(){
        btLove.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                final String firstName = tfFirstPersion.getText();
                final String secondName= tfSecondPersion.getText();
                final Date start= dcStart.getDate();
                final Date end = dcEnd.getDate();
                
                Period period = timeService.getPeriod(start, end);
                
                lbresult.setText("Kết Quả :"
                        +firstName
                        + "&"
                        + secondName
                        +"Đã Quen Nhau"
                        +period.getYears()+"Năm"
                        +period.getMonths()+"Tháng"
                        +period.getDays()+"Ngày");
                
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
        lbStart = new javax.swing.JLabel();
        tfFirstPersion = new javax.swing.JTextField();
        lbFirstError = new javax.swing.JLabel();
        btLike = new javax.swing.JButton();
        lbSecondPersion = new javax.swing.JLabel();
        tfSecondPersion = new javax.swing.JTextField();
        lbSecondError = new javax.swing.JLabel();
        btLove = new javax.swing.JButton();
        lbTimePersion = new javax.swing.JLabel();
        dcStart = new com.toedter.calendar.JDateChooser();
        dcEnd = new com.toedter.calendar.JDateChooser();
        lbEnd = new javax.swing.JLabel();
        lbresult = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Love - Time Application");
        setAutoRequestFocus(false);

        lbTitle.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(255, 0, 153));
        lbTitle.setText("LOVE TIME APPLICATION");

        lbStart.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbStart.setForeground(new java.awt.Color(204, 204, 255));
        lbStart.setText("Ngày Bắt Đầu");

        tfFirstPersion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfFirstPersion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFirstPersionActionPerformed(evt);
            }
        });

        lbFirstError.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbFirstError.setForeground(new java.awt.Color(255, 0, 0));
        lbFirstError.setText("Chưa Nhập Tên");

        btLike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/love.png"))); // NOI18N

        lbSecondPersion.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbSecondPersion.setForeground(new java.awt.Color(204, 204, 255));
        lbSecondPersion.setText("-Người Thứ Hai-");

        tfSecondPersion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfSecondPersion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSecondPersionActionPerformed(evt);
            }
        });

        lbSecondError.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbSecondError.setForeground(new java.awt.Color(255, 0, 0));
        lbSecondError.setText("Chưa Nhập Tên");

        btLove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Love_Candy.png"))); // NOI18N

        lbTimePersion.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbTimePersion.setForeground(new java.awt.Color(204, 204, 255));
        lbTimePersion.setText("-Người Thứ Nhất -");

        dcStart.setDateFormatString("dd/MMM/yyy");
        dcStart.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        dcEnd.setDateFormatString("dd/MMM/yyy");
        dcEnd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbEnd.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbEnd.setForeground(new java.awt.Color(204, 204, 255));
        lbEnd.setText("Ngày Hiện Tại");

        lbresult.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbresult.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tfFirstPersion, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbFirstError)
                    .addComponent(btLike, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dcEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dcStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfSecondPersion, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(lbSecondError))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(btLove, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbSecondPersion)
                        .addGap(42, 42, 42)))
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTitle)
                .addGap(188, 188, 188))
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(lbresult, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(67, 67, 67)
                    .addComponent(lbTimePersion)
                    .addContainerGap(591, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbStart)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dcStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(164, 164, 164))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfFirstPersion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(107, 107, 107)
                                .addComponent(btLike))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbSecondPersion)
                        .addGap(30, 30, 30)
                        .addComponent(tfSecondPersion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(lbEnd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dcEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbSecondError)
                                    .addComponent(lbFirstError))
                                .addGap(60, 60, 60)
                                .addComponent(btLove)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(lbresult, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(92, 92, 92)
                    .addComponent(lbTimePersion)
                    .addContainerGap(348, Short.MAX_VALUE)))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {dcEnd, dcStart, tfFirstPersion, tfSecondPersion});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfFirstPersionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFirstPersionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFirstPersionActionPerformed

    private void tfSecondPersionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSecondPersionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSecondPersionActionPerformed

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
    private com.toedter.calendar.JDateChooser dcEnd;
    private com.toedter.calendar.JDateChooser dcStart;
    private javax.swing.JLabel lbEnd;
    private javax.swing.JLabel lbFirstError;
    private javax.swing.JLabel lbSecondError;
    private javax.swing.JLabel lbSecondPersion;
    private javax.swing.JLabel lbStart;
    private javax.swing.JLabel lbTimePersion;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbresult;
    private javax.swing.JTextField tfFirstPersion;
    private javax.swing.JTextField tfSecondPersion;
    // End of variables declaration//GEN-END:variables
}
