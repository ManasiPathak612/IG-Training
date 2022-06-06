package com.oops.inheritance;

class ComboOffer{  
		void sale(){
			System.out.println("we are having an offer");}  
	}  
	class Laptop extends ComboOffer{  
			void offer(){System.out.println("It's a offer on laptops!");}  
	}  
	class Dell extends Laptop{  
		void laptopOffer(){System.out.println("It's a offer on Dell laptops!");}  
	}  
	class MultilevelInheritance{  
	public static void main(String args[]){  
		Dell d=new Dell();  
		d.sale();  
		d.offer();  
		d.laptopOffer();  
	}
}  

