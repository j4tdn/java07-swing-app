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
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Enumeration;
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
 * @author qphan
 */
public class PnStudentForm extends javax.swing.JPanel {

    private File targetFile;
    
    /**
     * Creates new form PnStudent
     */
    public PnStudentForm() {
        initComponents();
        
        initDataModel();
        initEvents();
    }
    
    private void initDataModel() {
        initCbbGradeModel();
    }
    
    private void initEvents() {
        btUploadEvents();
        btSubmitEvents();
    }
    
    private void btSubmitEvents() {
        btSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Grade grade = (Grade)cbbGrade.getSelectedItem();
                String gender = getGender();
                String hobbies = getHobbies(cbBadminton, cbFootball, cbVolleyball);
                String filename = targetFile != null ? targetFile.getName() : "Undefined";
                System.out.println("===================");
                System.out.println("grade: " + grade);
                System.out.println("gender: " + gender);
                System.out.println("hobbies: " + hobbies);
                System.out.println("filename: " + filename);
            }
        });
    }
    
    private String getHobbies(JCheckBox ... checkBoxs) {
        // Immutable: String literal, object
        // Mutable: StringBuilder, StringBuffer
        return Arrays.stream(checkBoxs)
                .filter(JCheckBox::isSelected)
                .map(JCheckBox::getText)
                .collect(Collectors.joining(", "));
    }
    
    private String getGender() {
        Enumeration<AbstractButton> elements = btgGender.getElements();
        while(elements.hasMoreElements()) {
            AbstractButton button = elements.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return "";
    }
    
    private void btUploadEvents() {
        btUpload.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String path = getClass().getResource("/images.ghost").getFile();
                JFileChooser fc = new JFileChooser(path);
                if (JFileChooser.APPROVE_OPTION == fc.showDialog(null, "Upload")) {
                    String regex = "[\\w-]+[.]{1}(?i)(?:png|jpg|jpeg|gif)";
                    File sourceFile = fc.getSelectedFile();
                    String fileName = sourceFile.getName();
                    if (!fileName.matches(regex)) {
                        JOptionPane.showMessageDialog(null, "INVALID IMAGE PATH");
                        return;
                    }
                    String renamedFile = System.currentTimeMillis() + fileName;
                    targetFile = new File("image_upload" + File.separator + renamedFile);
                    // Step 1: Copy & rename to project's file upload
                    try {
                        Files.copy(sourceFile.toPath(), targetFile.toPath());
                    } catch(IOException ex) {
                        ex.printStackTrace();
                    }
                    
                    // Step 2: Display renamed file on UI
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
          new Grade(1, "Lớp 11T1"),  
          new Grade(2, "Lớp 12T2"),  
          new Grade(3, "Lớp 13T3"),  
          new Grade(4, "Lớp 14T4"),  
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

        btgGender = new javax.swing.ButtonGroup();
        pnMainTop = new javax.swing.JPanel();
        lbStudentInfo = new javax.swing.JLabel();
        pnMainBottom = new javax.swing.JPanel();
        btSubmit = new javax.swing.JButton();
        btReset = new javax.swing.JButton();
        pnMainCenter = new javax.swing.JPanel();
        sppDetailInfo = new javax.swing.JSplitPane();
        pnDetailLeft = new javax.swing.JPanel();
        lbName = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        lbGrade = new javax.swing.JLabel();
        cbbGrade = new javax.swing.JComboBox();
        lbGender = new javax.swing.JLabel();
        lbHobbies = new javax.swing.JLabel();
        rdMale = new javax.swing.JRadioButton();
        rdFemail = new javax.swing.JRadioButton();
        rdDiff = new javax.swing.JRadioButton();
        cbFootball = new javax.swing.JCheckBox();
        cbVolleyball = new javax.swing.JCheckBox();
        cbBadminton = new javax.swing.JCheckBox();
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
        btUpload = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        lbStudentInfo.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lbStudentInfo.setForeground(new java.awt.Color(51, 0, 153));
        lbStudentInfo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbStudentInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/student.png"))); // NOI18N
        lbStudentInfo.setText("THÔNG TIN HỌC VIÊN");
        lbStudentInfo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbStudentInfo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pnMainTop.add(lbStudentInfo);

        add(pnMainTop, java.awt.BorderLayout.PAGE_START);

        pnMainBottom.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 10));

        btSubmit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btSubmit.setText("Submit");
        pnMainBottom.add(btSubmit);

        btReset.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btReset.setText("Reset");
        pnMainBottom.add(btReset);

        add(pnMainBottom, java.awt.BorderLayout.PAGE_END);

        pnMainCenter.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thông tin chi tiết", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 0, 204))); // NOI18N
        pnMainCenter.setLayout(new java.awt.BorderLayout());

        pnDetailLeft.setBackground(new java.awt.Color(153, 255, 255));

        lbName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbName.setText("Họ tên:");

        tfName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfName.setPreferredSize(new java.awt.Dimension(6, 32));

        lbGrade.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbGrade.setText("Lớp:");

        cbbGrade.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbbGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbGradeActionPerformed(evt);
            }
        });

        lbGender.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbGender.setText("Giới tính:");

        lbHobbies.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbHobbies.setText("Sở thích:");

        btgGender.add(rdMale);
        rdMale.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rdMale.setText("Nam");
        rdMale.setContentAreaFilled(false);
        rdMale.setFocusPainted(false);

        btgGender.add(rdFemail);
        rdFemail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rdFemail.setText("Nữ");
        rdFemail.setContentAreaFilled(false);
        rdFemail.setFocusPainted(false);

        btgGender.add(rdDiff);
        rdDiff.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rdDiff.setText("Khác");
        rdDiff.setContentAreaFilled(false);
        rdDiff.setFocusPainted(false);

        cbFootball.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbFootball.setText("Bóng đá");
        cbFootball.setContentAreaFilled(false);
        cbFootball.setFocusPainted(false);

        cbVolleyball.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbVolleyball.setText("Bóng chuyền");
        cbVolleyball.setContentAreaFilled(false);
        cbVolleyball.setFocusPainted(false);

        cbBadminton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbBadminton.setText("Cầu lông");
        cbBadminton.setContentAreaFilled(false);
        cbBadminton.setFocusPainted(false);

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
                            .addComponent(rdMale)
                            .addComponent(cbFootball))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdFemail)
                            .addComponent(cbVolleyball))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdDiff)
                            .addComponent(cbBadminton)))
                    .addGroup(pnDetailLeftLayout.createSequentialGroup()
                        .addComponent(cbbGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(rdFemail)
                    .addComponent(rdDiff))
                .addGap(30, 30, 30)
                .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbHobbies)
                    .addComponent(cbFootball)
                    .addComponent(cbVolleyball)
                    .addComponent(cbBadminton))
                .addContainerGap(248, Short.MAX_VALUE))
        );

        pnDetailLeftLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbbGrade, tfName});

        sppDetailInfo.setLeftComponent(pnDetailLeft);

        pnDetailRight.setBackground(new java.awt.Color(255, 255, 0));

        lbMath.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbMath.setText("Điểm Toán:");

        tfMath.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfMath.setMinimumSize(new java.awt.Dimension(6, 32));

        lbLiterature.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbLiterature.setText("Điểm Văn:");

        tfLiterature.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfLiterature.setMinimumSize(new java.awt.Dimension(6, 32));

        lbComment.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbComment.setText("Nhận xét:");

        taComment.setColumns(20);
        taComment.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        taComment.setLineWrap(true);
        taComment.setRows(5);
        taComment.setTabSize(4);
        taComment.setWrapStyleWord(true);
        scrollComment.setViewportView(taComment);

        lbImage.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbImage.setText("Hình Ảnh:");

        lbAvatar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 203, 0), 2));

        btUpload.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btUpload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/upload.png"))); // NOI18N
        btUpload.setFocusPainted(false);

        javax.swing.GroupLayout pnDetailRightLayout = new javax.swing.GroupLayout(pnDetailRight);
        pnDetailRight.setLayout(pnDetailRightLayout);
        pnDetailRightLayout.setHorizontalGroup(
            pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetailRightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMath)
                    .addComponent(lbLiterature)
                    .addComponent(lbComment)
                    .addComponent(lbImage))
                .addGap(18, 18, 18)
                .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfMath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfLiterature, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                    .addComponent(scrollComment)
                    .addGroup(pnDetailRightLayout.createSequentialGroup()
                        .addComponent(lbAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addGap(33, 33, 33)
                .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbComment)
                    .addComponent(scrollComment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnDetailRightLayout.createSequentialGroup()
                        .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbImage)
                            .addComponent(btUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 154, Short.MAX_VALUE)))
                .addContainerGap())
        );

        sppDetailInfo.setRightComponent(pnDetailRight);

        pnMainCenter.add(sppDetailInfo, java.awt.BorderLayout.CENTER);

        add(pnMainCenter, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void cbbGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbGradeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbGradeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btReset;
    private javax.swing.JButton btSubmit;
    private javax.swing.JButton btUpload;
    private javax.swing.ButtonGroup btgGender;
    private javax.swing.JCheckBox cbBadminton;
    private javax.swing.JCheckBox cbFootball;
    private javax.swing.JCheckBox cbVolleyball;
    private javax.swing.JComboBox cbbGrade;
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
    private javax.swing.JRadioButton rdDiff;
    private javax.swing.JRadioButton rdFemail;
    private javax.swing.JRadioButton rdMale;
    private javax.swing.JScrollPane scrollComment;
    private javax.swing.JSplitPane sppDetailInfo;
    private javax.swing.JTextArea taComment;
    private javax.swing.JTextField tfLiterature;
    private javax.swing.JTextField tfMath;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables
}
