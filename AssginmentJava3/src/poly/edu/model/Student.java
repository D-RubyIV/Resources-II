/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.model;

/**
 *
 * @author phamh
 */
public class Student {
    private String maSv;
    private String hoTen;
    private String email;
    private String soDt;
    private int gioiTinh;
    private String diaChi;
    private String hinh;

    public Student(String maSv, String hoTen, String email, String soDt, int gioiTinh, String diaChi, String hinh) {
        this.maSv = maSv;
        this.hoTen = hoTen;
        this.email = email;
        this.soDt = soDt;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.hinh = hinh;
    }

    public Student() {
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDt() {
        return soDt;
    }

    public void setSoDt(String soDt) {
        this.soDt = soDt;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }
    
    
    
    
}
