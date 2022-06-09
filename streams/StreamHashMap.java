package com.streams;

import java.util.HashMap;

import java.util.stream.Collectors;

public class StreamHashMap {
	public static void main(String args[]) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("Manasi", 10000);
		map.put("Rahul", 15000);
		map.put("Shaila", 25000);
		map.put("Harshad", 20000);
		map.put("Tejopathi", 30000);
		map.entrySet().stream().filter(a->a.getValue() > 15000).map(a->a.getKey()).collect(Collectors.toList()).forEach(System.out::println);
	}
}
