package io.angelinux.crudemployee.rest;

import io.angelinux.crudemployee.entity.Employee;
import io.angelinux.crudemployee.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Employee getEmployee(@PathVariable Integer idEmployee) {
        Optional<Employee> theEmployee = employeeService.findById(idEmployee);
        if (theEmployee.isEmpty()) {
            throw new RuntimeException("Employee id " + idEmployee + " not found");
        }

        return theEmployee.get();
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theNewEmployee) {
        System.out.println("Received employee object:");
        System.out.println(theNewEmployee);
        Employee dbEmployee = employeeService.save(theNewEmployee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theUpdatedEmployee) {
        Employee dbEmployee = employeeService.save(theUpdatedEmployee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{idEmployee}")
    public String deleteEmployee(@PathVariable int idEmployee) {
        Optional<Employee> e = employeeService.findById(idEmployee);
        if (e.isEmpty()) {
            throw new RuntimeException("Employee id " + idEmployee + " not found");
        }
        employeeService.deleteById(idEmployee);

        return "Successfully Deleted employee id: " + idEmployee;
    }
}
