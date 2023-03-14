/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_TryCatch;

import java.util.Scanner;

/**
 *
 * @author phamh
 */
public class javaTryCatch {
	public static void main(String[] args) {
		
		int a, b;
		Scanner sc = new Scanner(System.in);
		System.out.print("Moi b nhap so A:");
		a = sc.nextInt();
		System.out.print("Moi b nhap so B:");
		b = sc.nextInt();
		try {
			System.out.println("Ket Qua A/B:" + a/b);
			
		} catch (Exception e) {
			System.out.println(e);
		} finally{
			System.out.println("Dion Handsome VCL");
		}
		
		
	}
	
}
