/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_InnerClass;

/**
 *
 * @author phamh
 */
public class javaInnerClass {
	public static void main(String[] args) {
		Outer our = new Outer();
		our.outerShow();
	}
	
	
	
}


class Outer{
	public void outerShow(){
		Inner ir = new Inner();
		ir.InnerShow();
	}
	class Inner{
		public void InnerShow(){
			System.out.println("Hello Toi la InnerClass");
		}
		
	}
}