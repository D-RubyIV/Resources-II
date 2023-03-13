/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_ClassMethod;

/**
 *
 * @author phamh
 */
public class javaClassMethod {
	public static void main(String[] args) {
		SinhVien sv = new SinhVien();
		sv.ten = "Dion";
		sv.tuoi = 19;
		sv.diem = 10;
		sv.hocBai();
		
		
	}
}

class SinhVien {
	String ten;
	int tuoi ;
	int diem;
	
	public void hocBai(){
		System.out.printf("Sinh Vien:%s \nTuoi:%s \nDiem:%s \n", ten, tuoi, diem);
	}
	
}
