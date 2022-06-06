package com.oops.abstraction;

	interface Area{  
		void draw();  
			static int area(int x,int y){return x*y;}  
		}  
		class Rectangle implements Area{  
		public void draw(){
			System.out.println("drawing rectangle");}  
		}  
	class StaticMethod{  
		public static void main(String args[]){  
			Area d=new Rectangle();  
			d.draw();  
			System.out.println(Area.area(3,4));  
	}
}


