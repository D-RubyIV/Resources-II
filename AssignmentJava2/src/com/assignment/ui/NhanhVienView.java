/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.assignment.ui;

import com.assignment.model.NhanVien;
import com.assignment.dao.NhanVienService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author phamh
 */
public class NhanhVienView extends javax.swing.JFrame {

    /**
     * Creates new form NhanhVienView
     */
    NhanVienService nhanVienService = new NhanVienService();
    List<NhanVien> list = new ArrayList<>();
    int indexTbl = 0;

    public NhanhVienView() {
        initComponents();
        setLocationRelativeTo(null);
        fakeDataShow();
        Thread thread = new Thread(this::viewClock);
        thread.start();

    }

    public void fakeDataShow() {
        list = nhanVienService.fakeData();
        loadData(list);
        setRecord(0);
        showDataForm();
    }
    public void openData(){
        showMessageDialog(nhanVienService.readFileTxt());
        loadData(list);
        setRecord(0);
        showDataForm();
    }
    public void loadData(List<NhanVien> list) {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Mã Nhân Viên", "Họ Và Tên", "Tuổi", "Email", "Lương"});
        for (NhanVien nhanVien : list) {
            model.addRow(new Object[]{nhanVien.getMaNhanVien(), nhanVien.getHoVaTen(), nhanVien.getTuoi(), nhanVien.getEmail(), nhanVien.getLuong()});
        }
        tblNhanVien.setModel(model);
        setRecord(indexTbl);
        
    }
    public void viewClock(){
        while (true) {
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss aa");
//            System.out.println(format.format(date));
            lbClock.setText(format.format(date));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
    public void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    public int showTrueFalseDialog(String message, String tittle){
        return JOptionPane.showConfirmDialog(this, message, tittle, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }
    public boolean findNhanVien(){
        String maNhanVien = txtMaNhanVien.getText();
        if (maNhanVien.isEmpty()) {
            showMessageDialog("Vui Lòng Điền Mã Nhân Viên");
            return false;
        }
        int index = 0;
        boolean findStatus = false;
        for (NhanVien nhanVien : list) {
            if (nhanVien.getMaNhanVien().equalsIgnoreCase(maNhanVien)) {
                indexTbl = index;
                showDataForm();
                findStatus = true;
                break;
            }
            index += 1;
        }
        return findStatus;
        
    }
    public void showDataForm() {
        NhanVien nhanVien = list.get(indexTbl);
        txtMaNhanVien.setText(nhanVien.getMaNhanVien());
        txtHoVaTen.setText(nhanVien.getHoVaTen());
        txtTuoi.setText(String.valueOf(nhanVien.getTuoi()));
        txtEmail.setText(nhanVien.getEmail());
        txtLuong.setText(String.valueOf(nhanVien.getLuong()));
        setRecord(indexTbl);
    }
    public void clearForm(){
        indexTbl = -1;
        txtMaNhanVien.setText("");
        txtHoVaTen.setText("");
        txtTuoi.setText("");
        txtEmail.setText("");
        txtLuong.setText("");
        loadData(list);
    }
    public void setRecord(int index) {
        lbRecord.setText("Record " + (index + 1) + " of " + list.size());
        tblNhanVien.getSelectionModel().setSelectionInterval(index, index);
    }

    public void TblClicked() {
        indexTbl = tblNhanVien.getSelectedRow();
        showDataForm();
    }

    public NhanVien getObjNhanVien() {
        String maNhanVien = txtMaNhanVien.getText();
        String hoVaTen = txtHoVaTen.getText();
        String tuoi = txtTuoi.getText();
        String email = txtEmail.getText();
        String luong = txtLuong.getText();
        if (maNhanVien.isEmpty()) {
            showMessageDialog("Vui Lòng Điền Mã Nhân Viên");
            return null;
        }
        if (hoVaTen.isEmpty()) {
            showMessageDialog("Vui Lòng Điền Họ Và Tên");
            return null;
        }
        if (tuoi.isEmpty()) {
            showMessageDialog("Vui Lòng Điền Tuổi");
            return null;
        }
        if (email.isEmpty()) {
            showMessageDialog("Vui Lòng Điền Email");
            return null;
        }
        if (luong.isEmpty()) {
            showMessageDialog("Vui Lòng Điền Lương");
            return null;
        }
        if (!luong.matches("\\d+")) {
            showMessageDialog("Lương Không Đúng Định Dạng");
            return null;
        }
        if (!tuoi.matches("\\d+")) {
            showMessageDialog("Tuổi Không Đúng Định Dạng");
            return null;
        }
//        for (NhanVien nhanVien : list) {
//            if (maNhanVien.equalsIgnoreCase(nhanVien.getMaNhanVien())){
//                showMessageDialog("Nhân Viên Đã Tồn Tại");
//                return null;
//            }
//            
//        }
        return new NhanVien(maNhanVien, hoVaTen, Integer.valueOf(tuoi), email, Integer.valueOf(luong));

    }
    public void deleteNhanVien(){
        if (showTrueFalseDialog("Bạn Có Muốn Xóa Nhân Viên Này", "Xóa Nhân Viên") == 0) {
            showMessageDialog(nhanVienService.deleteNhanVien(indexTbl));
            loadData(list);
            indexTbl = 0;
            showDataForm();
        }
        
    }

    public void add_update_NhanVien() {
        if (indexTbl == -1) {
            NhanVien nhaVien = getObjNhanVien();
            showMessageDialog(nhanVienService.addNhanVien(nhaVien));
            if (nhaVien != null) {
                indexTbl = list.size()-1;
            }
            
        }
        else{
            showMessageDialog(nhanVienService.editNhanVien(indexTbl, getObjNhanVien()));
        }
        loadData(list);
        
    }

    public void next() {
        indexTbl += 1;
        if (indexTbl > list.size() - 1) {
            indexTbl = 0;
        }
        showDataForm();
    }
    public void maxPrev(){
        indexTbl = 0;
        showDataForm();
    }
    public void maxNext(){
        indexTbl = list.size() - 1;
        showDataForm();
    }

    public void prev() {
        indexTbl -= 1;
        if (indexTbl < 0) {
            indexTbl = list.size() - 1;
        }
        showDataForm();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtHoVaTen = new javax.swing.JTextField();
        txtMaNhanVien = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtLuong = new javax.swing.JTextField();
        txtTuoi = new javax.swing.JTextField();
        btnNew = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnOpen = new javax.swing.JButton();
        btnMaxPrev = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnMaxNext = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        lbRecord = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        lbClock = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 255));
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");

        jLabel2.setText("Mã Nhân Viên");

        jLabel3.setText("Họ Và Tên");

        jLabel4.setText("Email");

        jLabel5.setText("Tuổi");

        jLabel6.setText("Lương");

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnOpen.setText("Open");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        btnMaxPrev.setText("|<");
        btnMaxPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaxPrevActionPerformed(evt);
            }
        });

        btnPrev.setText("<<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnMaxNext.setText(">|");
        btnMaxNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaxNextActionPerformed(evt);
            }
        });

        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        lbRecord.setForeground(new java.awt.Color(204, 0, 51));
        lbRecord.setText("Record 1 of 10");

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
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
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);

        lbClock.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbClock.setForeground(new java.awt.Color(255, 51, 102));
        lbClock.setText("00;00;00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbClock, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtHoVaTen))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(42, 42, 42)
                                                .addComponent(btnMaxPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnMaxNext, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lbRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                                            .addComponent(txtEmail)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(14, 14, 14)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbClock, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtHoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSave))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnDelete)))
                    .addComponent(btnNew))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnFind))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOpen)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExit)
                    .addComponent(btnMaxNext)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnMaxPrev)
                        .addComponent(btnPrev)
                        .addComponent(btnNext)
                        .addComponent(lbRecord)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        add_update_NhanVien();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        // TODO add your handling code here:
        TblClicked();
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void btnMaxPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaxPrevActionPerformed
        // TODO add your handling code here:
        maxPrev();
    }//GEN-LAST:event_btnMaxPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        prev();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnMaxNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaxNextActionPerformed
        // TODO add your handling code here:
        maxNext();
    }//GEN-LAST:event_btnMaxNextActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        deleteNhanVien();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        // TODO add your handling code here:
        boolean findStatus = findNhanVien();
        if (findStatus == true) {
            showMessageDialog("Tìm Thành Công");
        }
        else{
            showMessageDialog("Tìm Thất Bại");
        }
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        showMessageDialog(nhanVienService.saveFileTxt());
        if (showTrueFalseDialog("Bạn Có Muốn Thoát Không", "Thoát Chương Trình?") == 0) {
            System.exit(0);
        }
        
        
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        // TODO add your handling code here:
        openData();
    }//GEN-LAST:event_btnOpenActionPerformed

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
            java.util.logging.Logger.getLogger(NhanhVienView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhanhVienView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhanhVienView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanhVienView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhanhVienView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnMaxNext;
    private javax.swing.JButton btnMaxPrev;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbClock;
    private javax.swing.JLabel lbRecord;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoVaTen;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtTuoi;
    // End of variables declaration//GEN-END:variables
}
