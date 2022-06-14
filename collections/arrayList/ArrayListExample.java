package com.collections.arrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListExample {
	public static void main(String args[]){  
		  List<String> list1=new ArrayList<String>();  
		  list1.add("Mango");  
		  list1.add("Apple");  
		  list1.add("Banana");  
		  list1.add("Grapes");  
		  System.out.println("Returning element: "+list1.get(2));
		  list1.set(2,"Papaya");  
		  Collections.sort(list1);  
		  for(String fruit:list1)  
		    System.out.println(fruit);  
	}
}
