package com.oops.encapsulation;

class Perimeter {
	  int length;
	  int breadth;
	  Perimeter(int length, int breadth) {
	    this.length = length;
	    this.breadth = breadth;
	  }
	  public void getPerimeter() {
	    int perimeter = 2 * (length +  breadth);
	    System.out.println("Perimeter of Rectangle : " + perimeter);
	  }
	}
	class Test {
	  public static void main(String[] args) {
	    Perimeter rectangle = new Perimeter(3, 6);
	    rectangle.getPerimeter();
	  }
	}

