package com.deepthi.employee.microservice.controller;

import com.deepthi.employee.microservice.VO.ResponseTemplateVO;
import com.deepthi.employee.microservice.model.Employee;
import com.deepthi.employee.microservice.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Slf4j
public class EmployeeController {

    @Autowired
       private EmployeeService employeeService;


      @PostMapping("/create")
      public ResponseEntity<String> saveEmployee(@RequestBody Employee employee){
           log.info("@Employeecontroller: saveEmployee() method :start");
               try {
                   employeeService.saveEmployee(employee);
                   return new ResponseEntity<>("Employee saaved successfully", HttpStatus.CREATED);
               }catch(Exception e){
                   return new ResponseEntity<>("Employee couldn't able to create",HttpStatus.INTERNAL_SERVER_ERROR);
               }
      }
       @GetMapping("/")
      public ResponseEntity<List<Employee>> getAllEmployees(){
             log.info("@Employeecontroller: getAllEmployees() method :start");
             try{
                    List<Employee> employeeList = new ArrayList<>();
                    employeeList=employeeService.getAllEmployees();
                    return new ResponseEntity<>(employeeList,HttpStatus.OK);
             }catch(Exception e){
                 return  new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
             }
      }
         @RequestMapping(method = RequestMethod.GET,value={"/all","/{employeeId}"})
         public ResponseEntity<List<ResponseTemplateVO>> getAllEmployeesWithDepartmentOrById(@PathVariable(required = false) Long employeeId){

                log.info("@Employeecontroller: getAllEmployeeswithDepartmentOrById() method :start");
                try{
                        List<ResponseTemplateVO> responseTemplateVOList=new ArrayList<>();
                          if(employeeId!=null) {
                              responseTemplateVOList = employeeService.getAllEmployeesWithDepartmentById(employeeId);

                          }
                          else{
                              responseTemplateVOList = employeeService.getAllEmployeesWithDepartment();
                          }
                          return new ResponseEntity<>(responseTemplateVOList,HttpStatus.OK);
                }catch (Exception e){
                    return  new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
                }
         }

}
