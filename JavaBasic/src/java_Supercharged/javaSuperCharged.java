/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_Supercharged;

/**
 *
 * @author phamh
 */
public class javaSuperCharged {
	public static void main(String[] args) {
		HinhHoc hh = new HinhHoc();
		hh.DienTich(5);
		hh.DienTich(5, 6);
		
	}
	
}

class HinhHoc{
	public void DienTich(int a){
		int DienTich = a*a;
		System.out.println("Dien Tich Hinhf Vuong La:" + DienTich);
	}
	
	public void DienTich(int a, int b){
		int DienTich = a*b;
		System.out.println("Dien Tich HCN:" + DienTich);
	}
}
