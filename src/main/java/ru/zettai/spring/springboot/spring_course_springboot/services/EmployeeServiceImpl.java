package ru.zettai.spring.springboot.spring_course_springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zettai.spring.springboot.spring_course_springboot.dao.EmployeeDAO;
import ru.zettai.spring.springboot.spring_course_springboot.entities.Employee;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public void saveOrUpdateEmployee(Employee employee) {

    }

    @Override
    public Employee getEmployeeById(int id) {
        return null;
    }

    @Override
    public void deleteEmployeeById(int id) {

    }
}
