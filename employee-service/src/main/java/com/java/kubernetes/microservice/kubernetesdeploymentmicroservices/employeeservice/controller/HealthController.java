package com.java.kubernetes.microservice.kubernetesdeploymentmicroservices.employeeservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping
    public String healthcheck() {
        return "Health is up!";
    }
}
