package com.example.projectse.service;

import com.example.projectse.dto.ListCompany;
import com.example.projectse.reponsitory.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.ListenerNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    public void saveCompany(ListCompany listCompany){
         companyRepository.save(listCompany);

    }
    public ListCompany fixCompany(Integer id) throws ListenerNotFoundException {
         Optional<ListCompany> listCompany = companyRepository.findById(id);
         if (listCompany.isPresent()){
             return listCompany.get();
         }
         throw new ListenerNotFoundException("Not find ID" + id);
    }

    public void delete(Integer id) {
        companyRepository.deleteById(id);

    }
    public List<ListCompany> list(String keywork){
        if(keywork != null){
            return companyRepository.findAll(keywork);
        }
        return companyRepository.findAll();
    }

}
