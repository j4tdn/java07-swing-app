/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.StudentTableModel;
import model.bean.Grade;
import model.bean.Student;
import service.GradeService;
import service.GradeServiceImpl;
import service.StudentService;
import service.StudentServiceImpl;
import utils.ImageUtils;

/**
 *
 * @author USER
 */
public class FrStudentForm extends javax.swing.JFrame {

    private final GradeService gradeService;

    private final StudentService studentService;

    private File targetFile;

    private Student student;

    private boolean isEditForm;

    private StudentTableModel studentModel;

    /**
     * Creates new form frStudentForm
     * @param studentModel
     */
    public FrStudentForm(StudentTableModel studentModel) {
        this(null, studentModel);
    }

    public FrStudentForm(Student student, StudentTableModel studentModel) {
        this.student = student;
        this.studentModel = studentModel;
        isEditForm = student != null;
        gradeService = new GradeServiceImpl();
        studentService = new StudentServiceImpl();

        initComponents();
        initDataModel();
        initComponentManually();
        initEvents();
    }

    private void initEvents() {
        btUploadEvents();
        btSubmitEvents();
        btResetEvent();
    }

    private void btSubmitEvents() {
        btSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                boolean isSuccess;

                if (isEditForm) {
                    getInfo(student, isEditForm);

                    isSuccess = studentService.update(student);

                    if (isSuccess) {
                        int idOfUpdatedStudent = student.getId();
                        JOptionPane.showMessageDialog(null, "Sửa thành công!!!");
                        setVisible(false);
                        studentModel.refreshUpdate(student, idOfUpdatedStudent);
                    } else {
                        JOptionPane.showMessageDialog(null, "Sửa thất bại!!!");
                    }
                } else {
                    Student newStudent = new Student();
                    getInfo(newStudent, isEditForm);

                    isSuccess = studentService.save(newStudent);

                    if (isSuccess) {
                        JOptionPane.showMessageDialog(null, "Thêm thành công!!!");
                        setVisible(false);
                        studentModel.refreshAdd(newStudent);
                    } else {
                        JOptionPane.showMessageDialog(null, "Thêm thất bại!!!");
                    }
                }
            }
        });
    }

    private void getInfo(Student student, boolean isEditForm) {
        String fullname = tfName.getText();
        Grade grade = (Grade) cbGrade.getSelectedItem();
        Boolean gender = rdMale.isSelected();
        String hobbies = getHobbies(cbBasketball, cbFootball, cbSmileball);
        Double math = Double.parseDouble(tfMath.getText());
        Double literature = Double.parseDouble(tfLiterature.getText());
        String comment = taComment.getText();
        String filename;

        student.setFullname(fullname);
        student.setGrade(grade);
        student.setGender(gender);
        student.setHobbies(hobbies);
        student.setMath(math);
        student.setLiterature(literature);
        student.setComment(comment);

        if (isEditForm) {
            String[] stringArrayOfFilename = student.getAvatarPath().split("\\\\");
            String newFileName = targetFile != null ? targetFile.getName() : "Undefined";
            String oldFileName = stringArrayOfFilename[1];
            filename = changeUploadFile(student, oldFileName, newFileName);
        } else {
            filename = targetFile != null ? targetFile.getName() : "Undefined";
        }

        student.setAvatarPath(filename);
    }

    private String changeUploadFile(Student student, String oldFileName, String newFileName) {
        String[] stringArrayOfFilename = student.getAvatarPath().split("\\\\");
        oldFileName = stringArrayOfFilename[1];
        newFileName = targetFile != null ? targetFile.getName() : "Undefined";

        if (newFileName.equals("Undefined")) {
            return oldFileName;
        }

        return newFileName;
    }

    private String getHobbies(JCheckBox... checkBoxs) {
        return Arrays.stream(checkBoxs)
                .filter(JCheckBox::isSelected)
                .map(JCheckBox::getText)
                .collect(Collectors.joining(", "));
    }

    private void btResetEvent() {
        btReset.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tfName.setText("");
                cbGrade.setSelectedIndex(-1);
                btgGender.clearSelection();
                cbFootball.setSelected(false);
                cbSmileball.setSelected(false);
                cbBasketball.setSelected(false);
                tfMath.setText("");
                tfLiterature.setText("");
                taComment.setText("");
                lbAvatar.setIcon(new ImageIcon());
            }

        });
    }

    private void btUploadEvents() {
        btUpload.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String path = getClass().getResource("/images.ghost").getFile();
                JFileChooser fc = new JFileChooser(path);
                if (JFileChooser.APPROVE_OPTION == fc.showDialog(null, "Upload")) {
                    File sourceFile = fc.getSelectedFile();
                    String fileName = sourceFile.getName();

                    String regex = "[\\w-]+[.]{1}(?)(?:png|jpg|jpeg|gif)";
                    if (!fileName.matches(regex)) {
                        JOptionPane.showMessageDialog(null, "Invalid image path!");
                        return;
                    }
                    String renamedFile = System.currentTimeMillis() + fileName;

                    targetFile = new File("image_upload" + File.separator + renamedFile);
                    try {
                        // Step 1: Copy & rename to project's file upload
                        Files.copy(sourceFile.toPath(), targetFile.toPath());
                    } catch (IOException ex) {
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

    private void initDataModel() {
        initCbbGradeModel();
    }

    private void initCbbGradeModel() {
        List<Grade> grades = gradeService.getAll();
        Grade[] gradesArray = grades.stream().toArray(Grade[]::new);
        ComboBoxModel<Grade> gradeModel = new DefaultComboBoxModel<>(gradesArray);
        cbGrade.setModel(gradeModel);
        cbGrade.setSelectedIndex(-1);
    }

    private void initComponentManually() {
        setLocationRelativeTo(null);

        showStudentInfo();
    }

    private void showStudentInfo() {
        if (student != null) {
            tfName.setText(student.getFullname());
            cbGrade.setSelectedItem(student.getGrade());
            setGender();
            setHobbies();
            tfMath.setText(student.getMath().toString());
            tfLiterature.setText(student.getLiterature().toString());
            taComment.setText(student.getComment());
            lbAvatar.setIcon(ImageUtils.getIcon(student.getAvatarPath(), lbAvatar.getWidth(), lbAvatar.getHeight()));
        }
    }

    private void setGender() {
        if (student.getGender()) {
            rdMale.setSelected(true);
        } else {
            rdFemale.setSelected(true);
        }
    }

    private void setHobbies() {
        List<String> hobbies = Pattern.compile(", ").splitAsStream(student.getHobbies()).collect(Collectors.toList());
        JCheckBox[] cbHobbies = {cbBasketball, cbFootball, cbSmileball};
        for (JCheckBox checkbox : cbHobbies) {
            if (hobbies.contains(checkbox.getText())) {
                checkbox.setSelected(true);
            }
        }
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
        pnMainCenter = new javax.swing.JPanel();
        sppDetailInfo = new javax.swing.JSplitPane();
        pnDetailLeft = new javax.swing.JPanel();
        lbName = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        lbGrade = new javax.swing.JLabel();
        cbGrade = new javax.swing.JComboBox();
        lbGender = new javax.swing.JLabel();
        lbHobbies = new javax.swing.JLabel();
        rdMale = new javax.swing.JRadioButton();
        rdFemale = new javax.swing.JRadioButton();
        rdAnother = new javax.swing.JRadioButton();
        cbFootball = new javax.swing.JCheckBox();
        cbSmileball = new javax.swing.JCheckBox();
        cbBasketball = new javax.swing.JCheckBox();
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
        pnMainBottom = new javax.swing.JPanel();
        btSubmit = new javax.swing.JButton();
        btReset = new javax.swing.JButton();
        pnMainTop = new javax.swing.JPanel();
        lbStudentInfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnMainCenter.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thông tin chi tiết", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(102, 0, 102))); // NOI18N
        pnMainCenter.setLayout(new java.awt.BorderLayout());

        pnDetailLeft.setBackground(new java.awt.Color(153, 255, 255));

        lbName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbName.setText("Họ tên:");

        tfName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfName.setPreferredSize(new java.awt.Dimension(7, 32));
        tfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNameActionPerformed(evt);
            }
        });

        lbGrade.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbGrade.setText("Lớp:");

        cbGrade.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lbGender.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbGender.setText("Giới tính:");

        lbHobbies.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbHobbies.setText("Sở thích:");

        btgGender.add(rdMale);
        rdMale.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rdMale.setText("Nam");
        rdMale.setFocusPainted(false);
        rdMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdMaleActionPerformed(evt);
            }
        });

        btgGender.add(rdFemale);
        rdFemale.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rdFemale.setText("Nữ");
        rdFemale.setFocusPainted(false);
        rdFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdFemaleActionPerformed(evt);
            }
        });

        btgGender.add(rdAnother);
        rdAnother.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rdAnother.setText("Khác");
        rdAnother.setFocusPainted(false);
        rdAnother.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdAnotherActionPerformed(evt);
            }
        });

        cbFootball.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbFootball.setText("Bóng đá");
        cbFootball.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFootballActionPerformed(evt);
            }
        });

        cbSmileball.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbSmileball.setText("Bóng cười");
        cbSmileball.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSmileballActionPerformed(evt);
            }
        });

        cbBasketball.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbBasketball.setText("Bóng rổ");
        cbBasketball.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBasketballActionPerformed(evt);
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
                .addGap(30, 30, 30)
                .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDetailLeftLayout.createSequentialGroup()
                        .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdMale)
                            .addComponent(cbFootball))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdFemale)
                            .addComponent(cbSmileball))
                        .addGap(9, 9, 9)
                        .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdAnother)
                            .addComponent(cbBasketball)))
                    .addComponent(tfName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnDetailLeftLayout.createSequentialGroup()
                        .addComponent(cbGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                    .addComponent(cbGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbGender)
                    .addComponent(rdMale)
                    .addComponent(rdFemale)
                    .addComponent(rdAnother))
                .addGap(30, 30, 30)
                .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbHobbies)
                    .addComponent(cbFootball)
                    .addComponent(cbSmileball)
                    .addComponent(cbBasketball))
                .addContainerGap(211, Short.MAX_VALUE))
        );

        sppDetailInfo.setLeftComponent(pnDetailLeft);

        pnDetailRight.setBackground(new java.awt.Color(255, 255, 204));

        lbMath.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbMath.setText("Điểm toán:");

        tfMath.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfMath.setPreferredSize(new java.awt.Dimension(7, 32));
        tfMath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMathActionPerformed(evt);
            }
        });

        lbLiterature.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbLiterature.setText("Điểm văn:");

        tfLiterature.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfLiterature.setPreferredSize(new java.awt.Dimension(7, 32));
        tfLiterature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLiteratureActionPerformed(evt);
            }
        });

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

        lbAvatar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 51), 2));

        btUpload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/upload.png"))); // NOI18N
        btUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUploadActionPerformed(evt);
            }
        });

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
                    .addComponent(tfLiterature, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollComment, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                    .addGroup(pnDetailRightLayout.createSequentialGroup()
                        .addComponent(lbAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(35, 35, 35)
                .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbComment)
                    .addComponent(scrollComment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbImage)
                    .addComponent(lbAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        sppDetailInfo.setRightComponent(pnDetailRight);

        pnMainCenter.add(sppDetailInfo, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnMainCenter, java.awt.BorderLayout.CENTER);

        pnMainBottom.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 10));

        btSubmit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btSubmit.setText("Submit");
        btSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSubmitActionPerformed(evt);
            }
        });
        pnMainBottom.add(btSubmit);

        btReset.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btReset.setText("Reset");
        btReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btResetActionPerformed(evt);
            }
        });
        pnMainBottom.add(btReset);

        getContentPane().add(pnMainBottom, java.awt.BorderLayout.PAGE_END);

        lbStudentInfo.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lbStudentInfo.setForeground(new java.awt.Color(102, 0, 102));
        lbStudentInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/student.png"))); // NOI18N
        lbStudentInfo.setText("THÔNG TIN HỌC VIÊN");
        lbStudentInfo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbStudentInfo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pnMainTop.add(lbStudentInfo);

        getContentPane().add(pnMainTop, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNameActionPerformed

    private void rdMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdMaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdMaleActionPerformed

    private void rdFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdFemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdFemaleActionPerformed

    private void rdAnotherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdAnotherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdAnotherActionPerformed

    private void cbFootballActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFootballActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFootballActionPerformed

    private void cbSmileballActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSmileballActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSmileballActionPerformed

    private void cbBasketballActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBasketballActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbBasketballActionPerformed

    private void tfMathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMathActionPerformed

    private void tfLiteratureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfLiteratureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLiteratureActionPerformed

    private void btUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUploadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btUploadActionPerformed

    private void btSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSubmitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSubmitActionPerformed

    private void btResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btResetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btResetActionPerformed

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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btReset;
    private javax.swing.JButton btSubmit;
    private javax.swing.JButton btUpload;
    private javax.swing.ButtonGroup btgGender;
    private javax.swing.JCheckBox cbBasketball;
    private javax.swing.JCheckBox cbFootball;
    private javax.swing.JComboBox cbGrade;
    private javax.swing.JCheckBox cbSmileball;
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
    private javax.swing.JRadioButton rdAnother;
    private javax.swing.JRadioButton rdFemale;
    private javax.swing.JRadioButton rdMale;
    private javax.swing.JScrollPane scrollComment;
    private javax.swing.JSplitPane sppDetailInfo;
    private javax.swing.JTextArea taComment;
    private javax.swing.JTextField tfLiterature;
    private javax.swing.JTextField tfMath;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables
}
