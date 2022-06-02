	package com.oops.abstraction;

	interface College {
		void collegeName();
		void getBranch();
		void getYear();
	}

	abstract class Student implements College {

		@Override public void collegeName()
		{
			System.out.println("College Name is SVPCET");
		}
		@Override public void getYear()
		{
			System.out.println("Year is final year");
		}
	}

	class branch extends Student {
		@Override public void getBranch()
		{
			System.out.println("Branch is IT");
		}
	}

	public class AbstractionInterface {
		public static void main(String[] args)
		{
			branch b = new branch();
			b.collegeName();
			b.getBranch();
			b.getYear();
		}
	}

