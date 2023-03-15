/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author phamh
 */
public class javaDateTime {
	public static void main(String[] args) {
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat sd = new SimpleDateFormat("HH:mm");
		String time1 = sdf.format(dt.getTime());
		String time2 = sd.format(dt.getTime());

		
		System.out.println(time1);
		System.out.println(time2);

		
		
		
	}
	
}
