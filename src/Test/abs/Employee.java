package Test.abs;

import Test.Contract.IEmp;

public abstract class Employee implements IEmp {
    protected String name;
    protected double salary;
    protected String department;

    public Employee(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public abstract String work();

}
