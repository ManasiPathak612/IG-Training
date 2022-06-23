package com.example.demo;

class UserDefinedException extends Exception {

    public UserDefinedException	(String str)  
    {   
        super(str);  
    }  
}  
// Class that uses above MyException  
public class UserDefined  
{  
    public static void main(String args[])  
    {  
        try  
        {  
            throw new UserDefinedException("This is user-defined exception");  
        }  
        catch (UserDefinedException ude)  
        {  
            System.out.println("Caught the exception");  
            System.out.println(ude.getMessage());  
        }  
    }  
}
