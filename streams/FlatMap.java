package com.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap {
	public static void main(String args[]) {

		  String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

		  List<String> collect = Stream.of(array)     
		          .flatMap(Stream::of)                
		          .filter(x -> !"a".equals(x))       
		          .collect(Collectors.toList());     

		  collect.forEach(System.out::println);
	}
}
