package b.types;

public class Rectangle {

	// attributes
	int length; // primitive - simple type
	int width; // primitive - simple type
	String color; // complex type

	// CTOR (method for object creation)
	Rectangle() {
		System.out.println("a rectangle is created");
		length = 5;
		width = 5;
	}

	// other methods
	int getArea() {
		int area = length * width;
		return area;
	}

}
