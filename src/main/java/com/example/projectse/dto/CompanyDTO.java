package com.example.projectse.dto;

import jakarta.persistence.Id;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyDTO {
    private Integer id ;
    private String name;
    private String taxcode;
    private int authorized;
    private int phone;
    private int employee;
    private int sum;
}
