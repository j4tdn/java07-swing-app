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

/**
 *
 * @author USER
 */
public class pnStudent extends javax.swing.JPanel {

    private final StudentService studentService;

    /**
     * Creates new form pnStudent
     */
    public pnStudent() {
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
        int studentId = (int) tbStudent.getModel().getValueAt(row, 0);
        Student student = studentService.getStudent(studentId);
        setText(student);
    }

    private void setText(Student student) {
        lbFullname.setText(student.getFullname());
    }

    private void tfSearchEvents() {
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
                    filter = RowFilter.regexFilter("^(?i)" + text + "$");
                    sorter.setRowFilter(filter);
                }
            }

        });
    }

    private void btAddEvents() {
        btAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                frStudentForm form = new frStudentForm();
                form.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                form.setVisible(true);
            }
        });
    }

    private void btEditEvents() {
        btEdit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

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
        jLabel2 = new javax.swing.JLabel();
        lbFullname = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbGrade = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbGender = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbMath = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbHobbies = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbLiterature = new javax.swing.JLabel();
        lbAvatar = new javax.swing.JLabel();
        btEdit = new javax.swing.JButton();
        pnCenter = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbStudent = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        pnTop.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbSearch.setText("Tìm kiếm");

        btAdd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btAdd.setText("Thêm");

        javax.swing.GroupLayout pnTopLayout = new javax.swing.GroupLayout(pnTop);
        pnTop.setLayout(pnTopLayout);
        pnTopLayout.setHorizontalGroup(
            pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTopLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lbSearch)
                .addGap(18, 18, 18)
                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 362, Short.MAX_VALUE)
                .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        pnTopLayout.setVerticalGroup(
            pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTopLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSearch)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        add(pnTop, java.awt.BorderLayout.PAGE_START);

        pnBottom.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sinh viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(0, 204, 102))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Họ và tên:");

        lbFullname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbFullname.setText(".....................");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Lớp:");

        lbGrade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbGrade.setText(".....................");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Giới tính:");

        lbGender.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbGender.setText(".....................");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Sở thích:");

        lbMath.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbMath.setText(".....................");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Điểm toán:");

        lbHobbies.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbHobbies.setText(".....................");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Điểm văn:");

        lbLiterature.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbLiterature.setText(".....................");

        lbAvatar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0)));

        btEdit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit-icon.gif"))); // NOI18N
        btEdit.setText("Sửa");

        javax.swing.GroupLayout pnBottomLayout = new javax.swing.GroupLayout(pnBottom);
        pnBottom.setLayout(pnBottomLayout);
        pnBottomLayout.setHorizontalGroup(
            pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBottomLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBottomLayout.createSequentialGroup()
                        .addComponent(lbGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addGroup(pnBottomLayout.createSequentialGroup()
                        .addComponent(lbFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addGroup(pnBottomLayout.createSequentialGroup()
                        .addComponent(lbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)))
                .addGap(43, 43, 43)
                .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbHobbies, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbLiterature, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMath, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btEdit)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        pnBottomLayout.setVerticalGroup(
            pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBottomLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBottomLayout.createSequentialGroup()
                        .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lbFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(lbHobbies, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lbGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(lbMath, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(lbLiterature, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEdit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(pnBottom, java.awt.BorderLayout.PAGE_END);

        pnCenter.setBorder(javax.swing.BorderFactory.createEtchedBorder());
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
        jScrollPane2.setViewportView(tbStudent);

        pnCenter.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        add(pnCenter, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btEdit;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
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
    private javax.swing.JTable tbStudent;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
