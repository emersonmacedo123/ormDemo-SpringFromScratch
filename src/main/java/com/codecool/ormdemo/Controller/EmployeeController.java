package com.codecool.ormdemo.Controller;

import com.codecool.ormdemo.Model.Employee;
import com.codecool.ormdemo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/")
    public String index(Model model){
        return "index";
    }

    @GetMapping("employees")
    public String employees(Model model){
        model.addAttribute("employees", employeeService.getAll());
        return "employees";
    }

    @GetMapping("/add-employee")
    public String displayAddEmployee(Model model){
        model.addAttribute("employee", new Employee());
        return "add-new-employee";
    }

    @PostMapping("/add-employee")
    public String addEmployee(@Valid Employee employee, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-new-employee";
        }
        employeeService.save(employee);
        return "redirect:/employees";
    }
}
