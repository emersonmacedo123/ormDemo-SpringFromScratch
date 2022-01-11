package com.codecool.ormdemo.Service;

import com.codecool.ormdemo.Model.Employee;
import com.codecool.ormdemo.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.repository = employeeRepository;
    }

}
