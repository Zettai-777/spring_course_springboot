package ru.zettai.spring.springboot.spring_course_springboot.services;

import ru.zettai.spring.springboot.spring_course_springboot.entities.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    void saveOrUpdateEmployee(Employee employee);

    Employee getEmployeeById(int id);

    void deleteEmployeeById(int id);
}
