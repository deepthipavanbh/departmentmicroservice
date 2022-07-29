package com.deepthi.departmentmicroservice.model;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {


        private Long departmentId;
        private String departmentName;
        private String departmentAddress;

}
