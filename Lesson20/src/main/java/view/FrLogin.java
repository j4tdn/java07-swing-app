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
 * @author DangHoang
 */
public class FrLogin extends javax.swing.JFrame {

    /**
     * Creates new form Ex05Absolute
     */
    public FrLogin() {
        setUndecorated(true);
        initComponents();
        initCommponentsManually();
        initEvents();
        btLoginEvents();
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
        tfPassWord = new javax.swing.JPasswordField();
        btClose = new javax.swing.JButton();
        btLogin = new javax.swing.JButton();
        lbLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfUserName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfUserName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUserNameActionPerformed(evt);
            }
        });
        getContentPane().add(tfUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 207, 250, 33));
        tfUserName.getAccessibleContext().setAccessibleName("");
        tfUserName.getAccessibleContext().setAccessibleDescription("");

        tfPassWord.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tfPassWord.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(tfPassWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 277, 250, 33));
        tfPassWord.getAccessibleContext().setAccessibleName("");

        btClose.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btClose.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btClose.setContentAreaFilled(false);
        btClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, 40, 40));
        btClose.getAccessibleContext().setAccessibleDescription("");

        btLogin.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btLogin.setContentAreaFilled(false);
        btLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, 240, 30));

        lbLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/convenient-login-form.jpg"))); // NOI18N
        getContentPane().add(lbLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, -1));

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
                if ("Windows".equals(info.getName())) {
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClose;
    private javax.swing.JButton btLogin;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JPasswordField tfPassWord;
    private javax.swing.JTextField tfUserName;
    // End of variables declaration//GEN-END:variables

    private void initCommponentsManually() {
        setLocationRelativeTo(null);
        btClose.setBackground(new Color(0, 0, 0, 0));

        btLogin.setBackground(new Color(0, 0, 0, 0));
    }

    private void initEvents() {
        btClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
//                Icon image = new ImageIcon(getClass().getResource("/images/48.jpg"));
                final int option = JOptionPane.showConfirmDialog(null, "Do u want to close ?", "From System", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (option == JOptionPane.YES_OPTION) {
                    FrLogin.this.setVisible(false);
                }
            }
        });
    }

    private void btLoginEvents() {

        btLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String username = tfUserName.getName();
                String password = String.valueOf(tfPassWord.getPassword());
                boolean isVaild = isValidAccount(username, password);
                if(isVaild){
                    FrLogin.this.setVisible(false);
                    FrMain frmain=new FrMain();
                    frmain.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Login fail");
                }
            }

        });
    }
    
    private boolean isValidAccount(String username,String password){
    return username.equals("admin")&password.equals("1234");
    }
}
