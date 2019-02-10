package com.java.kubernetes.microservice.kubernetesdeploymentmicroservices.employeeservice.controller;

import com.java.kubernetes.microservice.kubernetesdeploymentmicroservices.employeeservice.repo.EmployeeRepo;
import com.java.kubernetes.microservice.kubernetesdeploymentmicroservices.employeeservice.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeRepo repository;

    @PostMapping("/save")
    public String process() {
        // save a single Employee
        repository.save(new Employee("Jack", "Smith"));
        // save a list of Employee
        repository.saveAll(Arrays.asList(new Employee("Adam", "Johnson"), new Employee("Kim", "Smith"),
                new Employee("David", "Williams"), new Employee("Peter", "Davis")));

        return "Done";
    }

    @GetMapping("/findall")
    public String findAll() {
        String result = "";

        for (Employee emp : repository.findAll()) {
            result += emp.toString() + "<br>";
        }

        return result;
    }

    @GetMapping("/findbyid")
    public String findById(@RequestParam("id") long id) {
        String result = "";
        result = (repository.getOne(id)).toString();
        return result;
    }

    @GetMapping("/findbylastname")
    public String fetchDataByLastName(@RequestParam("lastname") String lastName) {
        String result = "";
        for (Employee emp : repository.findByLastName(lastName)) {
            result += emp.toString() + "<br>";
        }

        return result;
    }
}