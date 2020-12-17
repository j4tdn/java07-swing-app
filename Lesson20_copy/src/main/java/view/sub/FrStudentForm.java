/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub;

import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
import model.StudentTableModel;
import model.bean.Grade;
import model.bean.Student;
import utils.ImageUtils;
import service.StudentService;
import service.StudentServiceImpl;
/**
 *
 * @author ADMIN
 */
public class FrStudentForm extends javax.swing.JFrame {
    private boolean isEditForm;
    private int selectedRow;
    private StudentTableModel studentModel;
    private File targetFile;
    private Student student;
    private int selectedRows = -1;
            
    private final StudentService studentService= new StudentServiceImpl();

    /**
     * Creates new form FrStudentForm
     * @param studentModel student model
     */
    public FrStudentForm(StudentTableModel studentModel) {
        this(null,studentModel,-1);
    }

    public FrStudentForm(Student student,StudentTableModel studentModel,int selectedRow) {
        this.student = student;
        this.studentModel=studentModel;
    
        isEditForm = student != null;
        System.out.println(isEditForm);
        initComponents();
        initComponentsManually();
        initDataModel();
        initEvents();
        showStudentInfo();
    }

    private void initComponentsManually() {
        setLocationRelativeTo(null);
        pnDetailLeft.setComponentPopupMenu(puLeft);
    }

    private void showStudentInfo() {
        if (student != null) {
            tfName.setText(student.getFullname());
            cbbGrade.setSelectedItem(student.getGrade());
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
            rbMale.setSelected(true);
        } else {
            rbFemale.setSelected(true);
        }
    }

    private void setHobbies() {
        List<String> hobbies = Pattern.compile(", ").splitAsStream(student.getHobbies()).collect(Collectors.toList());
        JCheckBox[] cbHobbies = {cbBadminton, cbFootball, cbVolleyball};
        for (JCheckBox cbHobby : cbHobbies) {
            if (hobbies.contains(cbHobby.getText())) {
                cbHobby.setSelected(true);
            }
        }
    }

    private void initDataModel() {
        initCbbGradeModel();
    }

    private void initEvents() {
        btUploadEvent();
        btSubmit();
        menuItemEvents();
    }
    
    private void menuItemEvents() {
        mniNewProjectEvent();
    }

    private void mniNewProjectEvent() {
        mniNewProject.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Menu item events");
            }
            
        });
        mniNewProject.addKeyListener(new KeyAdapter() {
            
        });
    }
    
    private void btSubmit() {
        btSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String name = tfName.getText();
                Grade grade = (Grade) cbbGrade.getSelectedItem();
                int gender = ("Nam".equals(getGender()))?1:0;
                String hobbies = getHobbies(cbBadminton, cbVolleyball, cbFootball);
                String fileName = targetFile != null ? targetFile.getName() : "Undefined!";
                String comment = taComment.getText();
                Double math = Double.parseDouble(tfMath.getText());
                Double literature = Double.parseDouble(tfLiterature.getText());
                Student student=new Student(name, fileName, isEditForm, hobbies, math, literature, grade, comment, comment);
                if (isEditForm) {
                    if (studentService.updateStudent(student)) {
                        FrStudentForm.this.setVisible(false);
                        Student updatedStudent=new Student(student.getId(), name, (gender==1)?true:false, hobbies, math, literature, grade, fileName, comment);
                        studentModel.update(updatedStudent,selectedRow);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter all the information!", "Message", JOptionPane.PLAIN_MESSAGE);
                    }
                } else {
                    if (studentService.addStudent(student)!=0) {
                        FrStudentForm.this.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter all the information!", "Message", JOptionPane.PLAIN_MESSAGE);
                    }
                }
            }
        });
    }
    
    private String getGender() {
        Enumeration<AbstractButton> elements = btgGenger.getElements();
        while (elements.hasMoreElements()) {
            AbstractButton button = elements.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return "";
    }

    private String getHobbies(JCheckBox... checkBoxes) {
        // Immutable: String literal, object
        // Mutable: StringBuilder, StringBuffer
        // StringBuilder builder = new StringBuilder();
        return Arrays.stream(checkBoxes).filter(JCheckBox::isSelected).map(JCheckBox::getText).collect(Collectors.joining(", "));
    }

    private void btUploadEvent() {
        btUpload.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
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
                    targetFile = new File("images_upload" + File.separator + renamedFile);

                    // Step1: Copy & rename to project's file upload
                    try {
                        Files.copy(sourceFile.toPath(), targetFile.toPath());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    //Step2: Display renamed file on UI
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
            new Grade(4, "Lớp 14T4")
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

        btgGenger = new javax.swing.ButtonGroup();
        puLeft = new javax.swing.JPopupMenu();
        mniLeftFirst = new javax.swing.JMenuItem();
        mniLeftSecond = new javax.swing.JMenuItem();
        pnMainTop = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
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
        rbMale = new javax.swing.JRadioButton();
        rbFemale = new javax.swing.JRadioButton();
        rbDifferent = new javax.swing.JRadioButton();
        cbFootball = new javax.swing.JCheckBox();
        cbVolleyball = new javax.swing.JCheckBox();
        cbBadminton = new javax.swing.JCheckBox();
        pnDetailRight = new javax.swing.JPanel();
        lbMath = new javax.swing.JLabel();
        lbLiterature = new javax.swing.JLabel();
        lbComment = new javax.swing.JLabel();
        tfMath = new javax.swing.JTextField();
        tfLiterature = new javax.swing.JTextField();
        scpComment = new javax.swing.JScrollPane();
        taComment = new javax.swing.JTextArea();
        lbImage = new javax.swing.JLabel();
        lbAvatar = new javax.swing.JLabel();
        btUpload = new javax.swing.JButton();
        mnBar = new javax.swing.JMenuBar();
        mnFile = new javax.swing.JMenu();
        mniNewProject = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        mnEdit = new javax.swing.JMenu();
        mnEdit1 = new javax.swing.JMenu();
        mnEdit2 = new javax.swing.JMenu();
        mnEdit3 = new javax.swing.JMenu();

        mniLeftFirst.setText("jMenuItem1");
        puLeft.add(mniLeftFirst);

        mniLeftSecond.setText("jMenuItem1");
        puLeft.add(mniLeftSecond);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/student.png"))); // NOI18N
        jLabel1.setText("THÔNG TIN HỌC VIÊN");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pnMainTop.add(jLabel1);

        getContentPane().add(pnMainTop, java.awt.BorderLayout.PAGE_START);

        pnMainBottom.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 10));

        btSubmit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btSubmit.setText("Submit");
        btSubmit.setFocusPainted(false);
        pnMainBottom.add(btSubmit);

        btReset.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btReset.setText("Reset");
        btReset.setFocusPainted(false);
        pnMainBottom.add(btReset);

        getContentPane().add(pnMainBottom, java.awt.BorderLayout.PAGE_END);

        pnMainCenter.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thông tin chi tiết", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 0, 153))); // NOI18N
        pnMainCenter.setLayout(new java.awt.BorderLayout());

        pnDetailLeft.setBackground(new java.awt.Color(204, 255, 255));

        lbName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbName.setText("Họ tên: ");

        tfName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfName.setPreferredSize(new java.awt.Dimension(7, 32));
        tfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNameActionPerformed(evt);
            }
        });

        lbGrade.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbGrade.setText("Lớp: ");

        cbbGrade.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lbGender.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbGender.setText("Giới tính: ");

        lbHobbies.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbHobbies.setText("Sở thích: ");

        btgGenger.add(rbMale);
        rbMale.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbMale.setText("Nam");
        rbMale.setContentAreaFilled(false);
        rbMale.setFocusPainted(false);

        btgGenger.add(rbFemale);
        rbFemale.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbFemale.setText("Nữ");
        rbFemale.setContentAreaFilled(false);
        rbFemale.setFocusPainted(false);
        rbFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFemaleActionPerformed(evt);
            }
        });

        btgGenger.add(rbDifferent);
        rbDifferent.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbDifferent.setText("Khác");
        rbDifferent.setContentAreaFilled(false);
        rbDifferent.setFocusPainted(false);

        cbFootball.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbFootball.setText("Bóng đá");
        cbFootball.setContentAreaFilled(false);
        cbFootball.setFocusPainted(false);

        cbVolleyball.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbVolleyball.setText("Bóng chuyền");
        cbVolleyball.setContentAreaFilled(false);
        cbVolleyball.setFocusPainted(false);
        cbVolleyball.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbVolleyballActionPerformed(evt);
            }
        });

        cbBadminton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbBadminton.setText("Cầu lông");
        cbBadminton.setContentAreaFilled(false);
        cbBadminton.setFocusPainted(false);

        javax.swing.GroupLayout pnDetailLeftLayout = new javax.swing.GroupLayout(pnDetailLeft);
        pnDetailLeft.setLayout(pnDetailLeftLayout);
        pnDetailLeftLayout.setHorizontalGroup(
            pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetailLeftLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(tfName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(pnDetailLeftLayout.createSequentialGroup()
                .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDetailLeftLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbName)
                            .addComponent(lbGrade)
                            .addComponent(lbGender)
                            .addComponent(lbHobbies))
                        .addGap(18, 18, 18)
                        .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbMale)
                            .addComponent(cbFootball))
                        .addGap(40, 40, 40)
                        .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbFemale)
                            .addComponent(cbVolleyball))
                        .addGap(40, 40, 40)
                        .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbDifferent)
                            .addComponent(cbBadminton)))
                    .addGroup(pnDetailLeftLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(cbbGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(rbMale)
                    .addComponent(rbFemale)
                    .addComponent(rbDifferent))
                .addGap(30, 30, 30)
                .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbHobbies)
                    .addComponent(cbFootball)
                    .addComponent(cbVolleyball)
                    .addComponent(cbBadminton))
                .addContainerGap(206, Short.MAX_VALUE))
        );

        sppDetailInfo.setLeftComponent(pnDetailLeft);

        pnDetailRight.setBackground(new java.awt.Color(255, 255, 204));

        lbMath.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbMath.setText("Điểm Toán:");

        lbLiterature.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbLiterature.setText("Điểm Văn:");

        lbComment.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbComment.setText("Nhận xét:");

        tfMath.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfMath.setPreferredSize(new java.awt.Dimension(7, 32));
        tfMath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMathActionPerformed(evt);
            }
        });

        tfLiterature.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfLiterature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLiteratureActionPerformed(evt);
            }
        });

        taComment.setColumns(20);
        taComment.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        taComment.setLineWrap(true);
        taComment.setRows(5);
        taComment.setTabSize(4);
        taComment.setWrapStyleWord(true);
        scpComment.setViewportView(taComment);

        lbImage.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbImage.setText("Hình ảnh:");

        lbAvatar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 51), 2));

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
                    .addGroup(pnDetailRightLayout.createSequentialGroup()
                        .addComponent(lbAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tfMath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfLiterature, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scpComment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
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
                .addGap(30, 30, 30)
                .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbComment)
                    .addComponent(scpComment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnDetailRightLayout.createSequentialGroup()
                        .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbImage)
                            .addComponent(btUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 121, Short.MAX_VALUE)))
                .addContainerGap())
        );

        sppDetailInfo.setRightComponent(pnDetailRight);

        pnMainCenter.add(sppDetailInfo, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnMainCenter, java.awt.BorderLayout.CENTER);

        mnFile.setText("File");

        mniNewProject.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniNewProject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/power_off.png"))); // NOI18N
        mniNewProject.setText("New Project");
        mniNewProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniNewProjectActionPerformed(evt);
            }
        });
        mnFile.add(mniNewProject);

        jMenuItem2.setText("New File");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnFile.add(jMenuItem2);
        mnFile.add(jSeparator1);

        jMenuItem3.setText("Open Project");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        mnFile.add(jMenuItem3);

        jMenu1.setText("Open Recent Project");

        jMenuItem7.setText("Lesson16");
        jMenu1.add(jMenuItem7);

        jMenuItem6.setText("Lesson17");
        jMenu1.add(jMenuItem6);

        mnFile.add(jMenu1);
        mnFile.add(jSeparator2);

        jMenuItem4.setText("Close Project");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        mnFile.add(jMenuItem4);

        mnBar.add(mnFile);

        mnEdit.setText("Edit");
        mnBar.add(mnEdit);

        mnEdit1.setText("View");
        mnBar.add(mnEdit1);

        mnEdit2.setText("Source");
        mnBar.add(mnEdit2);

        mnEdit3.setText("Navigate");
        mnBar.add(mnEdit3);

        setJMenuBar(mnBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNameActionPerformed

    private void rbFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbFemaleActionPerformed

    private void cbVolleyballActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbVolleyballActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbVolleyballActionPerformed

    private void tfMathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMathActionPerformed

    private void tfLiteratureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfLiteratureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLiteratureActionPerformed

    private void mniNewProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniNewProjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mniNewProjectActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

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
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btReset;
    private javax.swing.JButton btSubmit;
    private javax.swing.JButton btUpload;
    private javax.swing.ButtonGroup btgGenger;
    private javax.swing.JCheckBox cbBadminton;
    private javax.swing.JCheckBox cbFootball;
    private javax.swing.JCheckBox cbVolleyball;
    private javax.swing.JComboBox cbbGrade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbAvatar;
    private javax.swing.JLabel lbComment;
    private javax.swing.JLabel lbGender;
    private javax.swing.JLabel lbGrade;
    private javax.swing.JLabel lbHobbies;
    private javax.swing.JLabel lbImage;
    private javax.swing.JLabel lbLiterature;
    private javax.swing.JLabel lbMath;
    private javax.swing.JLabel lbName;
    private javax.swing.JMenuBar mnBar;
    private javax.swing.JMenu mnEdit;
    private javax.swing.JMenu mnEdit1;
    private javax.swing.JMenu mnEdit2;
    private javax.swing.JMenu mnEdit3;
    private javax.swing.JMenu mnFile;
    private javax.swing.JMenuItem mniLeftFirst;
    private javax.swing.JMenuItem mniLeftSecond;
    private javax.swing.JMenuItem mniNewProject;
    private javax.swing.JPanel pnDetailLeft;
    private javax.swing.JPanel pnDetailRight;
    private javax.swing.JPanel pnMainBottom;
    private javax.swing.JPanel pnMainCenter;
    private javax.swing.JPanel pnMainTop;
    private javax.swing.JPopupMenu puLeft;
    private javax.swing.JRadioButton rbDifferent;
    private javax.swing.JRadioButton rbFemale;
    private javax.swing.JRadioButton rbMale;
    private javax.swing.JScrollPane scpComment;
    private javax.swing.JSplitPane sppDetailInfo;
    private javax.swing.JTextArea taComment;
    private javax.swing.JTextField tfLiterature;
    private javax.swing.JTextField tfMath;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables

    
}
