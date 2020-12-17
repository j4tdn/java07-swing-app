/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.bean.Grade;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import model.bean.Student;
import service.GradeService;
import service.GradeServiceImpl;
import service.StudentService;
import service.StudentServiceImpl;
import utils.ImageUtils;
import view.sub.PnStudentForm;

/**
 *
 * @author OS
 */
public class FrStudent extends javax.swing.JFrame {

    private final GradeService gradeService;
    private final StudentService studentService;
    private boolean isEditForm;
    private File targetFile;
    private Student student;
    private StudentTableModel studentTableModel;
    private int row;

    /**
     * Creates new form FrStudent
     * @param studentTableModel
     */
    public FrStudent(StudentTableModel studentTableModel) {
        this(null, studentTableModel, -1);
    }

    public FrStudent(Student student, StudentTableModel studentTableModel, int row) {
        this.student = student;
        this.isEditForm = student != null;
        this.row = row;
        this.studentTableModel = studentTableModel;
        gradeService = new GradeServiceImpl();
        studentService = new StudentServiceImpl();
        initComponents();
        initDataModel();
        initEvents();
        initComponentManually();
    }

    private void showInfoStudent(Student student) {
        if (this.student != null) {
            tfName.setText(student.getFullname());
            cbbGrade.setSelectedItem(student.getGrade());
            setGender(student.getGender());
            setHobbies();
            tfMath.setText(student.getMath() + "");
            tfLiterature.setText(student.getLiterature() + "");
            taComment.setText(student.getComment());
            lbAvatar.setIcon(ImageUtils.getIcon(student.getAvartarPath(), lbAvatar.getWidth(), lbAvatar.getHeight()));
        }
    }

    private void setHobbies() {
        List<String> hobbies = Pattern.compile(", ").splitAsStream(student.getHobbies()).collect(Collectors.toList());
        JCheckBox[] cbHobbies = {cbBadminton, cbFootball, cbBadminton};
        for (JCheckBox checkbox : cbHobbies) {
            if (hobbies.contains(checkbox.getText())) {
                checkbox.setSelected(true);
            }
        }
    }

    private void initComponentManually() {
        setLocationRelativeTo(null);
        showInfoStudent(student);
        pnDetailLeft.setComponentPopupMenu(popupLeft);
    }

    private void setGender(boolean gender) {
        if (gender) {
            rdMale.setSelected(true);
        } else {
            rdFemale.setSelected(true);
        }
    }

    private void initEvents() {
        btUpLoadEvents();
        btSubmitEvents();
        btResetEvent();
        menuItemEvents();
    }
    
    private void menuItemEvents() {
        mniNewProjectEvent();
    }
    
    private void mniNewProjectEvent() {
        mniNewProject.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Menu Item Event");
            }
        });
        
        mniNewProject.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_Y) {
                    JOptionPane.showMessageDialog(null, "Menu Item Event");
                }
            }
        });
    }
    
    
    private void btResetEvent() {
        btReset.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tfName.setText("");
                cbbGrade.setSelectedIndex(-1);
                btgGender.clearSelection();
                cbFootball.setSelected(false);
                cbVolleyball.setSelected(false);
                cbBadminton.setSelected(false);
                tfMath.setText("");
                tfLiterature.setText("");
                taComment.setText("");
                lbAvatar.setIcon(new ImageIcon());
            }            
        });
    }

    private void btSubmitEvents() {
        btSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                 Student newStudent = getStudent();
                if (!isEditForm) {
//                    boolean isSuccess = studentService.save(newStudent);
//                    if (isSuccess) {
//                        JOptionPane.showMessageDialog(null, "Thêm thành công");
//                        setVisible(false);
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Thêm thất bại");
//                    }
                    studentTableModel.save(newStudent);
                    setVisible(false);
                } else {
//                    Student newStudent = getStudent();
//                    System.out.println(newStudent.getFullname());
//                    boolean isSuccess = studentService.update(newStudent);
//
//                    if (isSuccess) {
//                        JOptionPane.showMessageDialog(null, "Cập nhật thành công");
//                        setVisible(false);
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
//                    }
                    studentTableModel.update(newStudent, row);
                    setVisible(false);
                }
            }
        });
    }

    private Student getStudent() {
        Student newStudent = new Student();
        Grade grade = (Grade) cbbGrade.getSelectedItem();
        Boolean gender = rdMale.isSelected();
        String hobbies = getHobbies(cbBadminton, cbFootball, cbVolleyball);
        String fileName = targetFile != null ? targetFile.getName() : "Undefined";
        String name = tfName.getText();
        Double math = Double.parseDouble(tfMath.getText());
        Double literature = Double.parseDouble(tfLiterature.getText());
        String comment = taComment.getText();
        
        if (student != null) {
            newStudent.setId(student.getId());
        }
        newStudent.setFullname(name);
        newStudent.setGrade(grade);
        newStudent.setGender(gender);
        newStudent.setHobbies(hobbies);
        newStudent.setMath(math);
        newStudent.setLiterature(literature);
        newStudent.setComment(comment);
        newStudent.setAvartarPath(fileName);
        return newStudent;
    }

    private String getHobbies(JCheckBox... checkBoxs) {
        return Arrays.stream(checkBoxs)
                .filter(JCheckBox::isSelected)
                .map(JCheckBox::getText)
                .collect(Collectors.joining(", "));
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

    private void btUpLoadEvents() {
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
                    targetFile = new File("image_upload/" + File.separator + renamedFile);
                    try {
                        //step1: copy & rename to project's file upload
                        Files.copy(sourceFile.toPath(), targetFile.toPath());
                    } catch (IOException ex) {
                        Logger.getLogger(PnStudentForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //step2: display renamed file on UI
                    Image image = new ImageIcon(targetFile.toString()).getImage().getScaledInstance(lbAvatar.getWidth(), lbAvatar.getHeight(), Image.SCALE_SMOOTH);
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
        Grade[] grades = {
            new Grade(1, "17T1"),
            new Grade(2, "17T2"),
            new Grade(3, "17T3")
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
        popupLeft = new javax.swing.JPopupMenu();
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
        lbHodbies = new javax.swing.JLabel();
        rdMale = new javax.swing.JRadioButton();
        rdFemale = new javax.swing.JRadioButton();
        cbFootball = new javax.swing.JCheckBox();
        cbVolleyball = new javax.swing.JCheckBox();
        cbBadminton = new javax.swing.JCheckBox();
        pnDetailRight = new javax.swing.JPanel();
        lbMath = new javax.swing.JLabel();
        tfMath = new javax.swing.JTextField();
        lbLiterature = new javax.swing.JLabel();
        tfLiterature = new javax.swing.JTextField();
        lbCommnent = new javax.swing.JLabel();
        scrollComment = new javax.swing.JScrollPane();
        taComment = new javax.swing.JTextArea();
        lbImage = new javax.swing.JLabel();
        lbAvatar = new javax.swing.JLabel();
        btUpload = new javax.swing.JButton();
        mnBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mniNewProject = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        mniLeftFirst.setText("jMenuItem1");
        popupLeft.add(mniLeftFirst);

        mniLeftSecond.setText("jMenuItem1");
        popupLeft.add(mniLeftSecond);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/student.png"))); // NOI18N
        jLabel1.setText("THÔNG TIN HỌC VIÊN");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pnMainTop.add(jLabel1);

        getContentPane().add(pnMainTop, java.awt.BorderLayout.PAGE_START);

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

        pnMainCenter.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thông tin chi tiết", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(0, 51, 153))); // NOI18N
        pnMainCenter.setLayout(new java.awt.BorderLayout());

        pnDetailLeft.setBackground(new java.awt.Color(153, 255, 255));
        pnDetailLeft.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

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

        cbbGrade.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lbGender.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbGender.setText("Giới tính:");

        lbHodbies.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbHodbies.setText("Sở thích:");

        btgGender.add(rdMale);
        rdMale.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
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
        cbBadminton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBadmintonActionPerformed(evt);
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
                    .addComponent(lbHodbies))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnDetailLeftLayout.createSequentialGroup()
                        .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnDetailLeftLayout.createSequentialGroup()
                                .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdMale)
                                    .addComponent(cbFootball))
                                .addGap(30, 30, 30)
                                .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbVolleyball)
                                    .addComponent(rdFemale))
                                .addGap(30, 30, 30)
                                .addComponent(cbBadminton)))
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
                    .addComponent(cbbGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbGender)
                    .addComponent(rdMale)
                    .addComponent(rdFemale))
                .addGap(29, 29, 29)
                .addGroup(pnDetailLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbHodbies)
                    .addComponent(cbFootball)
                    .addComponent(cbVolleyball)
                    .addComponent(cbBadminton))
                .addContainerGap(205, Short.MAX_VALUE))
        );

        sppDetailInfo.setLeftComponent(pnDetailLeft);

        pnDetailRight.setBackground(new java.awt.Color(255, 255, 204));

        lbMath.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbMath.setText("Điểm toán:");

        tfMath.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfMath.setMinimumSize(new java.awt.Dimension(7, 32));
        tfMath.setPreferredSize(new java.awt.Dimension(7, 32));
        tfMath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMathActionPerformed(evt);
            }
        });

        lbLiterature.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbLiterature.setText("Điểm văn:");

        tfLiterature.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfLiterature.setMinimumSize(new java.awt.Dimension(7, 32));
        tfLiterature.setPreferredSize(new java.awt.Dimension(7, 32));

        lbCommnent.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbCommnent.setText("Nhận xét:");

        taComment.setColumns(20);
        taComment.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        taComment.setLineWrap(true);
        taComment.setRows(5);
        taComment.setTabSize(4);
        taComment.setWrapStyleWord(true);
        scrollComment.setViewportView(taComment);

        lbImage.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbImage.setText("Hình ảnh");

        lbAvatar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 203, 0), 2));

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
                    .addComponent(lbCommnent)
                    .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lbImage)
                        .addComponent(lbLiterature)))
                .addGap(18, 18, 18)
                .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfLiterature, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfMath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollComment, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pnDetailRightLayout.createSequentialGroup()
                        .addComponent(lbAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(30, 30, 30)
                .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCommnent)
                    .addComponent(scrollComment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnDetailRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbImage)
                    .addComponent(btUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sppDetailInfo.setRightComponent(pnDetailRight);

        pnMainCenter.add(sppDetailInfo, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnMainCenter, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");

        mniNewProject.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniNewProject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/power_off.png"))); // NOI18N
        mniNewProject.setText("New Project");
        mniNewProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniNewProjectActionPerformed(evt);
            }
        });
        jMenu1.add(mniNewProject);

        jMenuItem3.setText("New File");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);
        jMenu1.add(jSeparator1);

        jMenu5.setText("Open Recent");

        jMenuItem4.setText("Open Project");
        jMenu5.add(jMenuItem4);

        jMenuItem5.setText("Open Folder");
        jMenu5.add(jMenuItem5);

        jMenu1.add(jMenu5);

        jMenuItem6.setText("Option");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        mnBar.add(jMenu1);

        jMenu2.setText("Edit");
        mnBar.add(jMenu2);

        jMenu3.setText("View");
        mnBar.add(jMenu3);

        jMenu4.setText("Source");
        mnBar.add(jMenu4);

        setJMenuBar(mnBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSubmitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSubmitActionPerformed

    private void btResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btResetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btResetActionPerformed

    private void tfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNameActionPerformed

    private void rdMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdMaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdMaleActionPerformed

    private void rdFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdFemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdFemaleActionPerformed

    private void cbVolleyballActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbVolleyballActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbVolleyballActionPerformed

    private void tfMathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMathActionPerformed

    private void cbBadmintonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBadmintonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbBadmintonActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void mniNewProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniNewProjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mniNewProjectActionPerformed

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
            java.util.logging.Logger.getLogger(FrStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lbAvatar;
    private javax.swing.JLabel lbCommnent;
    private javax.swing.JLabel lbGender;
    private javax.swing.JLabel lbGrade;
    private javax.swing.JLabel lbHodbies;
    private javax.swing.JLabel lbImage;
    private javax.swing.JLabel lbLiterature;
    private javax.swing.JLabel lbMath;
    private javax.swing.JLabel lbName;
    private javax.swing.JMenuBar mnBar;
    private javax.swing.JMenuItem mniLeftFirst;
    private javax.swing.JMenuItem mniLeftSecond;
    private javax.swing.JMenuItem mniNewProject;
    private javax.swing.JPanel pnDetailLeft;
    private javax.swing.JPanel pnDetailRight;
    private javax.swing.JPanel pnMainBottom;
    private javax.swing.JPanel pnMainCenter;
    private javax.swing.JPanel pnMainTop;
    private javax.swing.JPopupMenu popupLeft;
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
