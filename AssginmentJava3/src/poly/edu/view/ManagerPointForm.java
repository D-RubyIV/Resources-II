/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package poly.edu.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import poly.edu.model.Grade;
import poly.edu.model.Student;
import poly.edu.service.GradeService;
import poly.edu.service.StudentService;

/**
 *
 * @author phamh
 */
public class ManagerPointForm extends javax.swing.JFrame {

    /**
     * Creates new form ManagerForm
     */
    int indexChange = 0;
    GradeService gradeService = new GradeService();
    StudentService studentService = new StudentService();

    public ManagerPointForm() {
        initComponents();
        setLocationRelativeTo(null);
        loadDataGradeToTable();
    }

    private boolean isFloat(String input) {
        try {
            Float.parseFloat(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void DTBEvent() {
        String diemTiengAnh = txtTiengAnh.getText();
        String diemTinHoc = txtTinHoc.getText();
        String diemGdtc = txtGDTC.getText();
        System.out.println(diemTiengAnh);

        if (!diemTiengAnh.isEmpty() && !diemTinHoc.isEmpty() && !diemGdtc.isEmpty()) {
            if (isFloat(diemTiengAnh) && isFloat(diemGdtc) && isFloat(diemTinHoc)) {
                float dtb = (Float.parseFloat(diemGdtc) + Float.parseFloat(diemTiengAnh) + Float.parseFloat(diemTinHoc)) / 3;
                Float roundNumber = Math.round(dtb * 10.0f) / 10.0f;
                lbDTB.setText(String.valueOf(roundNumber));
            }
        } else {
            lbDTB.setText("");
        }
    }

    public void tableClickedEvent() {
        int index = tblBang.getSelectedRow();
        String maSv = tblBang.getValueAt(index, 0).toString();
        String hoTen = tblBang.getValueAt(index, 1).toString();
        String tiengAnh = tblBang.getValueAt(index, 2).toString();
        String tinHoc = tblBang.getValueAt(index, 3).toString();
        String gdtc = tblBang.getValueAt(index, 4).toString();
        String dtb = tblBang.getValueAt(index, 5).toString();

        lbFullName.setText(hoTen);
        txtMaSv.setText(maSv);
        txtTiengAnh.setText(tiengAnh);
        txtTinHoc.setText(tinHoc);
        txtGDTC.setText(gdtc);
        lbDTB.setText(dtb);

    }

    public void showMessageBox(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void loadToForm(Grade grade) {
        txtMaSv.setText(grade.getMaSv());
        txtTiengAnh.setText(String.valueOf(grade.getTiengAnh()));
        txtTinHoc.setText(String.valueOf(grade.getTinHoc()));
        txtGDTC.setText(String.valueOf(grade.getGdtc()));
        txtTinHoc.setText(String.valueOf(txtTinHoc.getText()));
        String maSv = txtMaSv.getText();
        System.out.println(maSv);
        if (!maSv.isEmpty()) {
            String fullName = studentService.getNameSvByMaSv(maSv);
            lbFullName.setText(fullName);
        }
        lbDTB.setText(String.valueOf(grade.getDiemTrungBinh()));

    }

    public void loadDataGradeToTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Mssv", "Ho Ten", "Tieng Anh", "Tin học", "Gdtc", "Diem TB"});
        Map<String, Object[]> map = gradeService.getAllInfoSVHavePoint();
        for (Map.Entry<String, Object[]> entry : map.entrySet()) {
            String key = entry.getKey();
            Object[] val = entry.getValue();
            model.addRow(new Object[]{val[0], val[1], val[2], val[3], val[4], val[5]});
        }
        tblBang.setModel(model);

    }

    public Grade getObjGrade() {
        String maSv = txtMaSv.getText();
        String diemTiengAnh = txtTiengAnh.getText();
        String diemTinHoc = txtTinHoc.getText();
        String diemGDTC = txtGDTC.getText();
        if (maSv.isEmpty()) {
            showMessageBox("Vui Long Nhap Ma Sv");
            txtMaSv.requestFocus();
            return null;
        } else if (diemTiengAnh.isEmpty()) {
            showMessageBox("Vui Long Nhap Diem Tieng ANh");
            txtTiengAnh.requestFocus();
            return null;
        } else if (diemTinHoc.isEmpty()) {
            showMessageBox("Vui Long Nhap Diem Tin Hoc");
            txtTinHoc.requestFocus();
            return null;
        } else if (diemGDTC.isEmpty()) {
            showMessageBox("Vui Long Nhap Diem GDTC");
            txtGDTC.requestFocus();
            return null;
        }
        int tiengAnh = Integer.valueOf(diemTiengAnh);
        int tinHoc = Integer.valueOf(diemTinHoc);
        int gdtc = Integer.valueOf(diemGDTC);
        return new Grade(maSv, tiengAnh, tinHoc, gdtc);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaSinhVienSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbFullName = new javax.swing.JLabel();
        txtMaSv = new javax.swing.JTextField();
        txtTinHoc = new javax.swing.JTextField();
        txtTiengAnh = new javax.swing.JTextField();
        txtGDTC = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lbDTB = new javax.swing.JLabel();
        maxPrev = new javax.swing.JButton();
        next = new javax.swing.JButton();
        prev = new javax.swing.JButton();
        maxNext = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBang = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản Lý Điểm Sinh Viên");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setText("Mã SV:");

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Search.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaSinhVienSearch)
                .addGap(18, 18, 18)
                .addComponent(btnSearch)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaSinhVienSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Mã SV:");

        jLabel4.setText("Họ Và Tên SV:");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Giáo dục TC:");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Tiếng Anh:");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Tin Học:");

        txtMaSv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSvActionPerformed(evt);
            }
        });
        txtMaSv.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtMaSvPropertyChange(evt);
            }
        });
        txtMaSv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaSvKeyReleased(evt);
            }
        });

        txtTinHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTinHocActionPerformed(evt);
            }
        });
        txtTinHoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTinHocKeyReleased(evt);
            }
        });

        txtTiengAnh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTiengAnhKeyReleased(evt);
            }
        });

        txtGDTC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGDTCActionPerformed(evt);
            }
        });
        txtGDTC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGDTCKeyReleased(evt);
            }
        });

        jLabel9.setText("Điểm TB:");

        lbDTB.setBackground(new java.awt.Color(102, 51, 255));
        lbDTB.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        lbDTB.setForeground(new java.awt.Color(102, 102, 255));
        lbDTB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDTB.setText("8.6");

        maxPrev.setText("|<");
        maxPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxPrevActionPerformed(evt);
            }
        });

        next.setText(">>");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        prev.setText("<<");
        prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevActionPerformed(evt);
            }
        });

        maxNext.setText(">|");
        maxNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtMaSv, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(maxPrev)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(next)
                                        .addGap(54, 54, 54)
                                        .addComponent(prev))
                                    .addComponent(txtGDTC, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTiengAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTinHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(maxNext)
                            .addComponent(lbDTB, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {maxNext, maxPrev, next, prev});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbFullName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaSv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtTiengAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtTinHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtGDTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbDTB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(next, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(maxNext, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(maxPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(prev))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {maxNext, maxPrev, next, prev});

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Add.png"))); // NOI18N
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Save.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Edit.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnSave)
                    .addComponent(btnNew))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDelete, btnNew, btnSave, btnUpdate});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNew)
                .addGap(12, 12, 12)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdate)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        tblBang.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBang);

        jLabel8.setForeground(new java.awt.Color(51, 51, 255));
        jLabel8.setText("3 sinh viên có điểm cao nhất");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTinHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTinHocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTinHocActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        Grade grade = getObjGrade();
        if (grade != null) {
            if (gradeService.searchByMaSV(grade.getMaSv()) == null) {
                JOptionPane.showMessageDialog(this, "Sinh Viên Không Tồn Tại");
            } else {
                showMessageBox(gradeService.addGrade(grade));
                loadDataGradeToTable();
            }

        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        String maSv = txtMaSv.getText();
        if (maSv.isEmpty()) {
            showMessageBox("Vui Long Nhap Ma Sinh Vien");
        } else {
            int choice = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Xóa Không", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (choice == 0) {
                showMessageBox(gradeService.deleteGrade(maSv));
                loadDataGradeToTable();
                clearForm();
         
            }

        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        Grade grade = getObjGrade();
        if (grade != null) {
            showMessageBox(gradeService.updateGrade(grade));
            loadDataGradeToTable();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tblBangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangMouseClicked
        // TODO add your handling code here:
        tableClickedEvent();
    }//GEN-LAST:event_tblBangMouseClicked

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        // TODO add your handling code here:
        List<Grade> list = gradeService.getAllGrade();
        if (indexChange < list.size() - 1) {
            indexChange += 1;
        } else {
            indexChange = 0;
        }
        Grade grade = list.get(indexChange);
        loadToForm(grade);
    }//GEN-LAST:event_nextActionPerformed

    private void txtMaSvPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtMaSvPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_txtMaSvPropertyChange

    private void txtMaSvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSvActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtMaSvActionPerformed

    private void txtMaSvKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaSvKeyReleased
        // TODO add your handling code here:
        String maSv = txtMaSv.getText();
        System.out.println(maSv);
        if (!maSv.isEmpty()) {
            String fullName = studentService.getNameSvByMaSv(maSv);
            lbFullName.setText(fullName);
        }
    }//GEN-LAST:event_txtMaSvKeyReleased

    private void txtTiengAnhKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTiengAnhKeyReleased
        // TODO add your handling code here:
        DTBEvent();
    }//GEN-LAST:event_txtTiengAnhKeyReleased

    private void txtTinHocKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTinHocKeyReleased
        // TODO add your handling code here:
        DTBEvent();
    }//GEN-LAST:event_txtTinHocKeyReleased

    private void txtGDTCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGDTCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGDTCActionPerformed

    private void txtGDTCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGDTCKeyReleased
        // TODO add your handling code here:
        DTBEvent();
    }//GEN-LAST:event_txtGDTCKeyReleased

    private void prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevActionPerformed
        // TODO add your handling code here:
        List<Grade> list = gradeService.getAllGrade();
        if (indexChange > 0) {
            indexChange -= 1;
        } else {
            indexChange = list.size() - 1;
        }
        Grade grade = list.get(indexChange);
        loadToForm(grade);
    }//GEN-LAST:event_prevActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String maSv = txtMaSinhVienSearch.getText();
        if (maSv.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui Lòng nhập mã sinh viên trên thanh tìm kiếm");
        } else {
            Grade grade = gradeService.searchByMaSV(maSv);
            if (grade == null) {
                JOptionPane.showMessageDialog(this, "Không Tìm Thấy Sinh Viên");
            } else {
                loadToForm(grade);
                JOptionPane.showMessageDialog(this, "Tìm Kiếm Thành Công");
            }

        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void maxNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxNextActionPerformed
        // TODO add your handling code here:
        List<Grade> list = gradeService.getAllGrade();
        indexChange = list.size() - 1;
        Grade grade = list.get(indexChange);
        loadToForm(grade);


    }//GEN-LAST:event_maxNextActionPerformed

    private void maxPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxPrevActionPerformed
        // TODO add your handling code here:
        List<Grade> list = gradeService.getAllGrade();
        indexChange = 0;
        Grade grade = list.get(indexChange);
        loadToForm(grade);
    }//GEN-LAST:event_maxPrevActionPerformed
    public void clearForm() {
        txtMaSv.setText("");
        txtGDTC.setText("");
        txtTiengAnh.setText("");
        txtTinHoc.setText("");
        lbDTB.setText("");
    }
    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnNewActionPerformed

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
            java.util.logging.Logger.getLogger(ManagerPointForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerPointForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerPointForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerPointForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerPointForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDTB;
    private javax.swing.JLabel lbFullName;
    private javax.swing.JButton maxNext;
    private javax.swing.JButton maxPrev;
    private javax.swing.JButton next;
    private javax.swing.JButton prev;
    private javax.swing.JTable tblBang;
    private javax.swing.JTextField txtGDTC;
    private javax.swing.JTextField txtMaSinhVienSearch;
    private javax.swing.JTextField txtMaSv;
    private javax.swing.JTextField txtTiengAnh;
    private javax.swing.JTextField txtTinHoc;
    // End of variables declaration//GEN-END:variables
}
