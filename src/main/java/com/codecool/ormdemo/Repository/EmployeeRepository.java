package com.codecool.ormdemo.Repository;

import com.codecool.ormdemo.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByFirstNameStartingWith (String firstName);

    List<Employee> findEmployeesByCompany_Id(Long companyId);


}
