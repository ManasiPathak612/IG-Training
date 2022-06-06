package com.designpattern.singleton;
public class EarlyInitializationImp {
 
    public static void main(String[] args) {
        // access instance of SingletonCls using getInstance() method
        EarlyInitializationSingleton instance = EarlyInitializationSingleton.getInstance();
        instance.setMessage("This message is set in main of Singleton!");
        displayMsg();
    }
     
    public static void displayMsg(){
    	EarlyInitializationSingleton instance = EarlyInitializationSingleton.getInstance();
        System.out.println(instance.getMessage());
    }
}
