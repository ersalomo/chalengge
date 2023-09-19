package Test.Builder;

import Test.abs.Employee;

public abstract class EmployeeBuilder {
    protected String name;
    protected double salary;
    protected String department;

    public abstract EmployeeBuilder setName(String name);

    public abstract EmployeeBuilder setSalary(double salary);

    public abstract EmployeeBuilder setDepartment(String department);

    public abstract Employee build();
}
