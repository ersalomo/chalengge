package Test;

import Test.abs.Employee;

public class DataScience extends Employee {

    public DataScience(
            String id,
            String name,
            String address,
            String dOb,
            double salary,
            String department,
            boolean status
    ) {
        super(id, name, address ,dOb, salary, department, status);
    }

    @Override
    public String work() {
        return "Now I do work on my own";
    }
}
