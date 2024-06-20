package com.dcb.department_service.controller;

import com.dcb.department_service.client.EmployeeClient;
import com.dcb.department_service.model.Department;
import com.dcb.department_service.repository.DepartmentRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/departments")
@Tag(name = "Department", description = "Department management APIs")
public class DepartmentController {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeClient employeeClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @PostMapping
    public Department addDepartment(@RequestBody Department department) {
        LOGGER.info("Add department {}", department);
        return departmentRepository.addDepartment(department);
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        LOGGER.info("Get department by id {}", id);
        return departmentRepository.findById(id);
    }

    @GetMapping("/with-employees")
    public List<Department> getAllDepartmentsWithEmployees() {
        LOGGER.info("Get Departments with employees ");
        List<Department> departments = departmentRepository.findAll();
        departments.forEach(
                department -> department.setEmployeeList(
                        employeeClient.getEmployeesByDepartmentId(department.getId())));
        return departments;
    }
}
