package Test;

import Test.abs.Employee;

public class SoftwareEngineer extends Employee {

    public SoftwareEngineer(
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
        return "My name " + this.getName();
    }
}
