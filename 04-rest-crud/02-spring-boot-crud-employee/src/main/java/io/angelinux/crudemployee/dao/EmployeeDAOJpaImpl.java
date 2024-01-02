package io.angelinux.crudemployee.dao;

import io.angelinux.crudemployee.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl (EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> myQuery = entityManager.createQuery("from Employee ", Employee.class);
        List<Employee> employeeList = myQuery.getResultList();
        return employeeList;
    }

    @Override
    public Employee findById(int idEmployee) {
        Employee employee = entityManager.find(Employee.class, idEmployee);
        return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmployee = entityManager.merge(theEmployee);
        return dbEmployee;
    }

    @Override
    public void deleteById(int idEmployee) {
        Employee theEmployee = entityManager.find(Employee.class, idEmployee);
        System.out.println("Employee details to be deleted from DB:");
        System.out.println(theEmployee);
        entityManager.remove(theEmployee);
    }
}
