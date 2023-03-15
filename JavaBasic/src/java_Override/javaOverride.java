/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_Override;

/**
 *
 * @author phamh
 */
public class javaOverride {
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.run();
		
	}
	
}
class Animals{
	public void run(){
		System.out.println("Dog Run");
	}
}
class Dog extends Animals{
	@Override
	public void run(){
		super.run(); // CHayj ca ham run o lowp cha
		System.out.println("Dog Run.......");
}
	
}