/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub;

import bean.model.Grade;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author khanh
 */
public class pnStudent extends javax.swing.JPanel {

    /**
     * Creates new form pnStudent
     */
    public pnStudent() {
        initComponents();
        initDataModel();
    }
    
    private void initDataModel(){
        initCbbGradeModel();
    }
    private void initCbbGradeModel(){
        Grade[] grades = {
            new Grade(1, "Lớp 1"),
            new Grade(2, "Lớp 2"),
            new Grade(3, "Lớp 3")
        };
        ComboBoxModel<Grade> gradeModel = new DefaultComboBoxModel<>(grades);
        cbbGrade.setModel(gradeModel);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMainTop = new javax.swing.JPanel();
        lbStudentInfo = new javax.swing.JLabel();
        pnMainBottom = new javax.swing.JPanel();
        btnSubmit = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        pnMainCenter = new javax.swing.JPanel();
        spDetailInfo = new javax.swing.JSplitPane();
        pnDetailLeft = new javax.swing.JPanel();
        lbName = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        lbGrade = new javax.swing.JLabel();
        cbbGrade = new javax.swing.JComboBox();
        lbGender = new javax.swing.JLabel();
        lbHobbies = new javax.swing.JLabel();
        rdMale = new javax.swing.JRadioButton();
        rdFemale = new javax.swing.JRadioButton();
        rdMiddle = new javax.swing.JRadioButton();
        cbFootball = new javax.swing.JCheckBox();
        cbvolleyball = new javax.swing.JCheckBox();
        cbcau = new javax.swing.JCheckBox();
        pnDetailRight = new javax.swing.JPanel();
        lbMath = new javax.swing.JLabel();
        tfMath = new javax.swing.JTextField();
        lbLiterature = new javax.swing.JLabel();
        tfLiterature = new javax.swing.JTextField();
        lbComment = new javax.swing.JLabel();
        scrollComment = new javax.swing.JScrollPane();
        taComment = new javax.swing.JTextArea();
        lbImage = new javax.swing.JLabel();
        lbAvatar = new javax.swing.JLabel();
        btnUpload = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        lbStudentInfo.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lbStudentInfo.setForeground(new java.awt.Color(0, 0, 102));
        lbStudentInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/student.png"))); // NOI18N
        lbStudentInfo.setText("THÔNG TIN HỌC VIÊN");
        lbStudentInfo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbStudentInfo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pnMainTop.add(lbStudentInfo);

        add(pnMainTop, java.awt.BorderLayout.PAGE_START);

        pnMainBottom.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 10));

        btnSubmit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        pnMainBottom.add(btnSubmit);

        btnReset.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        pnMainBottom.add(btnReset);

        add(pnMainBottom, java.awt.BorderLayout.PAGE_END);

        pnMainCenter.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thông tin chi tiết", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 13), new java.awt.Color(0, 0, 102))); // NOI18N
        pnMainCenter.setLayout(new java.awt.BorderLayout());

        pnDetailLeft.setBackground(new java.awt.Color(102, 255, 255));

        lbName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbName.setText("Họ tên:");

        tfName.setPreferredSize(new java.awt.Dimension(6, 32));
        tfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNameActionPerformed(evt);
            }
        });

        lbGrade.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbGrade.setText("Lớp:");

        lbGender.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbGender.setText("Giới tính:");

        lbHobbies.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbHobbies.setText("Sở thích:");

        rdMale.setText("Nam");
        rdMale.setContentAreaFilled(false);
        rdMale.setFocusPainted(false);
        rdMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdMaleActionPerformed(evt);
            }
        });

        rdFemale.setText("Nữ");
        rdFemale.setContentAreaFilled(false);
        rdFemale.setFocusPainted(false);
        rdFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdFemaleActionPerformed(evt);
            }
        });

        rdMiddle.setText("Khác");
        rdMiddle.setContentAreaFilled(false);
        rdMiddle.setFocusPainted(false);
        rdMiddle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdMiddleActionPerformed(evt);
            }
        });

        cbFootball.setText("Bóng đá");
        cbFootball.setContentAreaFilled(false);
        cbFootball.setFocusPainted(false);

        cbvolleyball.setText("Bóng chuyền");
        cbvolleyball.setContentAreaFilled(false);
        cbvolleyball.setFocusPainted(false);

        cbcau.setText("Cầu lông");
        cbcau.setContentAreaFilled(false);
        cbcau.setFocusPainted(false);
        cbcau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbcauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnDetailLeftLayout = new javax.swing.GroupLayout(pnDetailLeft);
        pnDetailLeft.setLayout(pnDetailLeftLayout);
        pnDetailLeftLayout.setHorizontalGroup(
            pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetailLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbName)
                    .addComponent(lbGrade)
                    .addComponent(lbGender)
                    .addComponent(lbHobbies))
                .addGap(18, 18, 18)
                .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDetailLeftLayout.createSequentialGroup()
                        .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdMale)
                            .addComponent(cbFootball))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdFemale)
                            .addComponent(cbvolleyball))
                        .addGap(18, 18, 18)
                        .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdMiddle)
                            .addComponent(cbcau))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tfName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnDetailLeftLayout.setVerticalGroup(
            pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetailLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbName)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbGrade)
                    .addComponent(cbbGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbGender)
                    .addComponent(rdMale)
                    .addComponent(rdFemale)
                    .addComponent(rdMiddle))
                .addGap(29, 29, 29)
                .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbvolleyball)
                    .addComponent(lbHobbies)
                    .addComponent(cbFootball)
                    .addComponent(cbcau))
                .addContainerGap(201, Short.MAX_VALUE))
        );

        pnDetailLeftLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbbGrade, tfName});

        spDetailInfo.setLeftComponent(pnDetailLeft);

        pnDetailRight.setBackground(new java.awt.Color(204, 204, 0));

        lbMath.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbMath.setText("Điểm toán:");

        tfMath.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfMath.setMinimumSize(new java.awt.Dimension(6, 32));

        lbLiterature.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbLiterature.setText("Điểm văn:");

        tfLiterature.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfLiterature.setMinimumSize(new java.awt.Dimension(6, 32));

        lbComment.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbComment.setText("Nhận xét:");

        taComment.setColumns(20);
        taComment.setRows(5);
        scrollComment.setViewportView(taComment);

        lbImage.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbImage.setText("Hình ảnh:");

        lbAvatar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0), 2));

        btnUpload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/upload.png"))); // NOI18N

        javax.swing.GroupLayout pnDetailRightLayout = new javax.swing.GroupLayout(pnDetailRight);
        pnDetailRight.setLayout(pnDetailRightLayout);
        pnDetailRightLayout.setHorizontalGroup(
            pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetailRightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbLiterature)
                    .addComponent(lbMath)
                    .addComponent(lbComment)
                    .addComponent(lbImage))
                .addGap(18, 18, 18)
                .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfMath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfLiterature, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollComment)
                    .addGroup(pnDetailRightLayout.createSequentialGroup()
                        .addComponent(lbAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnUpload)
                        .addGap(0, 23, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnDetailRightLayout.setVerticalGroup(
            pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetailRightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMath)
                    .addComponent(tfMath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLiterature)
                    .addComponent(tfLiterature, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbComment)
                    .addComponent(scrollComment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbImage)
                    .addComponent(lbAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpload))
                .addGap(53, 53, 53))
        );

        spDetailInfo.setRightComponent(pnDetailRight);

        pnMainCenter.add(spDetailInfo, java.awt.BorderLayout.CENTER);

        add(pnMainCenter, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetActionPerformed

    private void tfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNameActionPerformed

    private void rdMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdMaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdMaleActionPerformed

    private void rdFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdFemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdFemaleActionPerformed

    private void rdMiddleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdMiddleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdMiddleActionPerformed

    private void cbcauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbcauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbcauActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnUpload;
    private javax.swing.JCheckBox cbFootball;
    private javax.swing.JComboBox cbbGrade;
    private javax.swing.JCheckBox cbcau;
    private javax.swing.JCheckBox cbvolleyball;
    private javax.swing.JLabel lbAvatar;
    private javax.swing.JLabel lbComment;
    private javax.swing.JLabel lbGender;
    private javax.swing.JLabel lbGrade;
    private javax.swing.JLabel lbHobbies;
    private javax.swing.JLabel lbImage;
    private javax.swing.JLabel lbLiterature;
    private javax.swing.JLabel lbMath;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbStudentInfo;
    private javax.swing.JPanel pnDetailLeft;
    private javax.swing.JPanel pnDetailRight;
    private javax.swing.JPanel pnMainBottom;
    private javax.swing.JPanel pnMainCenter;
    private javax.swing.JPanel pnMainTop;
    private javax.swing.JRadioButton rdFemale;
    private javax.swing.JRadioButton rdMale;
    private javax.swing.JRadioButton rdMiddle;
    private javax.swing.JScrollPane scrollComment;
    private javax.swing.JSplitPane spDetailInfo;
    private javax.swing.JTextArea taComment;
    private javax.swing.JTextField tfLiterature;
    private javax.swing.JTextField tfMath;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables
}
