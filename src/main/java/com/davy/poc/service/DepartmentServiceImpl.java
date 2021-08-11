package com.davy.poc.service;

import com.davy.poc.entity.Department;
import com.davy.poc.error.DeparmentNotFoundException;
import com.davy.poc.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartment(Long id) throws DeparmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(id);

        if(!department.isPresent()){
            throw new DeparmentNotFoundException("Department Not found");
        }

        return department.get();
    }

    @Override
    public void deleteDepartment(Long id) {
         departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        Department res = departmentRepository.findById(id).get();

        if(Objects.nonNull(department.getDepartmentName()) &&  !"".equalsIgnoreCase(department.getDepartmentName())){
            res.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentCode()) &&  !"".equalsIgnoreCase(department.getDepartmentCode())){
            res.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) &&  !"".equalsIgnoreCase(department.getDepartmentAddress())){
            res.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(res);
    }

    @Override
    public Department getDepartmentByName(String name) {
        return departmentRepository.findByDepartmentNameIgnoreCase(name);
    }
}
