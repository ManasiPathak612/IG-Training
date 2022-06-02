package com.oops.abstraction;

abstract class beverage {
	public abstract void beverageType();
	  public void type() {
	    System.out.println("Beverage is hot drink");
	  }
	}
	class Tea extends beverage {
		  public void beverageType() {
		    System.out.println("Beverage is Tea");
		  }
	}
	class Abstraction{
		public static void main(String[] args) {
			Tea t = new Tea();
			t.type();
			t.beverageType();
		}
	}


