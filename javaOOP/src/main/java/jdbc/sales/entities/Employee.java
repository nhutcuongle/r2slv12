package jdbc.sales.entities;

public class Employee {
    private int id;
    private String lastName;
    private String firstName;
    private String birthdate;
    private int supervisor;

    public Employee() {
    }

    public Employee(int id, String lastName, String firstName, String birthdate, int supervisor) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthdate = birthdate;
        this.supervisor = supervisor;
    }

    public Employee(String lastName, String firstName, String birthdate, int supervisor) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthdate = birthdate;
        this.supervisor = supervisor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public int getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(int supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Last Name: %s, First Name: %s, Birth Date: %s, Supervisor ID: %d",
                getId(), getLastName(), getFirstName(), getBirthdate(), getSupervisor());
    }
}
