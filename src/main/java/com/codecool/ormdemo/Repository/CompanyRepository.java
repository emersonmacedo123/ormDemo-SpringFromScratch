package com.codecool.ormdemo.Repository;

import com.codecool.ormdemo.Model.Company;
import com.codecool.ormdemo.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
