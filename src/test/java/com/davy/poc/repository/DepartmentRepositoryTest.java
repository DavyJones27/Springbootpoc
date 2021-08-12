package com.davy.poc.repository;

import com.davy.poc.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("IT")
                .departmentAddress("ramapuram")
                .departmentCode("RA1611")
                .build();
        entityManager.persist(department);
    }

    @Test
    public void findById_pass() {
        Department department = departmentRepository.findById(1L).get();

        assertEquals(department.getDepartmentName(), "IT");
    }
}