package com.Design.employee;

/**
 * Created by BHUVKUMA on 21-Apr-15.
 */
public class Employee extends EmployeeAbstract{
    public String name;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public int salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public void print() {
        System.out.println(toString());
    }
}
