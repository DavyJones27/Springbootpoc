package com.davy.poc.repository;

import com.davy.poc.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findByDepartmentName(String name);

//    @Query(value = "select * from department where department_name = ?1", nativeQuery = true)
    public Department findByDepartmentNameIgnoreCase(String name);

}
