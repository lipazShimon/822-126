package a.runtimeExceptionsDemo;

import z.types.animals.Animal;
import z.types.animals.Cat;
import z.types.animals.Dog;

public class Demo1 {

	public static void main(String[] args) {

		try {

			// class cast exception
			Animal animal = new Cat();
			Dog dog = (Dog) animal;
			System.out.println("succes");

			// number format exception
			int x = Integer.parseInt("25.3");

			// array index out of bounds exception
			int[] nums = { 1, 3, 5 };
			System.out.println(nums[9]);

			// negative array size exception
			int[] arr = new int[-3];

			// null point exception
			String str = "abc";
			System.out.println(str.charAt(0));
			str = null;
			System.out.println(str.charAt(0));

			// arithmetic exception
			System.out.println(5 / 0);
		} catch (ArithmeticException e) {
			System.out.println("Arithmetic Exception");
			e.printStackTrace(System.out);
		} catch (NullPointerException e) {
			System.out.println("Null Pointer Exception");
			e.printStackTrace(System.out);
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("END OF DEMO");

	}

}
