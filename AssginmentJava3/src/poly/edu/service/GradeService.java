/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.service;

import java.util.List;
import poly.edu.model.Grade;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import poly.edu.database.DBContext;
import poly.edu.model.Student;

/**
 *
 * @author phamh
 */
public class GradeService {

    public List<Grade> getAllGrade() {
        List<Grade> list = new ArrayList<>();
        String sql = "SELECT *, (tiengAnh + tinHoc + GDTC) / 3.0 AS diemTrungBinh\n" +
                     "FROM STUDENTS FULL JOIN GRADES ON STUDENTS.maSV = GRADES.maSV\n" +
                     "ORDER BY diemTrungBinh DESC;";
        try {
            Statement st = new DBContext().getConnect().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                list.add(new Grade(rs.getString("maSv"), rs.getInt("tiengAnh"), rs.getInt("tinHoc"), rs.getInt("GDTC")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    public Grade searchByMaSV(String maSv){
        String sql = "SELECT * FROM STUDENTS FULL JOIN GRADES ON STUDENTS.maSV = GRADES.maSV WHERE STUDENTS.maSv like '" + maSv + "'";
        try {
            Statement st = new DBContext().getConnect().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                return new Grade(rs.getString("maSv"), rs.getInt("tiengAnh"), rs.getInt("tinHoc"), rs.getInt("GDTC"));
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return null;
        
    }    
    

    

    public Map<String, Object[]> getAllInfoSV() {
        Map<String, Object[]> map = new LinkedHashMap<>();
        String sql = "SELECT TOP 3 *, (tiengAnh + tinHoc + GDTC) / 3.0 AS diemTrungBinh FROM STUDENTS FULL JOIN GRADES ON STUDENTS.maSV = GRADES.maSV ORDER BY diemTrungBinh DESC";
        try {
            Statement st = new DBContext().getConnect().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Object[] obj = {rs.getString("maSv"), rs.getString("hoTen"), rs.getInt("tiengAnh"), rs.getInt("tinHoc"), rs.getInt("GDTC"),Math.round(rs.getFloat("diemTrungBinh")*10.0f)/ 10.0f};
                map.put(rs.getString("maSv"), obj);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return map;
    }
    public Map<String, Object[]> getAllInfoSVHavePoint() {
        Map<String, Object[]> map = new LinkedHashMap<>();
        String sql = "SELECT TOP 3 *, (tiengAnh + tinHoc + GDTC) / 3.0 AS diemTrungBinh FROM STUDENTS JOIN GRADES ON STUDENTS.maSV = GRADES.maSV ORDER BY diemTrungBinh DESC";
        try {
            Statement st = new DBContext().getConnect().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Object[] obj = {rs.getString("maSv"), rs.getString("hoTen"), rs.getInt("tiengAnh"), rs.getInt("tinHoc"), rs.getInt("GDTC"),Math.round(rs.getFloat("diemTrungBinh")*10.0f)/ 10.0f};
                map.put(rs.getString("maSv"), obj);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return map;
    }

    public String addGrade(Grade grade) {
        Connection con = new DBContext().getConnect();
        String sql = "INSERT GRADES (maSV, tiengAnh, tinHoc, GDTC) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, grade.getMaSv());
            st.setInt(2, grade.getTiengAnh());
            st.setInt(3, grade.getTinHoc());
            st.setInt(4, grade.getGdtc());
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

    public String deleteGrade(String maSv) {
        Connection con = new DBContext().getConnect();
        String sql = "DELETE FROM GRADES WHERE maSv = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, maSv);
            int result = st.executeUpdate();
            if (result > 0) {
                return "Xoa Thanh Cong";
            }
            return "Xoa That Bai";
        } catch (Exception e) {
            return "Xoa Loi: " + e;
        }
    }

    public String updateGrade(Grade grade) {
        String sql = "UPDATE GRADES SET tiengAnh=?, tinHoc=?, GDTC=? WHERE maSv=?";
        try {
            PreparedStatement st = new DBContext().getConnect().prepareStatement(sql);
            st.setInt(1, grade.getTiengAnh());
            st.setInt(2, grade.getTinHoc());
            st.setInt(3, grade.getGdtc());
            st.setString(4, grade.getMaSv());
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
