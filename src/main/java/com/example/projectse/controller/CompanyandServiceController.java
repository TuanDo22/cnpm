package com.example.projectse.controller;

import com.example.projectse.entity.ListCompany;
import com.example.projectse.entity.ServiceEntity;
import com.example.projectse.reponsitory.ServiceRepository;
import com.example.projectse.service.impl.Servicess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CompanyandServiceController {
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private Servicess servicess;
    @GetMapping("/service")
    public String service(Model model){
        Iterable<ServiceEntity> serviceEntityIterable = serviceRepository.findAll();
        model.addAttribute("listService" , serviceEntityIterable);
        return "service";
    }
    @RequestMapping("/deleteID/{id}")
    public String deleteID(@PathVariable("id") Long id ){
        servicess.deleteService(id);
        return "redirect:/service";
    }
    @GetMapping("/service/new")
    public String showNewform1(Model model){
        model.addAttribute("service" , new  ServiceEntity());
        model.addAttribute("pageTitle" , "add new service" );
        return "serviceForm";
    }
    @PostMapping("/service/save")
    public String saveID(ServiceEntity serviceEntity){
        servicess.saveID(serviceEntity);
        return "redirect:/service";
    }
    @GetMapping("/fixID/{id}")
    public String showFixForm(@PathVariable("id") Integer id , Model model , RedirectAttributes ra){
        try {
            ServiceEntity serviceEntity = servicess.fixCompanyID(id);
            model.addAttribute("service" , serviceEntity);
            model.addAttribute("pageTitle" , "Fix User(ID: "+id+")");
            return "serviceForm";
        }catch (Exception e){
            ra.addFlashAttribute("message" , "done");
            return "redirect:/service";
        }
    }

}
