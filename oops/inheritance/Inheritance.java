package com.oops.inheritance
;

public class Inheritance { 
	float salary = 60000;
}
class employee extends  Inheritance{
	int bonus = 50000;
	public static void main(String args[]) {
		employee e = new employee();
		System.out.println(e.salary);
		System.out.println(e.bonus);
	}
}
