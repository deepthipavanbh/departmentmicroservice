package com.deepthi.departmentmicroservice.service;

import com.deepthi.departmentmicroservice.dao.DepartmentDao;
import com.deepthi.departmentmicroservice.model.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class DepartmentServiceTest {

        @Autowired
        private DepartmentService departmentService;
     @MockBean
    private DepartmentDao departmentDao;

    @BeforeEach
            void setUp() {
                  Department department =
                           Department.builder()
                                   .departmentId(1L)
                           .departmentName("IT")
                                   .departmentAddress("Pune")
                                   .build();
                  Mockito.when(departmentDao.findByDepartmentName("IT"))
                          .thenReturn(department);

          }
          @Test
          @DisplayName("Get data based on valid department name")
              public void whenValidDepartmentName_thenDepartmentShouldFound(){

                     String departmentName ="IT";
                     Department found=
                             departmentService.findDepartmentByName(departmentName);

                     assertEquals(departmentName,found.getDepartmentName());
        }
    }
