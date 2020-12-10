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

    private Student selectedStudent;
    private StudentService studentService;

    /**
     * Creates new form pnStudentHome2
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
        tfSearchEvent();
        tbStudentEvent();

        btAddEvent();
        btEditEvent();

    }

    private void tfSearchEvent() {
        tfSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String text = tfSearch.getText();
                TableRowSorter<TableModel> sorter = new TableRowSorter<>(tbStudent.getModel());
                tbStudent.setRowSorter(sorter);
                RowFilter<TableModel, Object> filter;
                if (text.isEmpty()) {
                    filter = RowFilter.regexFilter(text);
                } // RowFilter<TableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + text);
                else {
                    //"^(?i)" + text + "$" giong toan bo
                    filter = RowFilter.regexFilter("(?i)" + text);// $ bắt đúng nội dung , tương tự ko ra kết quả
                    sorter.setRowFilter(filter);
                }
            }

        });
    }

    private void tbStudentEvent() {
        tbStudent.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tableRowSelectionTrigger();

            }

        });
        tbStudent.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                tableRowSelectionTrigger();
            }

        });

    }

    private void tableRowSelectionTrigger() {
        int row = tbStudent.convertRowIndexToModel(tbStudent.getSelectedRow());
        String studentID = (String) tbStudent.getModel().getValueAt(row, 0);
        selectedStudent = studentService.get(studentID);
        showStudentInfo(selectedStudent);
        btEdit.setEnabled(true);
    }

    private void showStudentInfo(Student student) {
        if (student != null) {
            lbFullName.setText(student.getFullname());
            lbHobby.setText(student.getHobbies());
            lbGrade.setText(student.getGrade().toString());
            lbLiterature.setText(student.getLiterature().toString());
            lbMath.setText(student.getMath().toString());
            lbGender.setText(student.getGender() ? "Nữ" : "Nam");
            lbAvatar.setIcon(ImageUtils.getIcon(student.getAvatarPath(), lbAvatar.getWidth(), lbAvatar.getHeight()));
        }
    }

    private void btAddEvent() {
        btAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                FrStudentForm form = new FrStudentForm();
                form.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                form.setVisible(true);

            }

        });
    }

    private void btEditEvent() {

        btEdit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (btEdit.isEnabled()) {
                    FrStudentForm form = new FrStudentForm(selectedStudent);
                    form.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    form.setVisible(true);

                }

            }
        }
        );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnBottom = new javax.swing.JPanel();
        pnInfor = new javax.swing.JPanel();
        lbAvatar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbGrade = new javax.swing.JLabel();
        lbGender = new javax.swing.JLabel();
        lbFullName = new javax.swing.JLabel();
        lbMath = new javax.swing.JLabel();
        lbLiterature = new javax.swing.JLabel();
        lbHobby = new javax.swing.JLabel();
        btEdit = new javax.swing.JButton();
        pnCenter = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        tbStudent = new javax.swing.JTable();
        pnTop = new javax.swing.JPanel();
        lbSearch = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        btAdd = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        pnInfor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sinh viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP));

        lbAvatar.setBackground(new java.awt.Color(153, 255, 153));

        jLabel1.setText("Họ tên:");

        jLabel2.setText("Lớp:");

        jLabel3.setText("Giới tính:");

        jLabel4.setText("Sở thích:");

        jLabel5.setText("Điểm toán:");

        jLabel6.setText("Điểm văn:");

        lbGrade.setText(".............");

        lbGender.setText(".............");

        lbFullName.setText(".............");

        lbMath.setText(".............");

        lbLiterature.setText(".............");

        lbHobby.setText(".............");

        btEdit.setText("Sửa");
        btEdit.setEnabled(false);

        javax.swing.GroupLayout pnInforLayout = new javax.swing.GroupLayout(pnInfor);
        pnInfor.setLayout(pnInforLayout);
        pnInforLayout.setHorizontalGroup(
            pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInforLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel5)
                        .addComponent(jLabel4))
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbHobby, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMath, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbLiterature, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(lbAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(btEdit)
                .addContainerGap())
        );

        pnInforLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel4, jLabel5, jLabel6});

        pnInforLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lbHobby, lbLiterature, lbMath});

        pnInforLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lbFullName, lbGender, lbGrade});

        pnInforLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3});

        pnInforLayout.setVerticalGroup(
            pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInforLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(lbFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbHobby, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbMath, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addGap(30, 30, 30)
                .addGroup(pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(lbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(lbLiterature, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
            .addGroup(pnInforLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lbAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnInforLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btEdit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnInforLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lbHobby, lbLiterature, lbMath});

        javax.swing.GroupLayout pnBottomLayout = new javax.swing.GroupLayout(pnBottom);
        pnBottom.setLayout(pnBottomLayout);
        pnBottomLayout.setHorizontalGroup(
            pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBottomLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(pnInfor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnBottomLayout.setVerticalGroup(
            pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBottomLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(pnInfor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(pnBottom, java.awt.BorderLayout.SOUTH);

        pnCenter.setPreferredSize(new java.awt.Dimension(120, 100));

        tbStudent.setAutoCreateRowSorter(true);
        tbStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Lớp", "Họ tên", "Toán", "Văn", "Sở thích"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbStudent.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scroll.setViewportView(tbStudent);

        javax.swing.GroupLayout pnCenterLayout = new javax.swing.GroupLayout(pnCenter);
        pnCenter.setLayout(pnCenterLayout);
        pnCenterLayout.setHorizontalGroup(
            pnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCenterLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnCenterLayout.setVerticalGroup(
            pnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(pnCenter, java.awt.BorderLayout.CENTER);

        lbSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbSearch.setText("Tìm kiếm");

        tfSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btAdd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btAdd.setText("Thêm");
        btAdd.setFocusPainted(false);

        javax.swing.GroupLayout pnTopLayout = new javax.swing.GroupLayout(pnTop);
        pnTop.setLayout(pnTopLayout);
        pnTopLayout.setHorizontalGroup(
            pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbSearch)
                .addGap(41, 41, 41)
                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
                .addComponent(btAdd)
                .addGap(47, 47, 47))
        );
        pnTopLayout.setVerticalGroup(
            pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSearch)
                    .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btAdd)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(pnTop, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lbAvatar;
    private javax.swing.JLabel lbFullName;
    private javax.swing.JLabel lbGender;
    private javax.swing.JLabel lbGrade;
    private javax.swing.JLabel lbHobby;
    private javax.swing.JLabel lbLiterature;
    private javax.swing.JLabel lbMath;
    private javax.swing.JLabel lbSearch;
    private javax.swing.JPanel pnBottom;
    private javax.swing.JPanel pnCenter;
    private javax.swing.JPanel pnInfor;
    private javax.swing.JPanel pnTop;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tbStudent;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
