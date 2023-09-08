/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package poly.edu.view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import poly.edu.model.Student;
import poly.edu.service.StudentService;

/**
 *
 * @author phamh
 */
public class ManagerStudentForm extends javax.swing.JFrame {

    /**
     * Creates new form ManagerPointForm
     */
    String basePath = "C:\\Users\\phamh\\Desktop\\Java3 Fpoly\\AssginmentJava3";
    String pathImg = "";
    List<Student> listStudent = new ArrayList<>();
    StudentService studentService = new StudentService();

    public ManagerStudentForm() {
        initComponents();
        LoadDataToTable();
        setLocationRelativeTo(null);
    }

    public void clearForm() {
        txtMaSinhVien.setText("");
        txtEmail.setText("");
        txtDiaChi.setText("");
        txtSoDienThoai.setText("");
        txtHoVaTen.setText("");
        lbImage.setIcon(null);
        pathImg = "";
    }

    public void loadToFormByIndex(int index) {
        Student student = studentService.getAllStudent().get(index);
        txtMaSinhVien.setText(student.getMaSv());
        txtHoVaTen.setText(student.getHoTen());
        txtDiaChi.setText(student.getDiaChi());
        txtSoDienThoai.setText(student.getSoDt());
        txtEmail.setText(student.getEmail());
        rboNam.setSelected(student.getGioiTinh() == 0 ? true : false);
        rboNu.setSelected(student.getGioiTinh() == 1 ? true : false);
        String path = String.valueOf(basePath + "\\Image\\" + student.getHinh());
        System.out.println("Path: " + path);
        File f = new File(path);
        String[] parts = path.split("\\\\");
        System.out.println(parts.toString());
        pathImg = parts[parts.length-1];
      
        try {
            Image img = ImageIO.read(f);
            int labelWidth = lbImage.getWidth() - 20;
            int labelHeight = lbImage.getHeight() - 20;
            Image scaledImg = img.getScaledInstance(labelWidth, labelHeight, Image.SCALE_DEFAULT);
            ImageIcon imgIcon = new ImageIcon(scaledImg);
            lbImage.setIcon(imgIcon);
        } catch (Exception e) {
            System.out.println("set Image Error: " + e);
            pathImg = "";
        }
    }

    public void clickTableEvent() {
        lbImage.setIcon(null);
        pathImg = "";
        int index = tblBang.getSelectedRow();
        loadToFormByIndex(index);

    }

    public void LoadDataToTable() {
        List<Student> list = studentService.getAllStudent();
        DefaultTableModel model = new DefaultTableModel();
        model.setRowCount(0);
        model.setColumnIdentifiers(new Object[]{"MaSv", "Ho Ten", "Email", "So Dien Thoai", "Gioi Tinh", "Dia Chi", "Hinh"});
        list.forEach(s -> model.addRow(new Object[]{s.getMaSv(), s.getHoTen(), s.getEmail(), s.getSoDt(), s.getGioiTinh() == 0 ? "Nam" : "Nữ", s.getDiaChi(), s.getHinh()}));
        tblBang.setModel(model);
    }

    public void showMessageBox(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void choseImage() {
        JFileChooser fChose = new JFileChooser(basePath + "\\Image\\");
        int result = fChose.showOpenDialog(null);
        File f = fChose.getSelectedFile();
        try {
            System.out.println(f);
            System.out.println("Name F: " + f.getName());
            pathImg = f.getName();
            System.out.println("Path IMG: " + pathImg);
            Image img = ImageIO.read(f);
            int labelWidth = lbImage.getWidth() - 20;
            int labelHeight = lbImage.getHeight() - 20;
            Image scaledImg = img.getScaledInstance(labelWidth, labelHeight, Image.SCALE_DEFAULT);
            ImageIcon imgIcon = new ImageIcon(scaledImg);
            lbImage.setIcon(imgIcon);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public Student getObjStudent() {
        String maSv = txtMaSinhVien.getText();
        String hoTen = txtHoVaTen.getText();
        String email = txtEmail.getText();
        String soDt = txtSoDienThoai.getText();
        int gioiTinh = rboNam.isSelected() == true ? 0 : 1;
        String diaChi = txtDiaChi.getText();
        String hinh = pathImg;
        boolean validated = true;
        if (maSv.isEmpty()) {
            showMessageBox("Vui Long Nhap MaSv");
            txtMaSinhVien.requestFocus();
            validated = false;
        } else if (hoTen.isEmpty()) {
            showMessageBox("Vui Long Nhap HoTen");
            txtHoVaTen.requestFocus();
            validated = false;
        } else if (email.isEmpty()) {
            showMessageBox("Vui Long Nhap Email");
            txtEmail.requestFocus();
            validated = false;
        } else if (soDt.isEmpty()) {
            showMessageBox("Vui Long Nhap SoDT");
            txtSoDienThoai.requestFocus();
            validated = false;
        } else if (diaChi.isEmpty()) {
            showMessageBox("Vui Long Nhap DiaChi");
            txtDiaChi.requestFocus();
            validated = false;
        }
        if (validated) {
            Student student = new Student(maSv, hoTen, email, soDt, gioiTinh, diaChi, hinh);
            return student;
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtHoVaTen = new javax.swing.JTextField();
        txtMaSinhVien = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        rboNam = new javax.swing.JRadioButton();
        rboNu = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBang = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        lbImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Mã Sinh Viên:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Họ Tên:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Email:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Só Điện Thoại");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Giới Tính:");

        buttonGroup1.add(rboNam);
        rboNam.setText("Nam");

        buttonGroup1.add(rboNu);
        rboNu.setText("Nữ");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Địa Chỉ:");

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        jScrollPane1.setViewportView(txtDiaChi);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Save.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Add.png"))); // NOI18N
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Edit.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblBangMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblBang);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Quản Lý Sinh Viên");

        lbImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbImage.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        lbImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbImageMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addGap(6, 6, 6))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaSinhVien)
                            .addComponent(txtEmail)
                            .addComponent(txtHoVaTen)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rboNam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rboNu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtSoDienThoai)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNew)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSave))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbImage, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)))))
                .addGap(0, 40, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDelete, btnNew, btnSave, btnUpdate});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtHoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lbImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rboNam)
                            .addComponent(rboNu)))
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNew)
                            .addComponent(btnSave))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete)
                            .addComponent(btnUpdate))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        Student student = getObjStudent();

        if (student != null) {
            if (studentService.checkExitMaSV(student.getMaSv()) == true) {
                JOptionPane.showMessageDialog(this, "Mã Sinh Viên Đã Tồn tại");
            } else {
                showMessageBox(studentService.addStudent(student, listStudent));
                LoadDataToTable();
                clearForm();

            }

        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void lbImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbImageMouseClicked
        // TODO add your handling code here:
        choseImage();
    }//GEN-LAST:event_lbImageMouseClicked

    private void tblBangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tblBangMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        Student student = getObjStudent();
        if (student != null) {
            JOptionPane.showMessageDialog(this, studentService.updateStudent(student));
            LoadDataToTable();
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        String maSv = txtMaSinhVien.getText();
        if (!maSv.isEmpty()) {
            int choice = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Xóa Không", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (choice == 0) {
                JOptionPane.showMessageDialog(this, studentService.deleteStudent(maSv));
                LoadDataToTable();
                tblBang.getSelectionModel().setSelectionInterval(0, 0);
                loadToFormByIndex(0);
            }

        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        clearForm();

    }//GEN-LAST:event_btnNewActionPerformed

    private void tblBangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangMousePressed
        // TODO add your handling code here:
        clickTableEvent();
    }//GEN-LAST:event_tblBangMousePressed

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
            java.util.logging.Logger.getLogger(ManagerStudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerStudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerStudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerStudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerStudentForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbImage;
    private javax.swing.JRadioButton rboNam;
    private javax.swing.JRadioButton rboNu;
    private javax.swing.JTable tblBang;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoVaTen;
    private javax.swing.JTextField txtMaSinhVien;
    private javax.swing.JTextField txtSoDienThoai;
    // End of variables declaration//GEN-END:variables
}
