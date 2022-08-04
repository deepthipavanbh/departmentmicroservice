package com.deepthi.employee.microservice.service;


import com.deepthi.employee.microservice.VO.Department;
import com.deepthi.employee.microservice.VO.ResponseTemplateVO;
import com.deepthi.employee.microservice.dao.EmployeeDao;
import com.deepthi.employee.microservice.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private RestTemplate restTemplate;
    public void saveEmployee(Employee employee) {
        log.info("@EmployeeService : saveEmployee()..Started");

          employeeDao.save(employee);


    }

    public List<Employee> getAllEmployees() {
        log.info("@EmployeeService : getAllEmployees()..Started");
        List<Employee> employeeList=new ArrayList<>();
        employeeList=employeeDao.findAll();
        return employeeList;
    }

    public List<ResponseTemplateVO> getAllEmployeesWithDepartmentById(Long employeeId) {
        log.info("@EmployeeService : getAllEmployeesWithDepartmentOrById()..Started");
        List<ResponseTemplateVO> responseTemplateVOList=new ArrayList<>();

            ResponseTemplateVO responseTemplateVO=new ResponseTemplateVO();
            Employee employee= employeeDao.findByEmployeeId(employeeId);

            Department department = restTemplate.getForObject("http://DEPARTMENT-MICROSERVICE/api/departments/id:"+employee.getDepartmentId(),
                                Department.class);
        System.out.println(department);
               responseTemplateVO.setEmployee(employee);
               responseTemplateVO.setDepartment(department);
                responseTemplateVOList.add(responseTemplateVO);
                return responseTemplateVOList;

    }

    public List<ResponseTemplateVO> getAllEmployeesWithDepartment() {
        log.info("@EmployeeService : getAllEmployeesWithDepartment()..Started");
        List<ResponseTemplateVO> responseTemplateVOList=new ArrayList<>();

         List<Employee> employees=new ArrayList<>();
         employees =employeeDao.findAll();
        employees.forEach(employee -> {
            ResponseTemplateVO responseTemplateVO=new ResponseTemplateVO();
            Department department = restTemplate.getForObject("http://DEPARTMENT-MICROSERVICE/api/departments/id:"+employee.getDepartmentId(),
                    Department.class);
            responseTemplateVO.setEmployee(employee);
            responseTemplateVO.setDepartment(department);
            responseTemplateVOList.add(responseTemplateVO);


        });

           return responseTemplateVOList;
    }
}
