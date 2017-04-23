package com.java.Test;

/**
 * Created by BHUVKUMA on 21-Jun-15.
 */
class A{
    public void print(){
        System.out.println("In A");
    }
    public int add(int i, int j){
        return i+j;
    }
    public int subtract(int i, int j){
        return i-j;
    }

}
class B extends A{
    public void print(){
        System.out.println("In B");
    }

}
public class Test {
    public static void main(String[] args){
        A a = new A();
        B b = new B();
        A a1 = new B();
        //a.print();
        B b1 = new B();
        A testA = b1;
        B b2 = (B) testA;
        A a2 = (A) new B();


        //b.print();
        //a1.print();
        b2.print();
        //a2.print();
      //  b1.bb();

    }
}
