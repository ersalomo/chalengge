package Test;

import Test.abs.Employee;

public class DataScience extends Employee {

    public DataScience(String name, double salary, String department) {
        super(name, salary, department);
    }

    @Override
    public String work() {
        return "Now I do work on my own";
    }
}
