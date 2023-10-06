package com.example.projectse.controller;

import com.example.projectse.dto.EmployeeDTO;
import com.example.projectse.reponsitory.CompanyRepository;
import com.example.projectse.reponsitory.EmployeeRepository;
import com.example.projectse.service.EmployeeService;
import com.example.projectse.service.impl.CompanyService;
import com.example.projectse.service.impl.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    @Autowired
    private EmployeeServices employeeServices;



    @RequestMapping("/view/{id}")
    public String listEmployee(@PathVariable("id") long id, Model model) {
        List<EmployeeDTO> employee = service.findByCompanyId(id);
        model.addAttribute("employee", employee);
        return "view";
    }
    @RequestMapping("/delete1/{id}")
    public String delete(@PathVariable("id") Long id , Model model ){
        List<EmployeeDTO> e = service.findByCompanyId(id);
        return "redirect:/view/{id}";
    }

}
