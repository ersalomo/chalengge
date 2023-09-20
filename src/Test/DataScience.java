package Test;

import Test.abs.Employee;

public class DataScience extends Employee {
    private double additionalIncome;

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
        this.additionalIncome = 0.00;
    }

    @Override
    public String work() {
        return "Now I do work on my own";
    }

    public void setBonus(double bonus) {
        this.additionalIncome += bonus;
    }

    public double calculateSalary() {
        return this.salary + this.additionalIncome;
    }

    @Override
    public double lembur() {
        return 2000.00;
    }

}
