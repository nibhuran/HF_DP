package com.Design.employee;

/**
 * Created by BHUVKUMA on 21-Apr-15.
 */
public class Company {



        public static void main(String[] args){
            Company company = new Company();
            EmployeeAbstract chandler = new Employee("Chandler", 1500);
            EmployeeAbstract joey = new Employee("Joey", 2000);

            EmployeeAbstract monica =  new Employee("Monica", 2000);
            EmployeeAbstract rachel =  new Employee("Rachel", 2000);

            EmployeeAbstract ross = new Employee("Ross", 2000);
            EmployeeAbstract pheobe = new Employee("Pheobe", 2000);

            EmployeeAbstract boys = new EmployeeOrg();
            boys.add(chandler);
            boys.add(joey);


            EmployeeAbstract girls = new EmployeeOrg();
            girls.add(monica);
            girls.add(rachel);

            EmployeeAbstract apartment = new EmployeeOrg();
            apartment.add(girls);
            apartment.add(boys);


            ross.print();
            pheobe.print();
            apartment.print();

            apartment.remove(boys);
            apartment.print();

            boys.print();
        }


    public void deleteEmployee(EmployeeAbstract employeeAbstract){


    }



}
