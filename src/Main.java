//import Employee.*;

import Test.Builder.DataScienceBuilder;
import Test.Builder.SoftwareEngineerBuilder;
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
                .setDepartment("IT").build();

        System.out.println(brono.work());
        System.out.println(rikiPali.work());

    }
}