package gosandrey1986.hwexceptions;

import gosandrey1986.hwexceptions.exceptions.EmployeeIndexOutOfBoundsException;
import gosandrey1986.hwexceptions.exceptions.EmployeeNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }



    @RequestMapping("/add")
    public Employee add(@RequestParam(name = "firstName") String firstName,
                      @RequestParam( name = "lastName") String lastName) {
            return employeeService.add(firstName, lastName);
    }

    @RequestMapping("/remove")
    public Employee remove(@RequestParam(name = "firstName") String firstName,
                         @RequestParam(name = "lastName") String lastName) {
            return employeeService.remove(firstName, lastName);
        }

    @RequestMapping("/find")
    public Object find(@RequestParam(name = "firstName") String firstName,
                       @RequestParam( name = "lastName") String lastName) {
        return employeeService.find(firstName, lastName);
    }
}

