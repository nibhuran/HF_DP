package com.Design.employee;

import java.util.ArrayList;

/**
 * Created by BHUVKUMA on 21-Apr-15.
 */
public class EmployeeOrg extends EmployeeAbstract{
    ArrayList<EmployeeAbstract> employeeAbstractArrayList = new ArrayList<EmployeeAbstract>();

    @Override
    public void print() {
        for(EmployeeAbstract employeeAbstract: employeeAbstractArrayList){
            employeeAbstract.print();
        }
    }

    public void add(EmployeeAbstract employeeAbstract){
        employeeAbstractArrayList.add(employeeAbstract);
    }

    public void remove(EmployeeAbstract employeeAbstract){
        employeeAbstractArrayList.remove(employeeAbstract);
    }


}
