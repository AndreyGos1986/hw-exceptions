package gosandrey1986.hwexceptions;

public class Employee {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String employeeToString() {
        return "Имя: " + getFirstName() + "  " + "Фамилия: " + getLastName();
    }

    public void hashCode(Employee employee) {
        hashCode();
    }

    public void equals(Employee employee1, Employee employee2) {
        employee1.equals(employee2);
    }


}
