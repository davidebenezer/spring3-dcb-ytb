package com.dcb.employee_service.controller;

import com.dcb.employee_service.model.Employee;
import com.dcb.employee_service.repository.EmployeeRepository;
import jakarta.ws.rs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        LOGGER.info("Add employee {}", employee);
        return employeeRepository.addEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        LOGGER.info("Get employee by id {}", id);
        return employeeRepository.findById(id);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> getEmployeesByDepartmentId(@PathVariable Long departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }
}
