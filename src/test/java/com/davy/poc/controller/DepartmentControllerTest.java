package com.davy.poc.controller;

import com.davy.poc.entity.Department;
import com.davy.poc.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentName("IT")
                .departmentAddress("ramapuram")
                .departmentCode("RA1611")
                .departmentId(1L)
                .build();

    }

    @Test
    void saveDepartment() throws Exception {
        Department inputdepartment = Department.builder()
                .departmentName("IT")
                .departmentAddress("ramapuram")
                .departmentCode("RA1611")
                .build();
        Mockito.when(departmentService.saveDepartment(inputdepartment))
                .thenReturn(department);
        mockMvc.perform(post("/department")
                        .contentType(MediaType.APPLICATION_JSON).content("{\n" +
                                "    \"departmentName\": \"IT\",\n" +
                                "    \"departmentAddress\": \"ramapuram\",\n" +
                                "    \"departmentCode\": \"RA1611\"\n" +
                                "}"))
                .andExpect(status().isOk());

    }

    @Test
    void getDepartment() throws Exception {
        Mockito.when(departmentService.getDepartment(1L))
                .thenReturn(department);

        mockMvc.perform(get("/department/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName")
                        .value(department.getDepartmentName()));
    }
}