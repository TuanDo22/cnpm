package com.example.projectse.entity;

import com.example.projectse.entity.EmployeeCompany;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "list")
@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    @OneToMany(mappedBy = "employeeCompanies",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<EmployeeCompany> employeeCompanies;


}
