/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_Inheritance;

/**
 *
 * @author phamh
 */
public class javaInheritance {

	public static void main(String[] args) {
		Dog g = new Dog();

	}

}

class Animal {

	public void run() {
		System.out.println("Animal Run");
	}
}

class Eat extends Animal {
    
	public Eat(String ten) {
		System.out.println("Name Animal " + ten);
	}

	public Eat() {
	}

	public void eat() {
		System.out.println("Eat Meal");
	}

}
// Extends chir ke thua cac phuong thuc public

class Dog extends Eat {

	public Dog() {
		Eat e = new Eat("OOO");
		run();
		eat();

	}

}
