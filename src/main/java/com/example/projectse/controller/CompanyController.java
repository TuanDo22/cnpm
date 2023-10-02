package com.example.projectse.controller;

import com.example.projectse.dto.ListCompany;
import com.example.projectse.reponsitory.CompanyRepository;
import com.example.projectse.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller("CompanyController")
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CompanyService companyService;
    @RequestMapping(value = "/listCompany")
    public String list(Model model){
        Iterable<ListCompany> list = companyRepository.findAll();
        model.addAttribute("list" , list);
        return "listCompany";
    }
    @GetMapping("/listCompany/new")
    public String showNewform(Model model){
        model.addAttribute("company" ,   new ListCompany());
        model.addAttribute("pageTitle" , "add new company" );
        return "companyform";
    }
    @PostMapping("/listCompany/save")
    public String save(ListCompany listCompany){
        companyService.saveCompany(listCompany);
        return "redirect:/listCompany";
    }
    @GetMapping("/fix/{id}")
    public String showFixForm(@PathVariable("id") Integer id , Model model , RedirectAttributes ra){
        try {
            ListCompany listCompany = companyService.fixCompany(id);
            model.addAttribute("company" , listCompany);
            model.addAttribute("pageTitle" , "Fix User(ID: "+id+")");
            return "companyform";
        }catch (Exception e){
            ra.addFlashAttribute("message" , "done");
            return "redirect:/listCompany";
        }
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id , Model model ){
        companyService.delete(id);
        return "redirect:/listCompany";
    }
    @RequestMapping("/search")
    public String view(Model model, @Param("keyword") String keyword){
        List<ListCompany> listCompanies = companyService.list(keyword);
        model.addAttribute("list" , listCompanies);
        model.addAttribute("keyword" , keyword);
        return "listCompany";
    }


}
