package com.java.lambdaExpressions;

import java.util.ArrayList;
import java.util.List;

public class LambdaExpr {
	public static void main(String args[]) {
		ArrayList<Integer> numbers1 = new ArrayList<Integer>();
	    numbers1.add(5);
	    numbers1.add(9);
	    numbers1.add(8);
	    numbers1.add(1);
	    numbers1.forEach( (n) -> { System.out.println(n); } );
	}
}
