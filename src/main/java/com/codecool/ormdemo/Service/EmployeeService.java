package com.codecool.ormdemo.Service;

import com.codecool.ormdemo.Model.Employee;
import com.codecool.ormdemo.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.repository = employeeRepository;
    }

    public List<Employee> getAll(){
        return repository.findAll();
    }

    public void save(Employee employee){
        repository.save(employee);
    }

}
