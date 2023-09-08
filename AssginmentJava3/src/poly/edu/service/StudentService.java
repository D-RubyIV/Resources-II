/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.service;

import java.util.List;
import poly.edu.model.Student;
import java.sql.*;
import java.util.ArrayList;
import poly.edu.database.DBContext;

/**
 *
 * @author phamh
 */
public class StudentService {

    public List<Student> getAllStudent() {
        List<Student> list = new ArrayList<>();
        Connection con = new DBContext().getConnect();
        String sql = "SELECT * FROM STUDENTS";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String maSv = rs.getString("maSV");
                String hoTen = rs.getString("hoTen");
                String email = rs.getString("email");
                String soDt = rs.getString("soDt");
                int gioiTinh = rs.getInt("gioiTinh");
                String diaChi = rs.getString("diaChi");
                String hinh = rs.getString("hinh");
                list.add(new Student(maSv, hoTen, email, soDt, gioiTinh, diaChi, hinh));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public String getNameSvByMaSv(String maSv) {
        Connection con = new DBContext().getConnect();
        String sql = "SELECT * FROM STUDENTS WHERE maSV LIKE '" + maSv + "'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                return rs.getString("hoTen");
            }
            return "";
        } catch (Exception e) {
            return "Error";
        }
    }

    public boolean checkExitMaSV(String maSv) {
        Connection con = new DBContext().getConnect();
        String sql = "SELECT * FROM STUDENTS WHERE maSV LIKE '" + maSv + "'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error Check Exit: " + e);
        }
        return false;
    }

    public String addStudent(Student student, List<Student> list) {
        if (checkExitMaSV(student.getMaSv()) == true) {
            return "MaSV đã tồn tại";
        }
        Connection con = new DBContext().getConnect();
        String sql = "INSERT STUDENTS (maSV, hoTen, email, soDt, gioiTinh, diaChi, hinh) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, student.getMaSv());
            st.setString(2, student.getHoTen());
            st.setString(3, student.getEmail());
            st.setString(4, student.getSoDt());
            st.setInt(5, student.getGioiTinh());
            st.setString(6, student.getDiaChi());
            st.setString(7, student.getHinh());
            System.out.println(st.toString());
            int result = st.executeUpdate();
            if (result > 0) {
                return "Them Thanh Cong";
            }
            return "Them That Bai";
        } catch (Exception e) {
            return "Them Loi: " + e;
        }
    }

    public String deleteStudent(String msSv) {
        Connection con = new DBContext().getConnect();
        String sql = "DELETE FROM STUDENTS WHERE maSv = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, msSv);
            int result = st.executeUpdate();
            if (result > 0) {
                return "Xoa Thanh Cong";
            }
            return "Xoa That Bai";
        } catch (Exception e) {
            return "Xoa Loi: " + e;
        }
    }

    public String updateStudent(Student student) {
        Connection con = new DBContext().getConnect();
        String sql = "UPDATE STUDENTS SET hoTen=?,email=?, soDt=?, gioiTinh=?, diaChi=?, hinh=? WHERE maSv LIKE ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, student.getHoTen());
            st.setString(2, student.getEmail());
            st.setString(3, student.getSoDt());
            st.setInt(4, student.getGioiTinh());
            st.setString(5, student.getDiaChi());
            st.setString(6, student.getHinh());
            st.setString(7, student.getMaSv());
            int result = st.executeUpdate();
            if (result > 0) {
                return "Update Thanh Cong";
            }
            return "Update That Bai";
        } catch (Exception e) {
            return "Update Loi: " + e;
        }
    }
}
