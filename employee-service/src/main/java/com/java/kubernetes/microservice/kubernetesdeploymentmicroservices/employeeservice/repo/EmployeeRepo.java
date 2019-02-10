package com.java.kubernetes.microservice.kubernetesdeploymentmicroservices.employeeservice.repo;

import com.java.kubernetes.microservice.kubernetesdeploymentmicroservices.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    List<Employee> findByLastName(String lastName);
}
