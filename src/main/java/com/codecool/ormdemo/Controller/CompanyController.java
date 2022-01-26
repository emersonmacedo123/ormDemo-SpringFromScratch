package com.codecool.ormdemo.Controller;

import com.codecool.ormdemo.Model.Company;
import com.codecool.ormdemo.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/companies")
    public String displayEmployee(Model model){
        model.addAttribute("companies", companyService.getAll());
        return "companies";
    }

    @GetMapping("/add-company")
    public String displayAddCompany(Model model){
        model.addAttribute("company", new Company());
        return "add-company";
    }

    @PostMapping("/add-company")
    public String addCompany(@Valid Company company, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-company";
        }
        companyService.save(company);
        return "redirect:/companies";

    }



}
