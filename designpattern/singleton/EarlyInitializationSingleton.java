package com.designpattern.singleton;

public class EarlyInitializationSingleton {
    // singleton instance, this instance is created in JVM during start of the application
    private static final EarlyInitializationSingleton singletonInst = new EarlyInitializationSingleton();
     
    // a variable of singleton class
    private String message = "";
     
    // making constructor private so that no other class could use the default constructor
    private EarlyInitializationSingleton() {
    }
     
    // the method which gives access to the only instance of SingletonCls
    public static EarlyInitializationSingleton getInstance(){
        return singletonInst;
    }
 
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
     
}