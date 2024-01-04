package io.angelinux.crudemployee.service;

import io.angelinux.crudemployee.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();
    Optional<Employee> findById(Integer idEmployee);
    Employee save(Employee theEmployee);
    void deleteById(int idEmployee);
}
