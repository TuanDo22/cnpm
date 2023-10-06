package com.example.projectse.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {

    private long id ;
    private String name;
    private int salary;
    private int phone;
    private String location;
}
