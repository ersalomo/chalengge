package Test.Builder;

import Test.abs.Employee;

public abstract class EmployeeBuilder {
    protected String id;
    protected String address;
    protected String dateOfBirth;
    protected boolean status;

    protected String name;
    protected double salary;
    protected String department;

    public abstract EmployeeBuilder setId(String id);
    public abstract EmployeeBuilder setDataOfBirth(String dOb);
    public abstract EmployeeBuilder setAddress(String address);
    public abstract EmployeeBuilder setStatus(boolean status);
    public abstract EmployeeBuilder setName(String name);
    public abstract EmployeeBuilder setSalary(double salary);

    public abstract EmployeeBuilder setDepartment(String department);

    public abstract Employee build();
}
