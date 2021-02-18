package ru.zettai.spring.springboot.spring_course_springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.zettai.spring.springboot.spring_course_springboot.entities.Employee;
import ru.zettai.spring.springboot.spring_course_springboot.services.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable("id") int id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){
        employeeService.saveOrUpdateEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveOrUpdateEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable("id") int id){
        employeeService.deleteEmployeeById(id);
        return "Employee with id: " + id + " was deleted.";
    }
}
