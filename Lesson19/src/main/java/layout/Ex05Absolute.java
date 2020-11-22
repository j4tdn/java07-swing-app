/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

/**
 *
 * @author ADMIN
 */
public class Ex05Absolute extends javax.swing.JFrame {

    /**
     * Creates new form Ex05Absolute
     */
    public Ex05Absolute() {
        setUndercorated(true);
        initComponents();
        
        initComponentMunually();
        
        initEvents();
        
    }
    private void initComponentMunually(){
        btClose.getBaclGround(new Color(0,0,0,0));
    }
    private void initEvents(){
    btClose.addMouseListener(new MouseAdapter(){
         @Override
                    public void mousePressed(MouseEvent e) {
                        
                      //  IconImage icon=new ImageIcon(getClass().getResource("/images/48px_pause.png"));
                        
                        final int option=JOptionPane.showConfirmDialog(
                                null,
                                "Do you want to close",
                                "",
                                "==Form close=="
                                JOptionPane.YES_NO_OPTION,//c
                                JOptionPane.INFORMATION_MESSAGE
                              //  icon                                
                                )
                        if(JOptionPane.showConfirmDialog(null,"Do you want to close")==1){
                            Ex05Absolute.this.setVisible(false);
                         
                     } 
                     //
                     System.out.println("===Notthing");
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

        tfUserName = new javax.swing.JTextField();
        tfPassword = new javax.swing.JPasswordField();
        btClose = new javax.swing.JButton();
        lblogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfUserName.setText("Le Van Teo");
        tfUserName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUserNameActionPerformed(evt);
            }
        });
        getContentPane().add(tfUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 201, 245, 30));

        tfPassword.setText("password");
        tfPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(tfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 268, 255, 40));

        btClose.setBackground(new java.awt.Color(255, 0, 0));
        btClose.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 50, 50));

        lblogin.setBackground(new java.awt.Color(204, 255, 0));
        lblogin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N
        lblogin.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        lblogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblogin.setEnabled(false);
        lblogin.setFocusCycleRoot(true);
        lblogin.setPreferredSize(new java.awt.Dimension(500, 400));
        getContentPane().add(lblogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUserNameActionPerformed

    private void btCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCloseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btCloseActionPerformed

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
            java.util.logging.Logger.getLogger(Ex05Absolute.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ex05Absolute.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ex05Absolute.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ex05Absolute.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ex05Absolute().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClose;
    private javax.swing.JLabel lblogin;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfUserName;
    // End of variables declaration//GEN-END:variables
}
