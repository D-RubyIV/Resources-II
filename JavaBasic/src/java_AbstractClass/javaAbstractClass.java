/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package java_AbstractClass;

/**
 *
 * @author phamh
 */
public class javaAbstractClass {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		// TODO code application logic here
		Dog d = new Dog();
		d.run();
	}
}

//ko the tao dc doi tuong tu mot lop abstract
//neu 1 lop thua ke abstract class thi phai ghi de noi dung cho toan bo phuong thuc class
//trong abstract class co th co cac phuong thuc, co noi dung, va khonf co bat ki mot phuong thuc abstrast class
//nhung chi can co it nhat mot phuong thuc la abstract thi class do bat buoc phai la abstract class

abstract class Animal{
	public abstract void run();
}

class Dog extends Animal{
	
	@Override
	public void run(){
		System.out.println("Dog Run");
	}
	
	
}