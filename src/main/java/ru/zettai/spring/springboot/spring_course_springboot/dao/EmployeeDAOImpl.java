package ru.zettai.spring.springboot.spring_course_springboot.dao;

//import org.hibernate.Session;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.zettai.spring.springboot.spring_course_springboot.entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    private EntityManager entityManager;

//      //  Версия с Hibernate
//    @Override
//    public List<Employee> getAllEmployees() {
//        Session session = entityManager.unwrap(Session.class);
//        return session.createQuery("from Employee", Employee.class).getResultList();
//    }

    //Версия с jpa
    @Override
    public List<Employee> getAllEmployees() {
        Query query = entityManager.createQuery("from Employee");
        List<Employee> allEmployees = query.getResultList();
        return allEmployees;
    }

//    //  Версия с Hibernate
//    @Override
//    public void saveOrUpdateEmployee(Employee employee) {
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(employee);
//    }

    //  Версия с jpa
        public void saveOrUpdateEmployee(Employee employee) {
            Employee newEmployee = entityManager.merge(employee);
            employee.setId(newEmployee.getId());
        }

//    //  Версия с Hibernate
//    @Override
//    public Employee getEmployeeById(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        return session.get(Employee.class, id);
//    }

    //  Версия с jpa
    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

//    //  Версия с Hibernate
//    @Override
//    public void deleteEmployeeById(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Query query = session.createQuery("delete from Employee where id=: id");
//        query.setParameter("id", id);
//        query.executeUpdate();
//    }

    //  Версия с jpa
    @Override
    public void deleteEmployeeById(int id) {
        Query query =
                entityManager.createQuery("delete from Employee where id=: id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
