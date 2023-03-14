/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_InterractFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phamh
 */
public class javaInterractFile {

	public static void main(String[] args) throws IOException {
		//Ghi CHuoi
		String fileName = "Demo.txt";
		try {
			FileWriter fw = new FileWriter(new File(fileName));
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("DIon");
			bw.close();

		} catch (IOException ex) {
			Logger.getLogger(javaInterractFile.class.getName()).log(Level.SEVERE, null, ex);

		}

		//Doc Chuoi
		try {
			FileReader fr = new FileReader(new File(fileName));
			BufferedReader br = new BufferedReader(fr);
			String target = "";
			target = br.readLine();

			System.out.println(target);
		} catch (FileNotFoundException ex) {
			Logger.getLogger(javaInterractFile.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

}
