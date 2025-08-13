package com.springdata.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springdata.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
