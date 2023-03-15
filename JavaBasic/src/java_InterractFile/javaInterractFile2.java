/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_InterractFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author phamh
 */
public class javaInterractFile2 {

	public static void main(String[] args) {
		SinhVien sv = new SinhVien();
		sv.setDiem(10);
		sv.setTuoi(19);
		sv.setTen("Dion");
		
		String fileName = "Demo.txt";
		
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(sv);
			oos.close();
			fos.close();
			
		} catch (IOException e) {
			System.out.println(e);
		}

		

		
	}

}

class SinhVien implements Serializable {

	private String ten;
	private int diem;
	private int tuoi;

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getDiem() {
		return diem;
	}

	public void setDiem(int diem) {
		this.diem = diem;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

}
