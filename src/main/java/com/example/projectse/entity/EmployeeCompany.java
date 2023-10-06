package com.example.projectse.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "employee")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCompany  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name ;
    private int salary;
    private int phone;
    private String location;
    @ManyToOne()
    @JoinColumn(name = "company_id" )
    ListCompany employeeCompanies;

}
