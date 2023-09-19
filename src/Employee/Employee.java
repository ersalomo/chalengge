package Employee;

public class Employee {
    private String id;
    private String name;
    private String dateOfBirth;
    private String address;
    private boolean status;

    public String getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getAddress() {
        return this.address;
    }
    public String getDateOfBirth() {
        return this.dateOfBirth;
    }
    public Boolean getStatus() {
        return this.status;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String toString() {
        return String.format("%s %s", id, name);
    }
}
