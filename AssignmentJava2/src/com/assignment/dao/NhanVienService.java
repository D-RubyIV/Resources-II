/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assignment.dao;

import com.assignment.model.NhanVien;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phamh
 */
public class NhanVienService {

    List<NhanVien> listNhanVien = new ArrayList<>();
    String pathFileTxt = "NhanVienObj.txt";

    public List<NhanVien> fakeData() {
        listNhanVien.add(new NhanVien("NV001", "Pham Van AAA", 18, "phamvanaaa@gmail.com", 1000));
        listNhanVien.add(new NhanVien("NV002", "Pham Van BBB", 19, "phamvanbbb@gmail.com", 2000));
        listNhanVien.add(new NhanVien("NV003", "Pham Van CCC", 20, "phamvanccc@gmail.com", 3000));
        listNhanVien.add(new NhanVien("NV004", "Pham Van DDD", 21, "phamvanddd@gmail.com", 4000));
        listNhanVien.add(new NhanVien("NV005", "Pham Van EEE", 22, "phamvaneee@gmail.com", 5000));
        return listNhanVien;
    }

    public String addNhanVien(NhanVien nhanVien) {
        if (nhanVien != null) {
            listNhanVien.add(nhanVien);
            return "Thêm Thành Công";
        }
        return "Thêm Thất Bại";
    }

    public String editNhanVien(int index, NhanVien nhanVien) {
        if (index >= 0) {
            if (nhanVien != null) {
                listNhanVien.set(index, nhanVien);
                return "Sửa Thành Công";
            }
            return "Sửa Thất Bại";
        }
        return "Sửa Thất Bại - Vị Trí < 0";
    }

    public String deleteNhanVien(int index) {
        if (index >= 0) {
            listNhanVien.remove(index);
            return "Xóa Thành Công";
        }
        return "Xóa Thất Bại - Vị Trí < 0";
    }

    public String saveFileTxt() {
        File f = new File(pathFileTxt);
        try {
            if (!f.exists()) {
                f.createNewFile();
            }
            try (FileOutputStream fos = new FileOutputStream(f); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                for (NhanVien nhanVien : listNhanVien) {
                    oos.writeObject(nhanVien);
                }
            }
            return "Ghi file thành công!";

        } catch (Exception e) {
            System.out.println(e);
            return "Ghi file thất bại!";
        }
    }
    public String saveFile2(){
        File f = new File(pathFileTxt);
        try {
            try(FileOutputStream fos = new FileOutputStream(f); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                for (NhanVien nhanVien : listNhanVien) {
                    oos.writeObject(nhanVien);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            return "Loi";
        }
        return "Thanh Cong";
    }
    public void readFile2(){
        File f = new File(pathFileTxt);
        try {
            try(FileInputStream fis = new FileInputStream(f); ObjectInputStream ois = new ObjectInputStream(fis)){
            while(fis.available() > 0)
                listNhanVien.add((NhanVien) ois.readObject());
            }
        } catch (Exception e) {
        }
    }
    public String readFileTxt() {
        File f = new File(pathFileTxt);
        try {
            if (!f.exists()) {
                return "File Không Tồn Tại";
            }
            try (FileInputStream fis = new FileInputStream(f); ObjectInputStream ois = new ObjectInputStream(fis)) {
                listNhanVien.clear();
                while (fis.available()>0) {
                    listNhanVien.add((NhanVien) ois.readObject());
                }
            }
            return "Đọc Thành Công";

        } catch (Exception e) {
            return "Ok";
        }
    }

}
