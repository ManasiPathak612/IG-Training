package com.designpattern.singleton;

import java.lang.reflect.Constructor;

public class ReflectionSingleton {

	    public static void main(String[] args) {
	    	EarlyInitializationSingleton instanceOne = EarlyInitializationSingleton.getInstance();
	    	EarlyInitializationSingleton instanceTwo = null;
	        try {
	            Constructor[] constructors = EarlyInitializationSingleton.class.getDeclaredConstructors();
	            for (Constructor constructor : constructors) {
	                //Below code will destroy the singleton pattern
	                constructor.setAccessible(true);
	                instanceTwo = (EarlyInitializationSingleton) constructor.newInstance();
	                break;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        System.out.println(instanceOne.hashCode());
	        System.out.println(instanceTwo.hashCode());
	    }

	}
