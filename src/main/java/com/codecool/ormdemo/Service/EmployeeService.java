package com.codecool.ormdemo.Service;

import com.codecool.ormdemo.Model.Employee;
import com.codecool.ormdemo.Repository.CompanyRepository;
import com.codecool.ormdemo.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;

    public EmployeeService(EmployeeRepository employeeRepository, CompanyRepository companyRepository) {
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
    }

    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public void save(Employee employee){
        employeeRepository.save(employee);
    }

    public List<Employee> getEmployees(Long companyId) {
        if(companyId == null){
            return getAll();
        }
        return employeeRepository.findEmployeesByCompany_Id(companyId);
    }
}
