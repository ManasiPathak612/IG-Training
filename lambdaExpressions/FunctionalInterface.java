package com.lambdaExpressions;

interface Addition{  
    int add(int a,int b);  
}  
	  
public class FunctionalInterface{  
    public static void main(String[] args) {   
    	Addition ad1=(a,b)->(a+b);  
        System.out.println(ad1.add(10,20));  
          
        Addition ad2=(int a,int b)->(a+b);  
        System.out.println(ad2.add(100,200));  
    }  
}  
