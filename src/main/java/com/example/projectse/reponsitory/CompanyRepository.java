package com.example.projectse.reponsitory;

import com.example.projectse.dto.ListCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<ListCompany,Integer> {
    @Query("select p from ListCompany p where CONCAT(p.name, ' ', p.taxcode, ' ', p.authorized, ' ', p.phone) like %?1%  ")
    public List<ListCompany> findAll(String keywork);

}
