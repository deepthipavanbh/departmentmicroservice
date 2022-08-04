package com.deepthi.employee.microservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
          @Id
          @GeneratedValue(strategy = GenerationType.AUTO)
         private Long employeeId;
          @Column(name="first_name")
         private String employeeFirstName;
          @Column(name="last_name")
          private String employeeLastName;
         private String employeeEmail;
           private double salary;
         @Enumerated(EnumType.STRING)
         private EmployeeStatus status;
         private Long departmentId;

}
