package com.collections.arrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListExample {
	public static void main(String args[]) {
		List<String> topCompanies = new ArrayList<>();

	    System.out.println("Is the topCompanies list empty? : " + topCompanies.isEmpty());
	
	    topCompanies.add("Google");
	    topCompanies.add("Apple");
	    topCompanies.add("Microsoft");
	    topCompanies.add("Amazon");
	    topCompanies.add("Facebook");
	

	    System.out.println("List of companies: " + topCompanies.size());
	    System.out.println(topCompanies);
	

	    String bestCompany = topCompanies.get(0);
	    String secondBestCompany = topCompanies.get(1);
	    String lastCompany = topCompanies.get(topCompanies.size() - 1);
	
	    System.out.println("First Company: " + bestCompany);
	    System.out.println("Second Company: " + secondBestCompany);
	    System.out.println("Last Company in the list: " + lastCompany);

	    topCompanies.set(4, "Walmart");
	    System.out.println("Modified top companies list: " + topCompanies);
	}
}
