package com.example.demo;

class MyCustomException extends Exception  
{  
    
}  
public class CustomException {
	public static void main(String args[])  
    {  
        try  
        {    
            throw new MyCustomException();  
        }  
        catch (MyCustomException ex)  
        {  
            System.out.println("Caught the exception");  
            System.out.println(ex.getMessage());  
        }  
  
        System.out.println("rest of the code...");    
    }  
}
