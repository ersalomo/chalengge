package Test.abs;

import Test.Contract.IEmp;

public abstract class Employee implements IEmp {
    protected String id = "";
    protected String name = "";
    protected double salary = 0.00;
    protected String department = "";
    protected String address = "";
    protected String dateOfBirth = "";
    protected boolean status = false;


    public Employee(
            String id,
            String name,
            String address,
            String dOb,
            double salary,
            String department,
            boolean status) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dOb;
        this.salary = salary;
        this.department = department;
        this.status = status;
    }
    public String getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getAddress() {
        return this.address;
    }
    public double getSalary() {
        return this.salary;
    }
    public String getDateOfBirth() {
        return this.dateOfBirth;
    }
    public Boolean getStatus() {
        return this.status;
    }

    public abstract String work();
    public abstract double calculateSalary();
    public abstract double lembur();

}
