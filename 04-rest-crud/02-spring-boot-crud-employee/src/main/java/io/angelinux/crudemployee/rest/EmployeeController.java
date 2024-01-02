package io.angelinux.crudemployee.rest;

import io.angelinux.crudemployee.dao.EmployeeDAO;
import io.angelinux.crudemployee.entity.Employee;
import io.angelinux.crudemployee.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private final EmployeeService employeeService;

    // Constructor injection
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{idEmployee}")
    public Employee getEmployee(@PathVariable int idEmployee) {
        Employee theEmployee = employeeService.findById(idEmployee);
        if (theEmployee == null) {
            throw new RuntimeException("Employee id " + idEmployee + " not found");
        }

        return theEmployee;
    }
}
