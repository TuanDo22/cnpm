package com.example.projectse.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.util.Collection;

@Entity
@Table(name = "list")
@Data
public class ListCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String name;
    private String taxcode;
    private int authorized;
    private int phone;
    private int employee;
    private int sum;
    @OneToMany(mappedBy = "employeeCompanies" , fetch = FetchType.LAZY)
    private Collection<EmployeeCompany> employeeCompanies;


}
