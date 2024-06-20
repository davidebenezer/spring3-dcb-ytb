package com.dcb.department_service.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
public class Department {
    public Department(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    private Long id;
    private String name;
    private List<Employee> employeeList = new ArrayList<>();


}
