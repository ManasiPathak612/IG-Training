package com.oops.polymorphism;
	// Base Class
	class Person {
		void name()
		{
			System.out.println("Person's name()");
		}
	}
	// Inherited class
	class Employee extends Person {
		@Override
		void name()
		{
			System.out.println("Employee's name()");
		}
	}
	// Driver class
	class MethodOverriding {
		public static void main(String[] args)
		{
			Person obj1 = new Person();
			obj1.name();

			Person obj2 = new Employee();
			obj2.name();
		}
	}
