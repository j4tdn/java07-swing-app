/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub;

import model.bean.Grade;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.AbstractButton;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class PnStudentForm extends javax.swing.JPanel {

    private File targetFile;

    /**
     * Creates new form NewJPanel
     */
    public PnStudentForm() {
        initComponents();
        initDataModel();
        initEvents();

    }

    public void initDataModel() {
        initCbbGradeModel();
    }

    public void initEvents() {
        btUploadEvent();
        btSubmitEvent();
    }

    public void btSubmitEvent() {
        btSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Grade grade = (Grade) cbbGrade.getSelectedItem();
                String gender = getGender();
                String hobbies = getHobies(cbBadminton, cbFootball, cbVolleyball);
                String fileName = targetFile != null ? targetFile.getName() : "Undefined!";
                System.out.println("=================");
                System.out.println("grade : " + grade);
                System.out.println("gender : " + gender);
                System.out.println("hobbies : " + hobbies);
                System.out.println("fileName: " + fileName);
            }

        });
    }

    private String getHobies(JCheckBox... checkBoxs) {
        //Immutable :String literal,object  công chuỗi thì trên head tạo ô nhớ mới
        //Mutable :StringBulder,Stirng Buffer ko tạo ô nhwos mới mà cộng thêm vào ô nhwos cũ

        StringBuilder buider = new StringBuilder();
        return Arrays.stream(checkBoxs)
                .filter(JCheckBox::isSelected)
                .map(JCheckBox::getText)
                .collect(Collectors.joining(","));
    }

    private String getGender() {

        Enumeration<AbstractButton> elements = btgGender.getElements();

        while (elements.hasMoreElements()) {
            AbstractButton button = elements.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return "";
    }

    public void btUploadEvent() {
        btUpload.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                String path = getClass().getResource("/images.ghost").getFile();

                System.out.println("path" + path);
                JFileChooser fc = new JFileChooser(path);

                if (JFileChooser.APPROVE_OPTION == fc.showDialog(null, "Upload")) {
                    String regex = "[\\w-]+[.]{1}(?i)(?:png|jpg)";

                    File sourceFile = fc.getSelectedFile();
                    String fileName = sourceFile.getName();

                    if (!fileName.matches(regex)) {
                        JOptionPane.showMessageDialog(null, "INVALID IMAGE PATH");
                        return;

                    }
                    String renameFile = System.currentTimeMillis() + fileName;

                    targetFile = new File("image_upload" + File.separator + renameFile);

                    //Step1:  copy & rename to project's file upload
                    try {
                        Files.copy(sourceFile.toPath(), targetFile.toPath());
                        //Step2:  display  rename file on UI
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    Image image = new ImageIcon(targetFile.toString())
                            .getImage()
                            .getScaledInstance(lbAvatar.getWidth(),
                                    lbAvatar.getHeight(),
                                    Image.SCALE_SMOOTH);
                    Icon icon = new ImageIcon(image);
                    lbAvatar.setIcon(icon);
                }

            }

        });
    }

    private void initCbbGradeModel() {

        Grade[] grades = {
            new Grade(1, "12T1"),
            new Grade(2, "12T2"),
            new Grade(3, "12T3"),
            new Grade(4, "12T4"),};

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

        btgGender = new javax.swing.ButtonGroup();
        pnMainTop = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnMainTop1 = new javax.swing.JPanel();
        pnMainBottom = new javax.swing.JPanel();
        btSubmit = new javax.swing.JButton();
        btReset = new javax.swing.JButton();
        pnMainCenter = new javax.swing.JPanel();
        sppDetailInfor = new javax.swing.JSplitPane();
        pnDetailLeft = new javax.swing.JPanel();
        lbName = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        lbClass = new javax.swing.JLabel();
        cbbGrade = new javax.swing.JComboBox();
        lbGender = new javax.swing.JLabel();
        lbHobby = new javax.swing.JLabel();
        rdMale = new javax.swing.JRadioButton();
        rdFemale = new javax.swing.JRadioButton();
        rdDiff = new javax.swing.JRadioButton();
        cbFootball = new javax.swing.JCheckBox();
        cbBadminton = new javax.swing.JCheckBox();
        cbVolleyball = new javax.swing.JCheckBox();
        pnDetailRight = new javax.swing.JPanel();
        lbMath = new javax.swing.JLabel();
        tfMath = new javax.swing.JTextField();
        lbLiterature = new javax.swing.JLabel();
        tfLiterature = new javax.swing.JTextField();
        lbCommit = new javax.swing.JLabel();
        scrollComment = new javax.swing.JScrollPane();
        taComment = new javax.swing.JTextArea();
        lbImage = new javax.swing.JLabel();
        lbAvatar = new javax.swing.JLabel();
        btUpload = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/student.png"))); // NOI18N
        jLabel1.setText("THÔNG TIN HỌC VIÊN");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pnMainTop.add(jLabel1);
        pnMainTop.add(pnMainTop1);

        add(pnMainTop, java.awt.BorderLayout.PAGE_START);

        btSubmit.setText("Submit");
        btSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSubmitActionPerformed(evt);
            }
        });
        pnMainBottom.add(btSubmit);

        btReset.setText("Reset");
        pnMainBottom.add(btReset);

        add(pnMainBottom, java.awt.BorderLayout.PAGE_END);

        pnMainCenter.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thông tin chi tiết", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(0, 0, 204))); // NOI18N
        pnMainCenter.setLayout(new java.awt.BorderLayout());

        pnDetailLeft.setBackground(new java.awt.Color(153, 255, 255));

        lbName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbName.setText("Họ tên:");

        tfName.setPreferredSize(new java.awt.Dimension(6, 32));

        lbClass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbClass.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbClass.setText("Lớp:");

        cbbGrade.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lbGender.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbGender.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbGender.setText("Giới tính:");

        lbHobby.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbHobby.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbHobby.setText("Sở thích:");

        btgGender.add(rdMale);
        rdMale.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rdMale.setSelected(true);
        rdMale.setText("Nam");
        rdMale.setContentAreaFilled(false);
        rdMale.setFocusPainted(false);
        rdMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdMaleActionPerformed(evt);
            }
        });

        btgGender.add(rdFemale);
        rdFemale.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rdFemale.setText("Nữ");
        rdFemale.setContentAreaFilled(false);
        rdFemale.setFocusPainted(false);
        rdFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdFemaleActionPerformed(evt);
            }
        });

        btgGender.add(rdDiff);
        rdDiff.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rdDiff.setText("Khác");
        rdDiff.setContentAreaFilled(false);
        rdDiff.setFocusPainted(false);
        rdDiff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdDiffActionPerformed(evt);
            }
        });

        cbFootball.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbFootball.setText("Đá bóng");
        cbFootball.setContentAreaFilled(false);
        cbFootball.setFocusPainted(false);

        cbBadminton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbBadminton.setText("Cầu lông");
        cbBadminton.setContentAreaFilled(false);
        cbBadminton.setFocusPainted(false);

        cbVolleyball.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbVolleyball.setText("Bóng chuyền");
        cbVolleyball.setContentAreaFilled(false);
        cbVolleyball.setFocusPainted(false);

        javax.swing.GroupLayout pnDetailLeftLayout = new javax.swing.GroupLayout(pnDetailLeft);
        pnDetailLeft.setLayout(pnDetailLeftLayout);
        pnDetailLeftLayout.setHorizontalGroup(
            pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetailLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbName)
                    .addComponent(lbClass)
                    .addComponent(lbHobby)
                    .addComponent(lbGender))
                .addGap(18, 18, 18)
                .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDetailLeftLayout.createSequentialGroup()
                        .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDetailLeftLayout.createSequentialGroup()
                                .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(rdMale, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbFootball, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdFemale)
                                    .addComponent(cbVolleyball))
                                .addGap(10, 10, 10))
                            .addGroup(pnDetailLeftLayout.createSequentialGroup()
                                .addComponent(cbbGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbBadminton)
                            .addComponent(rdDiff)))
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
                    .addComponent(lbClass)
                    .addComponent(cbbGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbGender)
                    .addComponent(rdMale)
                    .addComponent(rdFemale)
                    .addComponent(rdDiff))
                .addGap(30, 30, 30)
                .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbHobby)
                    .addComponent(cbFootball)
                    .addComponent(cbVolleyball)
                    .addComponent(cbBadminton))
                .addContainerGap(211, Short.MAX_VALUE))
        );

        sppDetailInfor.setLeftComponent(pnDetailLeft);

        pnDetailRight.setBackground(new java.awt.Color(204, 255, 0));

        lbMath.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbMath.setText("Điểm toán:");

        tfMath.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lbLiterature.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbLiterature.setText("Điểm văn:");

        tfLiterature.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lbCommit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbCommit.setText("Nhận xét:");

        taComment.setColumns(20);
        taComment.setLineWrap(true);
        taComment.setRows(5);
        taComment.setTabSize(4);
        scrollComment.setViewportView(taComment);

        lbImage.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbImage.setText("Hình ảnh");

        lbAvatar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0), 2));

        btUpload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/upload.png"))); // NOI18N

        javax.swing.GroupLayout pnDetailRightLayout = new javax.swing.GroupLayout(pnDetailRight);
        pnDetailRight.setLayout(pnDetailRightLayout);
        pnDetailRightLayout.setHorizontalGroup(
            pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetailRightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMath)
                    .addComponent(lbLiterature)
                    .addComponent(lbCommit)
                    .addComponent(lbImage))
                .addGap(18, 18, 18)
                .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfLiterature)
                    .addComponent(tfMath)
                    .addComponent(scrollComment)
                    .addGroup(pnDetailRightLayout.createSequentialGroup()
                        .addComponent(lbAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btUpload)
                        .addGap(96, 96, 96))))
        );
        pnDetailRightLayout.setVerticalGroup(
            pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetailRightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbMath)
                    .addComponent(tfMath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbLiterature)
                    .addComponent(tfLiterature, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCommit)
                    .addComponent(scrollComment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDetailRightLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbImage)
                            .addComponent(lbAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnDetailRightLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        sppDetailInfor.setRightComponent(pnDetailRight);

        pnMainCenter.add(sppDetailInfor, java.awt.BorderLayout.CENTER);

        add(pnMainCenter, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSubmitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSubmitActionPerformed

    private void rdMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdMaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdMaleActionPerformed

    private void rdFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdFemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdFemaleActionPerformed

    private void rdDiffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdDiffActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdDiffActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btReset;
    private javax.swing.JButton btSubmit;
    private javax.swing.JButton btUpload;
    private javax.swing.ButtonGroup btgGender;
    private javax.swing.JCheckBox cbBadminton;
    private javax.swing.JCheckBox cbFootball;
    private javax.swing.JCheckBox cbVolleyball;
    private javax.swing.JComboBox cbbGrade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbAvatar;
    private javax.swing.JLabel lbClass;
    private javax.swing.JLabel lbCommit;
    private javax.swing.JLabel lbGender;
    private javax.swing.JLabel lbHobby;
    private javax.swing.JLabel lbImage;
    private javax.swing.JLabel lbLiterature;
    private javax.swing.JLabel lbMath;
    private javax.swing.JLabel lbName;
    private javax.swing.JPanel pnDetailLeft;
    private javax.swing.JPanel pnDetailRight;
    private javax.swing.JPanel pnMainBottom;
    private javax.swing.JPanel pnMainCenter;
    private javax.swing.JPanel pnMainTop;
    private javax.swing.JPanel pnMainTop1;
    private javax.swing.JRadioButton rdDiff;
    private javax.swing.JRadioButton rdFemale;
    private javax.swing.JRadioButton rdMale;
    private javax.swing.JScrollPane scrollComment;
    private javax.swing.JSplitPane sppDetailInfor;
    private javax.swing.JTextArea taComment;
    private javax.swing.JTextField tfLiterature;
    private javax.swing.JTextField tfMath;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables
}
