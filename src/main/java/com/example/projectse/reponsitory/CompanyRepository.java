package com.example.projectse.reponsitory;

import com.example.projectse.entity.EmployeeCompany;
import com.example.projectse.entity.ListCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<ListCompany,Long> {
    @Query("select p from ListCompany p where CONCAT(p.name, ' ', p.taxcode, ' ', p.authorized, ' ', p.phone) like %?1%  ")
    List<ListCompany> findAll(String keywork);
}
