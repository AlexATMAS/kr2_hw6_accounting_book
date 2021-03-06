package pro.sky.accounting_book.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.accounting_book.model.Employee;
import pro.sky.accounting_book.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/add")
    public Employee add(@RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName){
        return employeeService.addEmployees(firstName,lastName);
    }

    @GetMapping(value = "/remove")
    public Employee remove(@RequestParam("firstName") String firstName,
                        @RequestParam("lastName") String lastName){
        return employeeService.deleteEmployee(firstName,lastName);
    }

    @GetMapping(value = "/find")
    public Employee find(@RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName){
        return employeeService.findEmployee(firstName,lastName);
    }

    @GetMapping(value = "/")
    public List<Employee> getAll(){
        return employeeService.getAll();
    }



}
