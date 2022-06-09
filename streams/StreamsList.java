package com.streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsList {
	public static void main(String args[]) {
		List<Integer> number = Arrays.asList(2,3,4,5);
	    List<Integer> square = number.stream().map(x -> x*x).collect(Collectors.toList());
	    System.out.println("Square of numbers is:" + square);
	    
	    List<String> names = Arrays.asList("Reflection","Collection","Stream");
	    List<String> result = names.stream().filter(p->p.startsWith("R")).collect(Collectors.toList());
	    System.out.println("Name starting from R:" + result);
	    List<String> sortedList = names.stream().sorted().collect(Collectors.toList());
	    System.out.println("Sorted List is :" + sortedList);
	    
	    List<Integer> numbers = Arrays.asList(2,3,4,5,2);
	    int sum = numbers.stream().reduce(0,Integer::sum);
	    System.out.println("Sum of numbers is:" + sum);
	    int even = number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);
	    System.out.println("Even numbers are:" + even);
	    
	    List<String> origStr = Arrays.asList("india","","japan","norway","","usa");
	    List<String> newStr = origStr.stream().filter(a->!a.isEmpty()).collect(Collectors.toList());
	    System.out.println("Remove empty stream:" + newStr);
	    
	    List<Integer> list1 = Arrays.asList(11,33,22,44,33,66,77,44);
	    HashSet<Integer> set = new HashSet<Integer>();
	    list1.stream().filter(a->!set.add(a)).collect(Collectors.toList()).forEach(System.out::println);
	}
}
