/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.model;

/**
 *
 * @author phamh
 */
public class Grade {
    private String maSv;
    private int tiengAnh;
    private int tinHoc;
    private int gdtc;

    public Grade(String maSv, int tiengAnh, int tinHoc, int gdtc) {
        this.maSv = maSv;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.gdtc = gdtc;
    }

    public Grade() {
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public int getTiengAnh() {
        return tiengAnh;
    }

    public void setTiengAnh(int tiengAnh) {
        this.tiengAnh = tiengAnh;
    }

    public int getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(int tinHoc) {
        this.tinHoc = tinHoc;
    }

    public int getGdtc() {
        return gdtc;
    }

    public void setGdtc(int gdtc) {
        this.gdtc = gdtc;
    }

    public float getDiemTrungBinh() {
        float dtb = (this.gdtc + this.tiengAnh + this.tinHoc) / 3;
        Float roundNumber = Math.round(dtb * 10.0f) / 10.0f;
        System.out.println(roundNumber);
        return roundNumber;
    }


    
    
    
}
