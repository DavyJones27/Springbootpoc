package com.davy.poc.controller;

import com.davy.poc.entity.Department;
import com.davy.poc.error.DeparmentNotFoundException;
import com.davy.poc.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
   private DepartmentService departmentService;

    private final Logger LOGGER =  LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/department")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("hi there");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/department")
    public List<Department> getAllDepartment() {

        return departmentService.getAllDepartment();
    }

    @GetMapping("/department/{id}")
    public Department getDepartment(@PathVariable("id") Long id) throws DeparmentNotFoundException {

        return departmentService.getDepartment(id);
    }

    @DeleteMapping("/department/{id}")
    public String deleteDepartment(@PathVariable("id") Long id) {

         departmentService.deleteDepartment(id);

         return "deparment with " + id + "sucessfull deleted";
    }

    @PutMapping("/department/{id}")
    public Department updateDepartment(@PathVariable("id") Long id, @RequestBody Department department) {

        return departmentService.updateDepartment(id, department);
    }

    @GetMapping("/department/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String name) {

        return departmentService.getDepartmentByName(name);
    }

}
