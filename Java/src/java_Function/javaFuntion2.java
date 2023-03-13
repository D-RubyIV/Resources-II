/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_Function;

/**
 *
 * @author phamh
 */
public class javaFuntion2 {
	public static void main(String[] args) {
		SinhVien sv = new SinhVien("Dion");
		sv.DiHoc();
		SinhVien sv1 = new SinhVien();
		
		
	}
	
}

class SinhVien{
	public SinhVien(String Ten){
		System.out.println("Đây là hàm tạo của " + Ten);
	}
	public SinhVien(){
		System.out.println("Đây là hàm tạo của");
	}
	public void DiHoc(){
		System.out.println("Tôi ĐI Học");
	}
}
