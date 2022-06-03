package com.oops.polymorphism;

class Parent {
  void print() {
    System.out.println("Hi I am parent");
  }
}
class Child extends Parent {
  void print() {
    System.out.println("Hi I am children");
  }
}
class Overload {
  void statement(String name) {
    System.out.println("Hi myself " + name);
  }
  void statement(String fname, String lname) {
    System.out.println("Hi myself " + fname + " " + lname);
  }
}
public class Main {
  public static void main(String[] args) {
    Parent obj1;
    obj1 = new Parent();
    obj1.print();
    obj1 = new Child();
    obj1.print();
    Overload obj2 = new Overload();
    obj2.statement("Manasi");
    obj2.statement("Manasi", "Pathak.");
  }
}