package com.deepthi.departmentmicroservice.dao;

import com.deepthi.departmentmicroservice.model.Department;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Slf4j
public class DepartmentDao implements DepartmentDaoInterf{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int save(Department department) {
        log.info("DepartmentDao:save() start");
        return jdbcTemplate.update("INSERT INTO department (department_id,department_name, department_address) VALUES(?,?,?)",
                new Object[] { department.getDepartmentId(),department.getDepartmentName(), department.getDepartmentAddress() });

    }



    @Override
    public int update(Department department,Long deptId) {
        log.info("DepartmentDao :updata() start");
        return jdbcTemplate.update("UPDATE department SET department_name=?, department_address=? WHERE department_id="+deptId,
                new Object[] {department.getDepartmentName(), department.getDepartmentAddress()});

    }

    @Override
    public Department findById(Long id) {
        log.info("DepartmentDaoInterf() :findById() start");
        try {
            Department department  = jdbcTemplate.queryForObject("SELECT * FROM department WHERE department_id=?",
                    BeanPropertyRowMapper.newInstance(Department.class), id);
            System.out.println("department"+department);
            return department;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;


        }
    }

    @Override
    public Department findByDepartmentName(String name) {
        log.info("DepartmentDao :findByDepartment() start");
        return jdbcTemplate.queryForObject("SELECT * from department WHERE department_name=?",
                BeanPropertyRowMapper.newInstance(Department.class), name);
           }

    @Override
    public List<Department> findAll() {
        log.info("DepartmentDao :findAll() start");
        return jdbcTemplate.query("SELECT * from department", BeanPropertyRowMapper.newInstance(Department.class));
    }

    @Override
    public int deleteAll() {
        log.info("DepartmentDao :deleteAll() start");
        return jdbcTemplate.update("DELETE from department");
    }

    @Override
    public int deleteById(Long deptId) {
        log.info("DepartmentDao :deleteById() start");
        return jdbcTemplate.update("DELETE FROM tutorials WHERE id=?",deptId);
    }
}
