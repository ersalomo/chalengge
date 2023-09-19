package Test.Builder;


import Test.DataScience;

public class DataScienceBuilder extends EmployeeBuilder {
    @Override
    public EmployeeBuilder setId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public EmployeeBuilder setDataOfBirth(String dOb) {
        this.dateOfBirth = dOb;
        return this;
    }

    @Override
    public EmployeeBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public EmployeeBuilder setStatus(boolean status) {
        this.status = status;
        return this;
    }

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
    public DataScience build() {

        return new DataScience(
                id,
                name,
                address,
                dateOfBirth,
                salary,
                department,
                status
        );
    }
}
