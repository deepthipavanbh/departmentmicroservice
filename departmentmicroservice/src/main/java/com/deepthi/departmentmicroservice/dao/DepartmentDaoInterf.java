package com.deepthi.departmentmicroservice.dao;

import com.deepthi.departmentmicroservice.model.Department;

import java.util.List;

public interface DepartmentDaoInterf {
    public int save(Department department);
    public int update(Department department,Long deptId);
    public Department findById(Long id);
    public Department findByDepartmentName(String name);
    public List<Department> findAll();
    public int deleteAll();
    public int deleteById(Long deptId);


}
