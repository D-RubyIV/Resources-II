/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_StringBuilder;

/**
 *
 * @author phamh
 * 
 * StringBuilder or StringBuffer
 * 
 */
public class javaStringBuilder {
	public static void main(String[] args) {
        		
		long startTime = System.nanoTime(); // Time Start Run
		String dion = "Dion Handsome";
		StringBuilder sb = new StringBuilder(dion);
		for(int i = 0; i < 10; i ++){
			sb.append(" Vcl!!!");
		}
		dion = sb.toString();
		System.out.println(dion);
		long endTime = System.nanoTime();
		System.out.println("Total Time:" + (endTime-startTime) + "ns");
		
	}
	
}
