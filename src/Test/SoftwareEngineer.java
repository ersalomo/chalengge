package Test;

import Test.abs.Employee;

public class SoftwareEngineer extends Employee {
    public SoftwareEngineer(String name, double salary, String department) {
        super(name, salary, department);
    }

    @Override
    public String work() {
        return "Do you wanna be a software engineer at google";
    }
}
