/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_TxtFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author phamh
 */
public class javaTxtFile {

	public static void main(String[] args) {
    int a;
    String pathFile = System.getProperty("user.dir") + "\\src\\Data\\" + "Dino.txt";
    createFileExists(pathFile);

    try (Scanner sc = new Scanner(new File(pathFile))) {
        System.out.println("Nhap a");
        a = sc.nextInt();
        System.out.println(a);
		
    } catch (FileNotFoundException e) {
        System.out.println("Error: File not found");
    }
}

public static void createFileExists(String pathFile) {
    File f = new File(pathFile);
    try {
        if (f.createNewFile()) {
            System.out.println("File created");
        } else {
            System.out.println("File already exists");
        }
    } catch (IOException e) {
        System.out.println("Error creating file");
    }
}

}
