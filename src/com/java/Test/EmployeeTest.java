package com.java.Test;

//import java.lang.reflect.Field;

import java.lang.reflect.Field;

/**
 * Created by BHUVKUMA on 04-May-15.
 */
class Emp{
    public Emp(int age, String name, int salary) {
        this.age = age;
        this.name = name;
        this.salary = salary;
    }

    int age;
    String name;
    int salary;

    void printValue(String attribute){
        //System.out.println(attribute + " is : "+this.attribute);
    }
}

public class EmployeeTest {
    public static void main(String[] args){
        Emp ram = new Emp(12, "Ram", 1000);
        Emp shyam = new Emp(15, "Shyam", 2000);

 myFun(ram, "name");

        //System.out.println(ramName);
    }



    static void myFun(Emp employee, String attribute)
    {
        Class<?> c = employee.getClass();
        Field member = null;//c.getDeclaredField(attribute);
        try {
            member = c.getDeclaredField(attribute);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        System.out.printf(member.toString());
       // member.ge
    }

}
