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
import service.StudentSerivice;
import service.StudentServiceImpl;
import utils.ImageUtils;

/**
 *
 * @author qphan
 */
public class PnStudent extends javax.swing.JPanel {

    private final StudentSerivice studentService;

    private Student selectedStudent;

    /**
     * Creates new form PnStudent
     */
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
        StudentTableModel studentModel = new StudentTableModel(tbStudent);
        studentModel.loadData();
        studentModel.cssForTable();
    }

    private void initEvents() {
        tfSearchEvents();
        tbStudentEvents();
        btAddEvents();
        btEditEvents();
    }

    private void tfSearchEvents() {
        tfSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String text = tfSearch.getText();
                TableRowSorter<TableModel> sorter = new TableRowSorter<>(tbStudent.getModel());
                tbStudent.setRowSorter(sorter);
                RowFilter<TableModel, Object> filter;
                if (text.isEmpty()) {
                    filter = RowFilter.regexFilter(text);
                } else {
                    // (?i) => case insensitive
                    // "^(?i)" + text + "$" => equals filter
                    filter = RowFilter.regexFilter("(?i)" + text);
                }
                sorter.setRowFilter(filter);
            }
        });
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
        int row = tbStudent.convertRowIndexToModel(tbStudent.getSelectedRow());
        String studentId = (String) tbStudent.getModel().getValueAt(row, 0);
        selectedStudent = studentService.get(studentId);
        showStudentInfo(selectedStudent);
        btEdit.setEnabled(true);
    }

    private void showStudentInfo(Student student) {
        if (student != null) {
            lbFullname.setText(student.getFullname());
            lbGrade.setText(student.getGrade().getName());
            lbGender.setText(student.getGender() ? "Nam" : "Nữ");
            lbHobbies.setText(student.getHobbies());
            lbMath.setText(student.getMath().toString());
            lbLiterature.setText(student.getLiterature().toString());
            lbAvatar.setIcon(ImageUtils.getIcon(student.getAvatarPath(), 120, 135));
        }
    }

    private void btAddEvents() {
        btAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                FrStudentForm form = new FrStudentForm();
                form.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                form.setVisible(true);
            }
        });
    }

    private void btEditEvents() {
        btEdit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (btEdit.isEnabled()) {
                    FrStudentForm form = new FrStudentForm(selectedStudent);
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
        lbSearch = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        btAdd = new javax.swing.JButton();
        pnBottom = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbFullname = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbGrade = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbGender = new javax.swing.JLabel();
        lbHobbies = new javax.swing.JLabel();
        lbMath = new javax.swing.JLabel();
        lbLiterature = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbAvatar = new javax.swing.JLabel();
        btEdit = new javax.swing.JButton();
        pnCenter = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        tbStudent = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        pnTop.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbSearch.setText("Tìm kiếm:");

        tfSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfSearch.setPreferredSize(new java.awt.Dimension(6, 32));

        btAdd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btAdd.setText("THÊM");
        btAdd.setFocusPainted(false);

        javax.swing.GroupLayout pnTopLayout = new javax.swing.GroupLayout(pnTop);
        pnTop.setLayout(pnTopLayout);
        pnTopLayout.setHorizontalGroup(
            pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 569, Short.MAX_VALUE)
                .addComponent(btAdd)
                .addContainerGap())
        );
        pnTopLayout.setVerticalGroup(
            pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTopLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbSearch)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAdd))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(pnTop, java.awt.BorderLayout.PAGE_START);

        pnBottom.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "THÔNG TIN SINH VIÊN", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(0, 153, 51))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Họ tên:");

        lbFullname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbFullname.setText("..............................");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Lớp:");

        lbGrade.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbGrade.setText("..............................");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Giới Tính:");

        lbGender.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbGender.setText("..............................");

        lbHobbies.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbHobbies.setText("..............................");

        lbMath.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbMath.setText("..............................");

        lbLiterature.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbLiterature.setText("..............................");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Điểm Văn:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Điểm Toán:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Sở thích:");

        lbAvatar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbAvatar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 102), 2));

        btEdit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit-icon.gif"))); // NOI18N
        btEdit.setText("SỬA");
        btEdit.setEnabled(false);
        btEdit.setFocusPainted(false);

        javax.swing.GroupLayout pnBottomLayout = new javax.swing.GroupLayout(pnBottom);
        pnBottom.setLayout(pnBottomLayout);
        pnBottomLayout.setHorizontalGroup(
            pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBottomLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(10, 10, 10)
                .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFullname)
                    .addComponent(lbGrade)
                    .addComponent(lbGender))
                .addGap(64, 64, 64)
                .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(10, 10, 10)
                .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbHobbies)
                    .addComponent(lbMath)
                    .addComponent(lbLiterature))
                .addGap(53, 53, 53)
                .addComponent(lbAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addComponent(btEdit)
                .addContainerGap())
        );
        pnBottomLayout.setVerticalGroup(
            pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBottomLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnBottomLayout.createSequentialGroup()
                        .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lbFullname)
                            .addComponent(jLabel12)
                            .addComponent(lbHobbies)
                            .addComponent(btEdit))
                        .addGap(30, 30, 30)
                        .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel3)
                            .addComponent(lbGrade)
                            .addComponent(jLabel11)
                            .addComponent(lbMath))
                        .addGap(30, 30, 30)
                        .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(lbGender))
                            .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(lbLiterature)))))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        add(pnBottom, java.awt.BorderLayout.PAGE_END);

        pnCenter.setLayout(new java.awt.BorderLayout());

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
        tbStudent.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scroll.setViewportView(tbStudent);

        pnCenter.add(scroll, java.awt.BorderLayout.CENTER);

        add(pnCenter, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbAvatar;
    private javax.swing.JLabel lbFullname;
    private javax.swing.JLabel lbGender;
    private javax.swing.JLabel lbGrade;
    private javax.swing.JLabel lbHobbies;
    private javax.swing.JLabel lbLiterature;
    private javax.swing.JLabel lbMath;
    private javax.swing.JLabel lbSearch;
    private javax.swing.JPanel pnBottom;
    private javax.swing.JPanel pnCenter;
    private javax.swing.JPanel pnTop;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tbStudent;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
