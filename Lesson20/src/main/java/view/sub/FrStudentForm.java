
package view.sub;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.swing.AbstractButton;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.bean.Grade;
import model.bean.Student;
import service.StudentService;
import service.StudentServiceImpl;
import utils.ImageUtils;

/**
 *
 * @author khanh
 */
public class FrStudentForm extends javax.swing.JFrame {
    private File targetFile;
    private final StudentService service;
    private Student student;
    private int size;
    private String imagePath;
    /**
     * Creates new form FrStudentForm
     * @param size
     */
    
    public FrStudentForm() {
        service = new StudentServiceImpl();
        initComponents();
        initComponentsManually();
        initEvents();
     
    }
    public FrStudentForm(int size) {
        this.size=size;
        service = new StudentServiceImpl();
        initComponents();
        initComponentsManually();
        initEvents();
     
    }
    
    public FrStudentForm(Student student,int size) {
        this.student = student;
        this.size=size;
        service = new StudentServiceImpl();
        initComponents();
        initComponentsManually(student);
        initEvents();
       
     
    }
    
    
    private void initEvents(){
        btnSubmitEvents();
        btUploadEvents();
    }
    private void initDataModel() {
        initCbbGradeModel();
    }
    private String getGender(){
        Enumeration<AbstractButton> elements =   btngGender.getElements();
        while(elements.hasMoreElements()){
            AbstractButton button = elements.nextElement();
            
            if(button.isSelected()){
                return button.getText();
            }
        }
        
        return "";
    }
    
     private void setGender() {
        if (student.getGender() != null) {
            if (student.getGender()) {
                rdFemale.setSelected(true);
            } else {
                rdMale.setSelected(true);
            }
        }
    }
    
     private void btUploadEvents() {
        btnUpload.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String path = getClass().getResource("/images.ghost").getFile();
                JFileChooser fc = new JFileChooser(path);
                int chooser = fc.showDialog(null, "Upload");
                if (chooser == JFileChooser.APPROVE_OPTION) {
                    File sourceFile = fc.getSelectedFile();
                    String fileName = sourceFile.getName();

                    String regex = "[\\w-]+[.]{1}(?i)(?:png|jpg|jpeg|gif)";
                    if (!(fileName.matches(regex))) {
                        JOptionPane.showMessageDialog(null, "INVALID IMAGE PATH");
                        return;
                    }
                    imagePath = path + File.separator + fileName;
                    Image image = new ImageIcon(imagePath).getImage()
                            .getScaledInstance(lbAvatar.getWidth(), lbAvatar.getHeight(), Image.SCALE_SMOOTH);
                    Icon icon = new ImageIcon(image);
                    lbAvatar.setIcon(icon);
                }
            }
        });
    }
    
    private void initCbbGradeModel() {
        List<Grade> list = service.getAllGrade();
        Grade[] grades = new Grade[list.size()];
        list.toArray(grades);
        ComboBoxModel<Grade> gradeModel = new DefaultComboBoxModel<>(grades);
        cbbGrade.setModel(gradeModel);
    }
    
    private void btnSubmitEvents(){
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(student==null){
                    student = new Student(String.valueOf(size+1)
                            , tfName.getText()
                            , getGender().equals("Nữ"),"a"
                            ,Double.parseDouble(tfMath.getText())
                            , Double.parseDouble(tfLiterature.getText())
                            ,(Grade) cbbGrade.getSelectedItem()
                            , imagePath
                            ,taComment.getText());
                    service.addStudent(student);
                }
            }
            
        });
    }
    private void initComponentsManually(){
        initDataModel();
        setLocationRelativeTo(null);
    }
    
    private void showStudentInfo(Student student) {
        if(student!=null){
        tfName.setText(student.getFullname());
        tfMath.setText(student.getMath().toString());
        tfLiterature.setText(student.getLiterature().toString());
        cbbGrade.setSelectedItem(student.getGrade());
        taComment.setText(student.getComment());
        setGender();
        setHobbies();
        lbAvatar.setIcon(ImageUtils.getIcon(student.getAvatarPath(),lbAvatar.getWidth(),lbAvatar.getHeight()));
        }
    }
    private void initComponentsManually(Student student){
       
        initDataModel();
        setLocationRelativeTo(null);
        showStudentInfo(student);
        
        
    }
    private void setHobbies(){
        List hobbies = Pattern.compile(", ")
                .splitAsStream(student.getHobbies())
                .collect(Collectors.toList());
        JCheckBox[] cbHobbies ={cbFootball,cbcau,cbvolleyball};
        for(JCheckBox checkBox:cbHobbies){
            if(hobbies.contains(checkBox.getText())){
            checkBox.setSelected(true);
            }
        }
    }
    private String getHobbies(JCheckBox...checkBoxs){
        StringBuilder builder = new StringBuilder();
         return Arrays.stream(checkBoxs).filter(JCheckBox::isSelected).map(JCheckBox::getText).collect(Collectors.joining(", "));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngGender = new javax.swing.ButtonGroup();
        pnMainBottom = new javax.swing.JPanel();
        btnSubmit = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        pnMainTop = new javax.swing.JPanel();
        lbStudentInfo = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        getContentPane().add(pnMainBottom, java.awt.BorderLayout.PAGE_END);

        lbStudentInfo.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lbStudentInfo.setForeground(new java.awt.Color(0, 0, 102));
        lbStudentInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/student.png"))); // NOI18N
        lbStudentInfo.setText("THÔNG TIN HỌC VIÊN");
        lbStudentInfo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbStudentInfo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pnMainTop.add(lbStudentInfo);

        getContentPane().add(pnMainTop, java.awt.BorderLayout.PAGE_START);

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
                .addContainerGap(197, Short.MAX_VALUE))
        );

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
        taComment.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        taComment.setLineWrap(true);
        taComment.setRows(5);
        taComment.setTabSize(4);
        taComment.setWrapStyleWord(true);
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
                    .addComponent(scrollComment, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pnDetailRightLayout.createSequentialGroup()
                        .addComponent(lbAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnUpload)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbImage)
                    .addComponent(lbAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpload))
                .addGap(53, 53, 53))
        );

        spDetailInfo.setRightComponent(pnDetailRight);

        pnMainCenter.add(spDetailInfo, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnMainCenter, java.awt.BorderLayout.CENTER);

        pack();
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
            java.util.logging.Logger.getLogger(FrStudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrStudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrStudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrStudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrStudentForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnUpload;
    private javax.swing.ButtonGroup btngGender;
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
