/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_Array_Two_Way;

/**
 *
 * @author phamh
 */
public class javaArray {

	public static void main(String[] args) {
		
		
		int[][] matrix = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
		
		System.out.println(matrix[0][2]);
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
		
		
		boolean[][] bools;
		bools = new boolean[5][6]; // 6 hang 7 cot
		bools[0][1]=true;
		bools[4][5]=false;
		System.out.println(bools[0][1]);
		System.out.println(bools[4][5]);
		System.out.println(bools[4][4]);
		
		
		
		
		
		
		
		
	}
}
