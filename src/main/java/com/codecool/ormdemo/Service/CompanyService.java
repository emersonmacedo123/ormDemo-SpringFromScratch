package com.codecool.ormdemo.Service;

import com.codecool.ormdemo.Model.Company;
import com.codecool.ormdemo.Model.Employee;
import com.codecool.ormdemo.Repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAll(){
        return companyRepository.findAll();
    }

    public void save(Company company){
        companyRepository.save(company);
    }
}
