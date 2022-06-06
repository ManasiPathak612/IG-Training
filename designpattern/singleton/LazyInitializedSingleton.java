package com.designpattern.singleton;


public class LazyInitializedSingleton {
    // singleton instance declaration
    private static LazyInitializedSingleton singletonInst;
    // a variable of singleton class
    private String message = "";
    // making constructor private so that no other class could use the default constructor
    private LazyInitializedSingleton() {
        System.out.println("Singleton instance created.");
    }
     
    // the method which gives access to the only instance of SingletonCls, is thread safe
    public static synchronized LazyInitializedSingleton getInstance(){
        if(singletonInst==null){
            singletonInst = new LazyInitializedSingleton();
            System.out.println("SingletonCls instance created for the first time.");
        }
        return singletonInst;
    }
 
    // getter for the variable message
    public String getMessage() {
        return message;
    }
 
    // setter for the variable message
    public void setMessage(String message) {
        this.message = message;
    }
}