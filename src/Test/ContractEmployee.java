package Test;

import Test.abs.Employee;

public class
ContractEmployee extends Employee {
    private long duration;
    private double bonusPerMonth;

    public ContractEmployee(
            String id,
            String name,
            String address,
            String dOb,
            double salary,
            String department,
            boolean status) {
        super(id, name, address, dOb, salary, department, status);
        this.duration = 0;
        this.bonusPerMonth = 5_000.00;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
    @Override
    public String work() {
        return String.format("My name is %s and I hate this job", this.getName());
    }

    @Override
    public double calculateSalary() {
        double bonus = this.bonusPerMonth * this.duration;
        return this.salary + bonus;
    }

    @Override
    public double lembur() {
        return 1000.00; // magic value
    }
}
