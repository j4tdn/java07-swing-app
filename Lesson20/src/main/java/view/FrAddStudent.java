/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.beans.Grade;
import java.awt.Color;
import java.awt.Font;
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
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import model.StudentTableModel;
import model.beans.Student;
import model.beans.StudentRaw;
import service.StudentService;
import service.StudentServiceImpl;

/**
 *
 * @author DangHoang
 */
public class FrAddStudent extends JFrame {

//    private File targetFile;
    private final Border outsideBorderCenter = BorderFactory.createLineBorder(new Color(204, 0, 102), 2);
    private final Border insideBorderCenter = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
            "THÔNG TIN", TitledBorder.CENTER, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 13),
            new Color(0, 0, 204));
    private final Border borderCenter = BorderFactory.createCompoundBorder(outsideBorderCenter, insideBorderCenter);
    private final StudentService service;
    private final Student student;
    private final List<Student> students;
    private final List<Grade> listGrades;
    private final JTable tbStudent;
    private String imagePath;

    /**
     * Creates new form PanelStudent
     *
     * @param students
     * @param student
     * @param tbStudent
     */
    public FrAddStudent(List<Student> students, Student student, JTable tbStudent) {
        service = new StudentServiceImpl();
        listGrades = service.getGrade();
        this.students = students;
        this.student = student;
        this.tbStudent = tbStudent;

        initComponents();
        initDataModel();
        initComponentsManually();
        initEvents();
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
        pmCenterLeft = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        pnMainTop = new javax.swing.JPanel();
        lbStudentInfo = new javax.swing.JLabel();
        pnMainBottom = new javax.swing.JPanel();
        btSubmit = new javax.swing.JButton();
        btReset = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        pnMainCenter = new javax.swing.JPanel();
        spMain = new javax.swing.JSplitPane();
        pnDetailLeft = new javax.swing.JPanel();
        lbName = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        lbClass = new javax.swing.JLabel();
        cbClass = new javax.swing.JComboBox();
        lbGender = new javax.swing.JLabel();
        lbHobbies = new javax.swing.JLabel();
        rbMale = new javax.swing.JRadioButton();
        rbFemale = new javax.swing.JRadioButton();
        rbOther = new javax.swing.JRadioButton();
        cbSocer = new javax.swing.JCheckBox();
        cbVolleyball = new javax.swing.JCheckBox();
        cbBadminton = new javax.swing.JCheckBox();
        pnDetailRight = new javax.swing.JPanel();
        lbMath = new javax.swing.JLabel();
        tfMath = new javax.swing.JTextField();
        lbLiterature = new javax.swing.JLabel();
        tfLiterature = new javax.swing.JTextField();
        lbComment = new javax.swing.JLabel();
        spComment = new javax.swing.JScrollPane();
        taComment = new javax.swing.JTextArea();
        lbPicture = new javax.swing.JLabel();
        lbAvatar = new javax.swing.JLabel();
        btChoose = new javax.swing.JButton();
        mnBar = new javax.swing.JMenuBar();
        mnFile = new javax.swing.JMenu();
        mniNewPr = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        mnEdit = new javax.swing.JMenu();
        mnHelp = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");
        pmCenterLeft.add(jMenuItem1);

        jMenuItem7.setText("jMenuItem7");
        pmCenterLeft.add(jMenuItem7);

        pnMainTop.setBackground(new java.awt.Color(0, 153, 153));
        pnMainTop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51), 2));

        lbStudentInfo.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lbStudentInfo.setForeground(new java.awt.Color(0, 0, 204));
        lbStudentInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/student.png"))); // NOI18N
        lbStudentInfo.setText("THÔNG TIN HỌC VIÊN");
        lbStudentInfo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        pnMainTop.add(lbStudentInfo);

        getContentPane().add(pnMainTop, java.awt.BorderLayout.PAGE_START);

        pnMainBottom.setBackground(new java.awt.Color(0, 153, 153));
        pnMainBottom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51), 2));
        pnMainBottom.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 10));

        btSubmit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btSubmit.setText("Submit");
        pnMainBottom.add(btSubmit);

        btReset.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btReset.setText("Reset");
        pnMainBottom.add(btReset);

        btCancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btCancel.setText("Cancel");
        pnMainBottom.add(btCancel);

        getContentPane().add(pnMainBottom, java.awt.BorderLayout.PAGE_END);

        pnMainCenter.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        pnMainCenter.setLayout(new java.awt.BorderLayout());

        pnDetailLeft.setBackground(new java.awt.Color(0, 255, 255));

        lbName.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbName.setText("Họ Tên :");

        tfName.setPreferredSize(new java.awt.Dimension(7, 30));

        lbClass.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbClass.setText("Lớp :");

        cbClass.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        cbClass.setPreferredSize(new java.awt.Dimension(57, 30));

        lbGender.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbGender.setText("Giới Tính :");

        lbHobbies.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbHobbies.setText("Sở Thích :");

        btgGender.add(rbMale);
        rbMale.setText("Nam");
        rbMale.setContentAreaFilled(false);
        rbMale.setFocusPainted(false);

        btgGender.add(rbFemale);
        rbFemale.setText("Nữ");
        rbFemale.setContentAreaFilled(false);
        rbFemale.setFocusPainted(false);

        btgGender.add(rbOther);
        rbOther.setText("Khác");
        rbOther.setContentAreaFilled(false);
        rbOther.setFocusPainted(false);

        cbSocer.setText("Đá bóng");
        cbSocer.setContentAreaFilled(false);
        cbSocer.setFocusPainted(false);

        cbVolleyball.setText("Cầu lông");
        cbVolleyball.setContentAreaFilled(false);
        cbVolleyball.setFocusPainted(false);

        cbBadminton.setText("Bóng chuyền");
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
                    .addComponent(lbClass)
                    .addComponent(lbGender)
                    .addComponent(lbHobbies))
                .addGap(18, 18, 18)
                .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbClass, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnDetailLeftLayout.createSequentialGroup()
                        .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbMale)
                            .addComponent(cbSocer))
                        .addGap(20, 20, 20)
                        .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbFemale)
                            .addComponent(cbBadminton))
                        .addGap(11, 11, 11)
                        .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbOther)
                            .addComponent(cbVolleyball))))
                .addContainerGap())
        );
        pnDetailLeftLayout.setVerticalGroup(
            pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetailLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbName)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbClass)
                    .addComponent(cbClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(rbOther)
                    .addComponent(lbGender)
                    .addComponent(rbMale)
                    .addComponent(rbFemale))
                .addGap(25, 25, 25)
                .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbHobbies)
                    .addComponent(cbSocer)
                    .addComponent(cbBadminton)
                    .addComponent(cbVolleyball))
                .addContainerGap(173, Short.MAX_VALUE))
        );

        spMain.setLeftComponent(pnDetailLeft);

        pnDetailRight.setBackground(new java.awt.Color(255, 204, 51));

        lbMath.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbMath.setText("Điểm Toán :");

        tfMath.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tfMath.setPreferredSize(new java.awt.Dimension(7, 30));

        lbLiterature.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbLiterature.setText("Điểm Văn :");

        tfLiterature.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tfLiterature.setPreferredSize(new java.awt.Dimension(7, 30));

        lbComment.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbComment.setText("Nhận Xét :");

        taComment.setColumns(20);
        taComment.setLineWrap(true);
        taComment.setRows(5);
        taComment.setTabSize(4);
        taComment.setWrapStyleWord(true);
        spComment.setViewportView(taComment);

        lbPicture.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbPicture.setText("Hình Ảnh :");

        lbAvatar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 203, 0), 2));

        btChoose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/upload.png"))); // NOI18N
        btChoose.setFocusPainted(false);

        javax.swing.GroupLayout pnDetailRightLayout = new javax.swing.GroupLayout(pnDetailRight);
        pnDetailRight.setLayout(pnDetailRightLayout);
        pnDetailRightLayout.setHorizontalGroup(
            pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetailRightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDetailRightLayout.createSequentialGroup()
                        .addComponent(lbMath)
                        .addGap(18, 18, 18)
                        .addComponent(tfMath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnDetailRightLayout.createSequentialGroup()
                        .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLiterature)
                            .addComponent(lbComment)
                            .addComponent(lbPicture))
                        .addGap(25, 25, 25)
                        .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfLiterature, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spComment)
                            .addGroup(pnDetailRightLayout.createSequentialGroup()
                                .addComponent(lbAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        pnDetailRightLayout.setVerticalGroup(
            pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetailRightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbMath)
                    .addComponent(tfMath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbLiterature)
                    .addComponent(tfLiterature, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spComment, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbComment))
                .addGap(25, 25, 25)
                .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnDetailRightLayout.createSequentialGroup()
                        .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbPicture)
                            .addComponent(btChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 113, Short.MAX_VALUE)))
                .addContainerGap())
        );

        spMain.setRightComponent(pnDetailRight);

        pnMainCenter.add(spMain, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnMainCenter, java.awt.BorderLayout.CENTER);

        mnFile.setText("File");

        mniNewPr.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniNewPr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/power_off.png"))); // NOI18N
        mniNewPr.setText("New Project");
        mnFile.add(mniNewPr);

        jMenuItem2.setText("New File");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnFile.add(jMenuItem2);
        mnFile.add(jSeparator1);

        jMenuItem3.setText("Open Project");
        mnFile.add(jMenuItem3);

        jMenu1.setText("Open Recent Project");

        jMenuItem5.setText("jMenuItem5");
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("jMenuItem6");
        jMenu1.add(jMenuItem6);

        mnFile.add(jMenu1);
        mnFile.add(jSeparator2);

        jMenuItem4.setText("Exit");
        mnFile.add(jMenuItem4);

        mnBar.add(mnFile);

        mnEdit.setText("Edit");
        mnBar.add(mnEdit);

        mnHelp.setText("Help");
        mnBar.add(mnHelp);

        setJMenuBar(mnBar);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btChoose;
    private javax.swing.JButton btReset;
    private javax.swing.JButton btSubmit;
    private javax.swing.ButtonGroup btgGender;
    private javax.swing.JCheckBox cbBadminton;
    private javax.swing.JComboBox cbClass;
    private javax.swing.JCheckBox cbSocer;
    private javax.swing.JCheckBox cbVolleyball;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel lbAvatar;
    private javax.swing.JLabel lbClass;
    private javax.swing.JLabel lbComment;
    private javax.swing.JLabel lbGender;
    private javax.swing.JLabel lbHobbies;
    private javax.swing.JLabel lbLiterature;
    private javax.swing.JLabel lbMath;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbPicture;
    private javax.swing.JLabel lbStudentInfo;
    private javax.swing.JMenuBar mnBar;
    private javax.swing.JMenu mnEdit;
    private javax.swing.JMenu mnFile;
    private javax.swing.JMenu mnHelp;
    private javax.swing.JMenuItem mniNewPr;
    private javax.swing.JPopupMenu pmCenterLeft;
    private javax.swing.JPanel pnDetailLeft;
    private javax.swing.JPanel pnDetailRight;
    private javax.swing.JPanel pnMainBottom;
    private javax.swing.JPanel pnMainCenter;
    private javax.swing.JPanel pnMainTop;
    private javax.swing.JRadioButton rbFemale;
    private javax.swing.JRadioButton rbMale;
    private javax.swing.JRadioButton rbOther;
    private javax.swing.JScrollPane spComment;
    private javax.swing.JSplitPane spMain;
    private javax.swing.JTextArea taComment;
    private javax.swing.JTextField tfLiterature;
    private javax.swing.JTextField tfMath;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables

    private void initDataModel() {
        initCbbGradeModel();
    }

    private void initCbbGradeModel() {
        Grade[] grades = new Grade[listGrades.size()];
        for (int i = 0; i < listGrades.size(); i++) {
            grades[i] = listGrades.get(i);
        }
        ComboBoxModel<Grade> gradeModel = new DefaultComboBoxModel<>(grades);
        cbClass.setModel(gradeModel);
    }

    private void initEvents() {
        btUploadEvents();

        btSubmitEvents();

        btCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                FrAddStudent.this.setVisible(false);
            }
        });

        menuItemsEvents();
    }

    private void btUploadEvents() {
        btChoose.addMouseListener(new MouseAdapter() {
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
//                    String renameFile = System.currentTimeMillis() + fileName;
//                    targetFile = new File("image_upload" + File.separator + renameFile);
//                    try {
//                        Files.copy(sourceFile.toPath(), targetFile.toPath());
//                    } catch (IOException ex) {
//                        Logger.getLogger(FrAddStudent.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    Image image = new ImageIcon(targetFile.getPath())
                    imagePath = path + File.separator + fileName;
                    Image image = new ImageIcon(imagePath).getImage()
                            .getScaledInstance(lbAvatar.getWidth(), lbAvatar.getHeight(), Image.SCALE_SMOOTH);
                    Icon icon = new ImageIcon(image);
                    lbAvatar.setIcon(icon);
                }
            }
        });
    }

    private void btSubmitEvents() {
        btSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String name = tfName.getText();
                Grade grade = (Grade) cbClass.getSelectedItem();
                String gender = getGender();
                String hobbies = getHobbies(cbBadminton, cbSocer, cbVolleyball);
                String math = tfMath.getText();
                String literature = tfLiterature.getText();

                if (checkInfo(name, gender, hobbies, math, literature)) {
                    String id = setId();
                    Float mathScore = Float.parseFloat(math);
                    Float literatureScore = Float.parseFloat(literature);
                    Boolean isGender = gender.equals("Nam");
                    String image = (imagePath != null) ? imagePath : student.getImagePath();

                    if (student.getId() != null) {
                        setInfoStudent(name, grade, isGender, hobbies, mathScore, literatureScore,
                                taComment.getText(), image);
                        System.out.println(service.updateStudent(student));
                        setTableData();
// scroll to the end row
                        tbStudent.scrollRectToVisible(tbStudent.getCellRect(tbStudent.getRowCount() - 1, 0, true));
                        showMessage("Successfully updated!", "Updated", JOptionPane.INFORMATION_MESSAGE);
                        FrAddStudent.this.setVisible(false);
                    } else {
                        if (lbAvatar.getIcon() != null) {
                            StudentRaw studentRaw = new StudentRaw(id, name, grade.getName(), isGender, hobbies, mathScore,
                                    literatureScore, taComment.getText(), imagePath);
                            Student std = new Student(studentRaw, grade);
                            System.out.println(service.addStudent(std));
                            students.add(std);
                            setTableData();
                            tbStudent.scrollRectToVisible(tbStudent.getCellRect(tbStudent.getRowCount() - 1, 0, true));
                            showMessage("Add students successfully!", "Added", JOptionPane.INFORMATION_MESSAGE);
                            FrAddStudent.this.setVisible(false);
                        } else {
                            showMessage("Please enter your complete information!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    showMessage("Please enter your complete information!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void setInfoStudent(String name, Grade grade, boolean gender, String hobbies, Float mathScore, Float literatureScore,
            String text, String fileName) {
        student.setName(name);
        student.setGrade(grade);
        student.setGender(gender);
        student.setBobbies(hobbies);
        student.setMath(mathScore);
        student.setLiterature(literatureScore);
        student.setComment(text);
        student.setImagePath(fileName);
    }

    private boolean checkInfo(String... ts) {
        for (String t : ts) {
            if (t.isEmpty()) {
                return false;
            }
        }
        return true;
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

    private String getHobbies(JCheckBox... checkBoxs) {
        return Arrays.stream(checkBoxs).filter(JCheckBox::isSelected).map(JCheckBox::getText).collect(Collectors.joining(", "));
    }

    private void initComponentsManually() {
        setUndecorated(true);
        setSize(800, 500);
        setLocationRelativeTo(null);
        
        pnDetailLeft.setComponentPopupMenu(pmCenterLeft);

        pnMainCenter.setBorder(borderCenter);
        tfName.setText(student.getName());
        if (student.getGrade() != null) {
            cbClass.setSelectedItem(student.getGrade());
        } else {
            cbClass.setSelectedItem(listGrades.get(0));
        }
        setGender();
        setHobbies();
        if (student.getMath() != null) {
            tfMath.setText(String.valueOf(student.getMath()));
        }
        if (student.getLiterature() != null) {
            tfLiterature.setText(String.valueOf(student.getLiterature()));
        }
        taComment.setText(student.getComment());
        if (student.getImagePath() != null) {
            Image image = new ImageIcon(student.getImagePath()).getImage()
                    .getScaledInstance(160, 140, Image.SCALE_SMOOTH);
            Icon icon = new ImageIcon(image);
            lbAvatar.setIcon(icon);
        }
    }

    private void setHobbies() {
        if (student.getBobbies() != null) {
            Pattern.compile(", ").splitAsStream(student.getBobbies()).forEach(h -> {
                if (h.equals(cbBadminton.getText())) {
                    cbBadminton.setSelected(true);
                } else if (h.equals(cbSocer.getText())) {
                    cbSocer.setSelected(true);
                } else if (h.equals(cbVolleyball.getText())) {
                    cbVolleyball.setSelected(true);
                }
            });
        }
    }

    private void setGender() {
        if (student.getGender() != null) {
            if (student.getGender()) {
                rbMale.setSelected(true);
            } else {
                rbFemale.setSelected(true);
            }
        }
    }

    private void setTableData() {
        StudentTableModel studentTableModel = new StudentTableModel(tbStudent);
        studentTableModel.loadData();
        studentTableModel.cssForTable();
    }

    private void showMessage(String message, String title, int icon) {
        JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION, icon);
    }

    private String setId() {
        int numZeros = 10 / students.size();
        String zero = "sv";
        for (int i = 0; i < numZeros; i++) {
            zero += 0;
        }
        return zero + (students.size() + 1);
    }

    private void menuItemsEvents() {
        mniNewProjectEvents();
    }

    private void mniNewProjectEvents() {
        mniNewPr.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "HI HI HI");
            }
        });
    }
}
