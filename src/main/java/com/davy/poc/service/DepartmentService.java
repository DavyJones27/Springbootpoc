package com.davy.poc.service;

import com.davy.poc.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getAllDepartment();

    Department getDepartment(Long id);

    void deleteDepartment(Long id);

    Department updateDepartment(Long id, Department department);

    Department getDepartmentByName(String name);
}
