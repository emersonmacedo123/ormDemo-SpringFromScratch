package com.codecool.ormdemo.Controller;

import com.codecool.ormdemo.Model.Company;
import com.codecool.ormdemo.Model.Employee;
import com.codecool.ormdemo.Service.CompanyService;
import com.codecool.ormdemo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;
    private final CompanyService companyService;


    @Autowired
    public EmployeeController(EmployeeService employeeService, CompanyService companyService) {
        this.employeeService = employeeService;
        this.companyService = companyService;
    }


    @GetMapping("/")
    public String index(Model model){
        return "index";
    }

    @GetMapping("/employees")
    public String employees(@RequestParam(required = false) Long companyId, Model model){
        List<Company> companyList = companyService.getAll();
        model.addAttribute("companies", companyService.getAll());


        Optional<Company> companyOptional = companyList.stream()
                .filter(company -> Objects.equals(company.getId(), companyId))
                        .findFirst();
        if(companyOptional.isPresent()){
            Company company = companyOptional.get();
            model.addAttribute("employees", company.getEmployees());
            model.addAttribute("choosenCompanyName", company.getName());
        } else{
            model.addAttribute("employees", employeeService.getAll());
            model.addAttribute("choosenCompanyName", "");
        }

        return "employees";
    }

    @GetMapping("/add-employee")
    public String displayAddEmployee(Model model){
        model.addAttribute("companies", companyService.getAll());
        model.addAttribute("employee", new Employee());
        return "add-new-employee";
    }

    @PostMapping("/add-employee")
    public String addEmployee(@Valid Employee employee, BindingResult result, Model model){
        model.addAttribute("companies", companyService.getAll());
        if(result.hasErrors()){
            return "add-new-employee";
        }
        employeeService.save(employee);
        return "redirect:/employees";
    }
}
