package com.deepthi.employee.microservice.dao;

import com.deepthi.employee.microservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EmployeeDao extends JpaRepository<Employee,Long> {


    Employee findByEmployeeId(Long employeeId);
}
