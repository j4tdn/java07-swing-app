/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.RowFilter;
import javax.swing.WindowConstants;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.StudentTableModel;
import model.bean.Student;
import service.StudentService;
import service.StudentServiceImpl;
import utils.ImageUtils;

/**
 *
 * @author ADMIN
 */
public class PnStudent extends javax.swing.JPanel {

    /**
     * Creates new form PnStudent
     */
    private final StudentService studentService;
    private Student selectedStudent;
    private StudentTableModel studentModel;
    private int selectedRow;
    
    public PnStudent() {
        studentService = new StudentServiceImpl();
        initComponents();
        initDataModel();
        initEvents();
    }

    private void initDataModel() {
        initTableStudentModel();
    }

    private void initTableStudentModel() {
        studentModel = new StudentTableModel(tbStudent);
        studentModel.loadData();
        studentModel.cssForTable();
    }

    private void initEvents() {
        btnAddEvent();
        tbStudentEvents();
        btnEditEvent();
        tfSearchEvent();
    }

    private void tbStudentEvents() {
        tbStudent.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tableRowSelectionTrigger();
            }
        });

        tbStudent.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                tableRowSelectionTrigger();
            }
        });
    }

    private void tableRowSelectionTrigger() {
        int rowIndex = tbStudent.getSelectedRow();
        
        // rowModel
        selectedRow = tbStudent.convertRowIndexToModel(rowIndex);
        String studentId = (String) tbStudent.getModel().getValueAt(selectedRow, 0);
        selectedStudent=studentService.get(studentId);
        showStudentInfo(selectedStudent);
        btnEdit.setEnabled(true);
    }

    private void showStudentInfo(Student student) {
        if (student != null) {
            lbNameDetail.setText(student.getFullname());
            lbGradeDetail.setText(student.getGrade().getName());
            lbGenderDetail.setText((student.getGender()) ? "Nam" : "Nữ");
            lbMathDetail.setText(student.getMath().toString());
            lbLiteratureDetail.setText(student.getLiterature().toString());
            lbHobbiesDetail.setText(student.getHobbies());
            lbAvatar.setIcon(ImageUtils.getIcon(student.getAvatarPath(), lbAvatar.getWidth(), lbAvatar.getHeight()));
        }
    }

    private void tfSearchEvent() {
        tfSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String text = tfSearch.getText();
                TableRowSorter<TableModel> sorter = new TableRowSorter<>(tbStudent.getModel());
                tbStudent.setRowSorter(sorter);
                RowFilter<TableModel, Object> filter = null;
                if (text.isEmpty()) {
                    filter = RowFilter.regexFilter(text);
                } else {
                    filter = RowFilter.regexFilter("(?i)" + text); // tim kiem cho toan bang 
                                            //   ("^(?i)" + text + "$");  // dau ^ nghia la bat dau bang text, $ la rong 
                                                                          // dong lenh nay la tim kiem giong hoan toan
                }                                                         // thuong de tim kiem so
                sorter.setRowFilter(filter);
            }
        });
    }

    private void btnAddEvent() {
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                FrStudentForm form = new FrStudentForm(studentModel);
                form.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                form.setVisible(true);
            }

        });
    }
    
    private void btnEditEvent() {
        btnEdit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (btnEdit.isEnabled()) {
                    FrStudentForm form = new FrStudentForm(selectedStudent,studentModel,selectedRow);
                    form.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    form.setVisible(true);
                }
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

        pnTop = new javax.swing.JPanel();
        kbSearch = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        pnCenter = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbStudent = new javax.swing.JTable();
        pnbottom = new javax.swing.JPanel();
        lbName = new javax.swing.JLabel();
        lbGrade = new javax.swing.JLabel();
        lbGender = new javax.swing.JLabel();
        lbHobbies = new javax.swing.JLabel();
        lbMath = new javax.swing.JLabel();
        lbLiterature = new javax.swing.JLabel();
        lbAvatar = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        lbNameDetail = new javax.swing.JLabel();
        lbGradeDetail = new javax.swing.JLabel();
        lbGenderDetail = new javax.swing.JLabel();
        lbHobbiesDetail = new javax.swing.JLabel();
        lbMathDetail = new javax.swing.JLabel();
        lbLiteratureDetail = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(414, 300));
        setLayout(new java.awt.BorderLayout());

        kbSearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        kbSearch.setText("Tìm kiếm:");

        tfSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfSearch.setMinimumSize(new java.awt.Dimension(7, 32));

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.setFocusPainted(false);

        javax.swing.GroupLayout pnTopLayout = new javax.swing.GroupLayout(pnTop);
        pnTop.setLayout(pnTopLayout);
        pnTopLayout.setHorizontalGroup(
            pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kbSearch)
                .addGap(18, 18, 18)
                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 781, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addContainerGap())
        );
        pnTopLayout.setVerticalGroup(
            pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnAdd)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kbSearch))
                .addContainerGap())
        );

        add(pnTop, java.awt.BorderLayout.PAGE_START);

        pnCenter.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        tbStudent.setAutoCreateRowSorter(true);
        tbStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbStudent.setRowHeight(32);
        tbStudent.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tbStudent);

        pnCenter.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pnbottom.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sinh viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 0, 24), new java.awt.Color(0, 255, 102))); // NOI18N

        lbName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbName.setText("Họ tên:");

        lbGrade.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbGrade.setText("Lớp:");

        lbGender.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbGender.setText("Giới tính:");

        lbHobbies.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbHobbies.setText("Sở thích:");

        lbMath.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbMath.setText("Điểm Toán:");

        lbLiterature.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbLiterature.setText("Điểm Văn:");

        lbAvatar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 0), 2));

        btnEdit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit-icon.gif"))); // NOI18N
        btnEdit.setText("SỬA");
        btnEdit.setEnabled(false);
        btnEdit.setFocusPainted(false);

        lbNameDetail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbNameDetail.setText("...........................................");
        lbNameDetail.setPreferredSize(new java.awt.Dimension(34, 32));

        lbGradeDetail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbGradeDetail.setText("...........................................");
        lbGradeDetail.setPreferredSize(new java.awt.Dimension(34, 32));

        lbGenderDetail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbGenderDetail.setText("...........................................");
        lbGenderDetail.setPreferredSize(new java.awt.Dimension(34, 32));

        lbHobbiesDetail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbHobbiesDetail.setText("...........................................");
        lbHobbiesDetail.setPreferredSize(new java.awt.Dimension(34, 32));

        lbMathDetail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbMathDetail.setText("...........................................");
        lbMathDetail.setPreferredSize(new java.awt.Dimension(34, 32));

        lbLiteratureDetail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbLiteratureDetail.setText("...........................................");
        lbLiteratureDetail.setPreferredSize(new java.awt.Dimension(34, 32));

        javax.swing.GroupLayout pnbottomLayout = new javax.swing.GroupLayout(pnbottom);
        pnbottom.setLayout(pnbottomLayout);
        pnbottomLayout.setHorizontalGroup(
            pnbottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnbottomLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnbottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbGrade)
                    .addComponent(lbGender))
                .addGap(18, 18, 18)
                .addGroup(pnbottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbNameDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbGradeDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbGenderDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(pnbottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbLiterature)
                    .addComponent(lbMath)
                    .addComponent(lbHobbies))
                .addGap(18, 18, 18)
                .addGroup(pnbottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbHobbiesDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMathDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbLiteratureDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addComponent(lbAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(btnEdit)
                .addContainerGap())
            .addGroup(pnbottomLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbName)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnbottomLayout.setVerticalGroup(
            pnbottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnbottomLayout.createSequentialGroup()
                .addGroup(pnbottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnbottomLayout.createSequentialGroup()
                        .addGroup(pnbottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lbName)
                            .addComponent(lbNameDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbHobbies)
                            .addComponent(lbHobbiesDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(pnbottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lbGrade)
                            .addComponent(lbGradeDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMath)
                            .addComponent(lbMathDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(pnbottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lbGender)
                            .addComponent(lbGenderDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbLiterature)
                            .addComponent(lbLiteratureDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnEdit)
                    .addGroup(pnbottomLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnCenter.add(pnbottom, java.awt.BorderLayout.PAGE_END);

        add(pnCenter, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEdit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel kbSearch;
    private javax.swing.JLabel lbAvatar;
    private javax.swing.JLabel lbGender;
    private javax.swing.JLabel lbGenderDetail;
    private javax.swing.JLabel lbGrade;
    private javax.swing.JLabel lbGradeDetail;
    private javax.swing.JLabel lbHobbies;
    private javax.swing.JLabel lbHobbiesDetail;
    private javax.swing.JLabel lbLiterature;
    private javax.swing.JLabel lbLiteratureDetail;
    private javax.swing.JLabel lbMath;
    private javax.swing.JLabel lbMathDetail;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbNameDetail;
    private javax.swing.JPanel pnCenter;
    private javax.swing.JPanel pnTop;
    private javax.swing.JPanel pnbottom;
    private javax.swing.JTable tbStudent;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
