//import Employee.*;

import Test.Builder.DataScienceBuilder;
import Test.Builder.SoftwareEngineerBuilder;
import Test.Department.Department;
import Test.abs.Employee;

public class Main {
    public static void main(String[] args) {
        Employee brono = new DataScienceBuilder()
                .setName("Brono")
                .setDepartment("IT")
                .setSalary(100000.00)
                .build();

        Employee rikiPali = new SoftwareEngineerBuilder()
                .setName("Riki pali")
                .setSalary(100000.00)
                .setDepartment("IT")
                .setAddress("Jln. Dadap Sunter Agung")
                .setId("EMP-001")
                .setDataOfBirth("23-13-1996")
                .build();

        Employee someBody = new SoftwareEngineerBuilder()
                .setName("Somebody I Dream of")
                .setSalary(100000.00)
                .setDepartment("IT")
                .setAddress("Jln. Dadap Sunter Agung")
                .setId("EMP-001")
                .setDataOfBirth("23-13-1996")
                .build();

        Department it = new Department("PT. Makmur",  "Jln. Peta No.43", "+021109343");

        it.addEmployee(rikiPali);
        it.addEmployee(brono);
        it.addEmployee(someBody);
        it.showEmployee();

        Employee who = it.findEmployee(someBody.getName());

        System.out.println(who.getName());

    }
}