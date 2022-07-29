package com.deepthi.departmentmicroservice.controller;


import com.deepthi.departmentmicroservice.model.Department;
import com.deepthi.departmentmicroservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/departments")
@Slf4j
public class DepartmentController {

         @Autowired
        private DepartmentService departmentService;

            @PostMapping("/save")
            public ResponseEntity<String> createDepartment(@RequestBody Department department){
            log.info("DepartmentController : createDepartment() start");
                try{

                    departmentService.save(department);
                    return new ResponseEntity<>("Department was created successfully.", HttpStatus.CREATED);
                } catch (Exception e) {
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }

            }

            @GetMapping("/get")
            public ResponseEntity<List<Department>> getDepartments(){
        log.info("DepartmentController : getAllDepartments() start");
                 try{
                      List<Department> departments = new ArrayList<>();
                     departments = departmentService.findAllDepartments();
                     return new ResponseEntity<>(departments, HttpStatus.OK);
                 }catch (Exception e) {
                     return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

                 }

    }      @GetMapping("/id/{deptId}")
           public ResponseEntity<Department> getDepartmentById(@PathVariable Long deptId){
        log.info("DepartmentController : getDepartmentById() start"+deptId);
                try{
                    Department department = departmentService.findDepartmentById(deptId);
                    return new ResponseEntity<>(department,HttpStatus.OK);
                   }
                catch (Exception e) {
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

                }
           }

           @GetMapping("/name/{deptName}")
      public ResponseEntity<Department> getDepartmentByName(@PathVariable String deptName){
               log.info("DepartmentController : getDepartmentById() start"+deptName);

               try{
                   Department department = departmentService.findDepartmentByName(deptName);
                   return new ResponseEntity<>(department,HttpStatus.OK);
                 }catch (Exception e) {
                   return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

               }
           }
            @PutMapping("/update/{deptId}")
           public ResponseEntity<String> updateDepartment(@RequestBody Department department,@PathVariable Long deptId) {

                log.info("@DepartmentController : updateDepartment() start");

                try {
                    departmentService.updateDepartment(department, deptId);
                    return new ResponseEntity<>("Record updated successfully", HttpStatus.OK);
                } catch (Exception e) {
                    return new ResponseEntity<>("updation failed ", HttpStatus.INTERNAL_SERVER_ERROR);


                }
            }
}
