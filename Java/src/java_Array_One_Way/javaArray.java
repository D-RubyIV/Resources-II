/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_Array_One_Way;

import java.util.Arrays;

/**
 *
 * @author phamh
 */
public class javaArray {
	@SuppressWarnings("empty-statement")
	public static void main(String[] args) {
		//Array initialization
		int[] mangDion = {1,2,3,4,5};
		String[] friends = {"Dion", "Onion"};
		
		System.out.println(Arrays.toString(mangDion));
		System.out.println(Arrays.toString(friends));
		
		System.out.println("Lenght mangDion: " + mangDion.length);
		
		System.out.println("First magDion'Element: " + mangDion[0]);
		mangDion[0] = 5;
		System.out.println("First magDion'Element After Assign Value: " + mangDion[0]);
		
		for(int i= 0; i < friends.length; i++){
			System.out.println(friends[i]);
		}
		
		int[] array = new int[100]; //Cấp phát bộ nhớ
		System.out.println(array[10]);
		
		String[] array2 = new String[100];

		System.out.println(array2[99]);
		
		
		
	}
	
}
