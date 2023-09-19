package Employee;


public class EmployeeBuilder {
    private String id = "";
    private String name = "";
    private String dateOfBirth = "";
    private String address = "";
    private boolean status = false;
    private Employee employee = new Employee();

    public EmployeeBuilder setId(String id) {
        this.employee.setId(id);
        return this;
    }
    public EmployeeBuilder setName(String name) {
        this.employee.setName(name);
        return this;
    }
    public EmployeeBuilder setDateOfBirth(String dateOfBirth) {
        this.employee.setDateOfBirth(dateOfBirth);
        return this;
    }
    public EmployeeBuilder setAddress(String address) {
        this.employee.setAddress(address);
        return this;
    }
    public EmployeeBuilder setStatus(Boolean status) {
        this.employee.setStatus(status);
        return this;
    }

    public Employee build() {
        return employee;
    }
}
