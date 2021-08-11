package com.davy.poc.service;

import com.davy.poc.entity.Department;
import com.davy.poc.error.DeparmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getAllDepartment();

    Department getDepartment(Long id) throws DeparmentNotFoundException;

    void deleteDepartment(Long id);

    Department updateDepartment(Long id, Department department);

    Department getDepartmentByName(String name);
}
