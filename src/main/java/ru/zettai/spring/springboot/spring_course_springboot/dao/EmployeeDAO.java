package ru.zettai.spring.springboot.spring_course_springboot.dao;

import ru.zettai.spring.springboot.spring_course_springboot.entities.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getAllEmployees();

    void saveOrUpdateEmployee(Employee employee);

    Employee getEmployeeById(int id);

    void deleteEmployeeById(int id);
}
