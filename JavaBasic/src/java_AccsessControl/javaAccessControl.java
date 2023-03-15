/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_AccsessControl;

/**
 *
 * @author phamh
 */
public class javaAccessControl {

	public static void main(String[] args) {
		SinhVien sv = new SinhVien();
		sv.setTen("Dion");
		sv.setDiem(10);
		sv.info();

	}

}

class SinhVien {
	private String ten;
	private int diem;

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
	public void info(){
		System.out.printf("Ten: %s \n Diem: %s \n", ten, diem);
	}


	
	

}
