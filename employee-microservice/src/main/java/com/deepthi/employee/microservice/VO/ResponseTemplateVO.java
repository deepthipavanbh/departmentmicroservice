package com.deepthi.employee.microservice.VO;

import com.deepthi.employee.microservice.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {


       private Employee employee;
       private Department department;
}
