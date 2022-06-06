package com.oops.inheritance;

public class SingleInheritance { 
	float salary = 60000;
}
class Manager extends  SingleInheritance{
	int bonus = 50000;
	public static void main(String args[]) {
		Manager e = new Manager();
		System.out.println(e.salary);
		System.out.println(e.bonus);
	}
}
