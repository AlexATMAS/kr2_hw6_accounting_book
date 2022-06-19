package pro.sky.accounting_book.service;


import org.springframework.stereotype.Service;
import pro.sky.accounting_book.exceptions.EmployeeAlreadyAddedException;
import pro.sky.accounting_book.exceptions.EmployeeNotFoundException;
import pro.sky.accounting_book.exceptions.EmployeeStorageIsFullException;
import pro.sky.accounting_book.model.Employee;

import java.util.*;

@Service
public class EmployeeService {

    private static final int LIMIT = 10;
    private final List<Employee> employees = new ArrayList<>(10);

    public Employee addEmployees(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        if(employees.contains(employee)){
            throw new EmployeeAlreadyAddedException("Сотрудник уже числится в базе!");
        }
        if (employees.size()<LIMIT){
            employees.add(employee);
            return employee;
        }else {
            throw new EmployeeStorageIsFullException("База данных переполнена!");
        }
    } // Добавление сотрудника;


    public Employee deleteEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        if (!employees.contains(employee)){
            throw new EmployeeNotFoundException("Сотрудник не найден!");
        }
        employees.remove(employee);
        return employee;
    } // Удаление сотрудника;


    public Employee findEmployee (String firstName, String lastName)  {
        Employee employee = new Employee(firstName,lastName);
        if (!employees.contains(employee)){
            throw new EmployeeNotFoundException("Сотрудник не найден!");
        }
        return employee;
    }//// Получить данные сотрудника по ФИО

    public  List<Employee> getAll(){
        return new ArrayList<>(employees);
    }


}









