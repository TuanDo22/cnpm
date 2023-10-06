package com.example.projectse.reponsitory;

import com.example.projectse.entity.EmployeeCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeCompany, Long> {
    void deleteById(Long id);
}
