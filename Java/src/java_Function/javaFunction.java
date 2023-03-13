/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_Function;

/**
 *
 * @author phamh
 */
public class javaFunction {

	public static void main(String[] args) {
		int a = 2, b = 3;
		sum(a,b);
		System.out.println("Multiplication " + a +"*"+ b +"="+ multipliction(a, b));

	}

	public static void sum(int a, int b) {
		int sum = a + b;
		System.out.println("Sum:" + sum);
	}
	public static int multipliction(int a, int b) {
		int mul = a * b;
		return mul;
	}
	
}
