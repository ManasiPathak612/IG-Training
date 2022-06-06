package com.designpattern.singleton;

	public class LazyInitializationImp {
	 
	    public static void main(String[] args) {
	        System.out.println("Starting of ExamplePgm..");
	        // access instance of SingletonCls using getInstance() method
	        LazyInitializedSingleton instance = LazyInitializedSingleton.getInstance();
	        instance.setMessage("This message is set in main of ExamplePgm");
	        displayMsg();
	    }
	     
	    public static void displayMsg(){
	        // SingletonCls.getInstance() gets the instance that is already created during the call in main() method, for the first time.
	    	LazyInitializedSingleton instance = LazyInitializedSingleton.getInstance();
	        System.out.println(instance.getMessage());
	    }
	}

