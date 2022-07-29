package com.deepthi.departmentmicroservice.service;

import com.deepthi.departmentmicroservice.dao.DepartmentDao;
import com.deepthi.departmentmicroservice.dao.DepartmentDaoInterf;
import com.deepthi.departmentmicroservice.model.Department;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DepartmentService {

     @Autowired
       private DepartmentDao departmentDao;
    public int  save(Department department) {
        log.info("DepartmentService: save() start");
       return  departmentDao.save(new Department(department.getDepartmentId(),department.getDepartmentName(), department.getDepartmentAddress()));
    }

    public List<Department> findAllDepartments() {
        log.info("DepartmentService: findAllDepartments() start");
         List<Department> departments = new ArrayList<>();

         departmentDao.findAll().forEach(departments::add);
         return departments;
    }

    public Department findDepartmentById(Long deptId) {
        log.info("DepartmentService: findAllDepartments() start");
        return departmentDao.findById(deptId);
    }

    public Department findDepartmentByName(String deptName) {
        log.info("DepartmentService: findAllDepartmentByName() start");

        return departmentDao.findByDepartmentName(deptName);
    }

    public  int updateDepartment(Department department, Long deptId) {

        log.info("DepartmentService: findAllDepartmentByName() start");
        return  departmentDao.update(department,deptId);
    }
}
