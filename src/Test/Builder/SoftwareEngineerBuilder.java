package Test.Builder;

import Test.SoftwareEngineer;

public class SoftwareEngineerBuilder extends EmployeeBuilder {
    @Override
    public EmployeeBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public EmployeeBuilder setSalary(double salary) {
        this.salary = salary;
        return this;
    }

    @Override
    public EmployeeBuilder setDepartment(String department) {
        this.department = department;
        return this;
    }

    @Override
    public SoftwareEngineer build() {
        return new SoftwareEngineer(name,salary,department);
    }
}
