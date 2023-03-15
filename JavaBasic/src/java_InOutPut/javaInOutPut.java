/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_InOutPut;

import java.util.Scanner;

/**
 *
 * @author phamh
 */
public class javaInOutPut {
	public static void main(String[] args) {
		
		int a;
		String b;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Input A Number:");
		a = sc.nextInt();
		System.out.println("Number is :" + a);
		
		sc.nextLine();
		System.out.print("Input Your Name:");
		b = sc.nextLine();
		System.out.println("Your Name:" + b);
		
		
		
		
	}
	
}
