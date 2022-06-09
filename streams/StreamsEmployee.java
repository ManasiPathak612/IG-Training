package com.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsEmployee {
	private long empId;
	private String name;
	private int age;
	private String designation;
 
	public StreamsEmployee(long empId, String name, int age, String designation) {
	    super();
	    this.empId = empId;
	    this.name = name;
	    this.age = age;
	    this.designation = designation;
  }

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public static void main(String[] args){       
		  List<StreamsEmployee> empList = new ArrayList<StreamsEmployee>();
		  empList.add(new StreamsEmployee(1,"John",45,"Manager"));
		  empList.add(new StreamsEmployee(2,"Martin",32,"Senior Manager"));
		  empList.add(new StreamsEmployee(1,"Mary",26,"Developer"));
		  empList.add(new StreamsEmployee(3,"Manasi",28,"Senior Developer"));
		  empList.add(new StreamsEmployee(1,"Robin",35,"Reporting Manager"));
		  empList.add(new StreamsEmployee(1,"Jack",50,"Manager"));
		       
		  List<StreamsEmployee> tempList = empList.stream()
		              .filter(e -> "Manager".equalsIgnoreCase(e.getDesignation()) && e.getAge() > 30)
		              .collect(Collectors.toList());
		   
		  tempList.forEach(e -> System.out.println("Name: " + e.getName() + " ,Designation: " + e.getDesignation() + " , Age: " + e.getAge()));       
		}
}

