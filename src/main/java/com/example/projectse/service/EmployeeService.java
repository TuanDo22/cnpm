package com.example.projectse.service;

import com.example.projectse.dto.EmployeeDTO;
import com.example.projectse.entity.ListCompany;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> findByCompanyId(long id);
}
