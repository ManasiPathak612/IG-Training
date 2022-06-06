package com.oops.abstraction;

interface Beverages{
		void makeBeverage();  
		default void msg()
		{
			System.out.println("Make beverage");}  
		}  
		class Juice implements Beverages{  
		public void makeBeverage(){
			System.out.println("Make Juice");
			}  
		}  
		public class DefaultMethod{  
		public static void main(String args[]){  
			Beverages d=new Juice();  
			d.makeBeverage();  
			d.msg();  
		}
	}  
