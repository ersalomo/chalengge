package Test.Department;

import Test.abs.Employee;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private String address;
    private String phone;

    private final List<Employee> employees;

    public Department(String name, String address, String phone) {
        this.name       = name;
        this.address    = address;
        this.phone      = phone;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee emp) {
        this.employees.add(emp);
    }
    public void removeEmployee(String name) {
        Employee empActive = this.findEmployee(name);
        if (empActive != null) {
            this.employees.remove(empActive);
        }
    }

    public Employee findEmployee(String name) {
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)) {
                return  employee;
            }
        }
        return null;
    }

    public void showEmployee() {
        for (Employee employee : this.employees) {
            System.out.printf("Name : %s\t| Salary : %.3f", employee.getName(), employee.getSalary());
            System.out.println();
        }
    }
}
