package io.angelinux.crudemployee.service;

import io.angelinux.crudemployee.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
