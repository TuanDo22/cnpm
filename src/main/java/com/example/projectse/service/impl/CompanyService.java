package com.example.projectse.service.impl;

import com.example.projectse.dto.EmployeeDTO;
import com.example.projectse.entity.EmployeeCompany;
import com.example.projectse.entity.ListCompany;
import com.example.projectse.reponsitory.CompanyRepository;
import com.example.projectse.reponsitory.EmployeeRepository;
import com.example.projectse.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.ListenerNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements EmployeeService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    public void saveCompany(ListCompany listCompany){
         companyRepository.save(listCompany);
    }
    public EmployeeDTO convertToDTO(EmployeeCompany employeeCompany){
        return EmployeeDTO.builder().id(employeeCompany.getId())
                .name(employeeCompany.getName())
                .salary(employeeCompany.getSalary())
                .phone(employeeCompany.getPhone())
                .location(employeeCompany.getLocation())
                .build();
    }


    public ListCompany fixCompany(long id) throws ListenerNotFoundException {
         Optional<ListCompany> listCompany = companyRepository.findById(id);
         if (listCompany.isPresent()){
             return listCompany.get();
         }
         throw new ListenerNotFoundException("Not find ID" + id);
    }

    public void delete(long id) {
        companyRepository.deleteById(id);

    }
    public List<ListCompany> list(String keywork){
        if(keywork != null){
            return companyRepository.findAll(keywork);
        }
        return companyRepository.findAll();
    }

    @Override
    public List<EmployeeDTO> findByCompanyId(long id) {
        return companyRepository.findById(id).get().getEmployeeCompanies().stream().map(x->convertToDTO(x)).toList();
    }
    public void deleteId(Long id){
        employeeRepository.deleteById(id);
    }
}
