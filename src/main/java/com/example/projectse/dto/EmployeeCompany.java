package com.example.projectse.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class EmployeeCompany  {
    @Id
    private Integer id;
    private String name ;
    private int salary;
    @ManyToOne()
    @JoinColumn(name = "company_id" )
    ListCompany employeeCompanies;

}
