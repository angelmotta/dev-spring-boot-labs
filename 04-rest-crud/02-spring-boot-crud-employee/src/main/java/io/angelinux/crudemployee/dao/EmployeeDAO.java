package io.angelinux.crudemployee.dao;

import io.angelinux.crudemployee.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
