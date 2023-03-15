/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_Static;

/**
 *
 * @author phamh
 */
public class javaStatic {
	public static void main(String[] args) {
		SinhVien.DiHoc();
		System.out.println(SinhVien.ten);
	}
	
}


class SinhVien{
	public static final String ten = "Pham Ha ANh";
	public static void DiHoc(){
		System.out.println("Dion Di Hoc");
	}
}
