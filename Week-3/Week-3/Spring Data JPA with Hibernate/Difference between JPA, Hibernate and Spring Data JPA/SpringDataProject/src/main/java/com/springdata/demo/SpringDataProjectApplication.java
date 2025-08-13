package com.springdata.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;

import com.springdata.demo.model.Employee;
import com.springdata.demo.service.EmployeeService;

@SpringBootApplication
@EntityScan(basePackages = "com.springdata.demo.model") // tells Spring where to find @Entity classes
@EnableJpaRepositories(basePackages = "com.springdata.demo.repository") // tells Spring where to find Repository interfaces
@ComponentScan(basePackages = "com.springdata.demo") // ensures all beans from your package are scanned
public class SpringDataProjectApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataProjectApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Employee emp = new Employee();
        emp.setName("Bhavya");
        emp.setRole("Developer");

        employeeService.addEmployee(emp);
    }
}
