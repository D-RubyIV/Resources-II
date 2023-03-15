/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_Interface;

/**
 *
 * @author phamh
 */
public class javaInterface {

	public static void main(String[] args) {
		Dog d = new Dog();
		d.run();
		d.eat();

	}

}

interface Animals {

	public void run();
}

interface Animals1 {

	public void eat();
}

class Dog implements Animals, Animals1 {

	@Override
	public void run() {
		System.out.println("Dog Run");

	}

	@Override
	public void eat() {
		System.out.println("Dog Eat");

	}

}
