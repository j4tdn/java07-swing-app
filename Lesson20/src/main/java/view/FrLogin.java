/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author khanh
 */
public class FrLogin extends javax.swing.JFrame {

    /**
     * Creates new form Ex05Absolute
     */
    public FrLogin() {
        setUndecorated(true);
        
        initComponents();
        
        initComponentsManaully();
        initEvents();
    }
    
    private void initComponentsManaully() {
        tfUserName.requestFocus();
        setLocationRelativeTo(null);
        btClose.setBackground(new Color(0, 0, 0, 0));
        btnLogin.setBackground(new Color(0, 0, 0, 0));
    }
    
    private void initEvents() {
        btnCloseEvents();
        btnLoginEvents();
    }
    
    private void btnLoginEvents() {
        btnLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String username = tfUserName.getText();
                String password = String.valueOf(pfPassWord.getPassword());
                boolean isValid = isValidAccount(username, password);
                if (isValid) {
                    FrLogin.this.setVisible(false);
                    FrMain frMain = new FrMain();
                    frMain.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "login fail !!!");
                }
            }
            
        });
    }
    
    private boolean isValidAccount(String username, String password) {        
        return username.equals("admin") && password.equals("123456");
    }
    
    private void btnCloseEvents() {
        btClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Icon icon = new ImageIcon(getClass().getResource("/images/64px_flower.png"));
                final int comfirm = JOptionPane.showConfirmDialog(null, "DO you want to close ?", "From System", JOptionPane.YES_NO_OPTION, 0, icon);
                
                if (comfirm == JOptionPane.YES_OPTION) {
                    FrLogin.this.setVisible(false);
                }
                //
                
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
        pfPassWord = new javax.swing.JPasswordField();
        btClose = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        lbLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfUserName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfUserName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUserNameActionPerformed(evt);
            }
        });
        getContentPane().add(tfUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 208, 250, 30));

        pfPassWord.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pfPassWord.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(pfPassWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 278, 247, 30));

        btClose.setBackground(new java.awt.Color(0, 240, 240));
        btClose.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(553, 78, 45, 44));
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 378, 252, 32));

        lbLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N
        getContentPane().add(lbLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 0, 850, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUserNameActionPerformed

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
                if ("windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClose;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JPasswordField pfPassWord;
    private javax.swing.JTextField tfUserName;
    // End of variables declaration//GEN-END:variables
}
