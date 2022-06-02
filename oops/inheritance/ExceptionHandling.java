package com.oops.inheritance;

class SuperClass {
	void method() throws RuntimeException
    {
        System.out.println("SuperClass");
    }
}
class ExceptionHandling extends SuperClass {
    void method() throws ArithmeticException
    {
        System.out.println("SubClass");
    }
    public static void main(String args[])
    {
    	SuperClass s = new ExceptionHandling();
        s.method();
    }
}