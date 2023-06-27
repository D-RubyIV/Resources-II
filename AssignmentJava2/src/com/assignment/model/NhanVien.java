/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assignment.model;

import java.io.Serializable;

/**
 *
 * @author phamh
 */
public class NhanVien implements Serializable{
    private String maNhanVien;
    private String hoVaTen;
    private int tuoi;
    private String email;
    private int luong;

    public NhanVien(String maNhanVien, String hoVaTen, int tuoi, String email, int luong) {
        this.maNhanVien = maNhanVien;
        this.hoVaTen = hoVaTen;
        this.tuoi = tuoi;
        this.email = email;
        this.luong = luong;
    }

    public NhanVien() {
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLuong() {
        return luong;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "maNhanVien=" + maNhanVien + ", hoVaTen=" + hoVaTen + ", tuoi=" + tuoi + ", email=" + email + ", luong=" + luong + '}';
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }
    
    
    
}
