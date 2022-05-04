package gosandrey1986.hwexceptions;

import gosandrey1986.hwexceptions.exceptions.EmployeeIndexOutOfBoundsException;
import gosandrey1986.hwexceptions.exceptions.EmployeeNotFoundException;
import gosandrey1986.hwexceptions.exceptions.TheEmployeeAlreadyExistsException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    Employee[] employees = new Employee[5];

    public Employee add(String firstName, String lastName) { //добавить сотрудника
        boolean inProcess;
        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < employees.length; i++) {
            inProcess = true;
            if (employees[i] == null) {
                employees[i] = employee;
                break;
            } else if (employees[i] != null && i == employees.length - 1) {
                inProcess = false;
            }
            if (inProcess == false) {
                throw new EmployeeIndexOutOfBoundsException();
            }
            if (employee.getFirstName().equalsIgnoreCase(employees[i].getFirstName()) &&
                    employee.getLastName().equalsIgnoreCase(employees[i].getLastName())) {
                throw new TheEmployeeAlreadyExistsException();
            }
        }
        return employee;
    }

    public Employee remove(String firstMame, String lastName) { // удаление сотрудника
        Employee employee = searcher(firstMame, lastName);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getFirstName().equalsIgnoreCase(employee.getFirstName()) &&
                        employees[i].getLastName().equalsIgnoreCase(employee.getLastName())) {
                    employees[i] = null;
                    break;
                }
            }
        }
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }
        if (!employee.getFirstName().equalsIgnoreCase(employee.getFirstName()) &&
                !employee.getLastName().equalsIgnoreCase(employee.getLastName())) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public Employee searcher(String firstMame, String lastName) { // поиск сотрудника
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getFirstName().equalsIgnoreCase(firstMame) && employee.getLastName().equalsIgnoreCase(lastName)) {
                    return employee;
                }
                if ((employee == null || !employee.getFirstName().equalsIgnoreCase(employee.getFirstName()) &&
                        !employee.getLastName().equalsIgnoreCase(employee.getLastName()))) {
                    throw new EmployeeNotFoundException();
                }
            }
            return employee;
        }
        return null;
    }

    public Employee find(String firstMame, String lastName) { // поиск сотрудника
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getFirstName().equalsIgnoreCase(firstMame) &&
                        employee.getLastName().equalsIgnoreCase(lastName)) {
                    return employee;
                }
                if ((employee == null || employee != null && !employee.getFirstName().equalsIgnoreCase(firstMame) || !employee.getLastName().equalsIgnoreCase(lastName))) {
                    throw new EmployeeNotFoundException();
                }
            }
        }
        return null;
    }
}
