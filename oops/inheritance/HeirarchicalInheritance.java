package com.oops.inheritance;

	class Employee{  
		void work(){
			System.out.println("Employee works!");}  
		}  
		class Developer extends Employee{  
		void developCode(){
			System.out.println("Developer develops code!");}  
		}  
		class Tester extends Employee{  
		void testing(){
			System.out.println("Tester tests the software!");}  
		}  
		class HeirarchicalInheritance{  
		public static void main(String args[]){  
			Developer d=new Developer();  
			d.developCode();  
			d.work();  
		} 
}
