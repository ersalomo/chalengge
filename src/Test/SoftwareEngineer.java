package Test;

import Test.abs.Employee;

public class SoftwareEngineer extends Employee {
    private double additionalIncome;
    private double lembur;
    private long duration;


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
        this.lembur = 0.00;
    }

    @Override
    public String work() {
        return "My name " + this.getName();
    }

    @Override
    public double calculateSalary() {
        return this.salary + additionalIncome + lembur;
    }

    @Override
    public double lembur() {
        double gajiLembur = 2000.00;
        return gajiLembur;
    }

    public void setAdditionalIncome(double projectPrice) {
        this.additionalIncome = projectPrice;
    }
}
