/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_Condition;

/**
 *
 * @author phamh
 */
public class javaCondition {

	public static void main(String[] args) {
		int a = 5, b = 5;
		boolean result = a == b;
		String dinoHandsome = "Dino Đẹp Trai VCL";

		if (result == true) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		if (dinoHandsome.equalsIgnoreCase("Dino Đẹp Trai VCL")) {
			System.out.println("Dino Biết Mình Đep Trai Rồi");
		}
		else{
			System.out.println("Dino Đẹp Trai Mà =))");
		}
		if (result == true && dinoHandsome.equalsIgnoreCase("Dino Đẹp Trai VCL") == true) {
			System.out.println("....................End Code");			
		}
	}

}
