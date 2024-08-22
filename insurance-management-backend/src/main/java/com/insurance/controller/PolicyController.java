package com.insurance.controller;

import com.insurance.dto.PolicyDTO;
import com.insurance.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @GetMapping
    public List<PolicyDTO> getAllPolicies() {
        return policyService.getAllPolicies();
    }

    @GetMapping("/{id}")
    public PolicyDTO getPolicyById(@PathVariable Long id) {
        return policyService.getPolicyById(id);
    }

    @PostMapping
    public PolicyDTO createPolicy(@RequestBody PolicyDTO policyDTO) {
        return policyService.createPolicy(policyDTO);
    }
}
/src/main/java/com/insurance/entity/Policy.java
        java
Copy code
package com.insurance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String policyNumber;
    private String policyHolderName;
    private double coverageAmount;

    // Constructors, getters, and setters

    public Policy() {
    }

    public Policy(Long id, String policyNumber, String policyHolderName, double coverageAmount) {
        this.id = id;
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.coverageAmount = coverageAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public void setPolicyHolderName(String policyHolderName) {
        this.policyHolderName = policyHolderName;
    }

    public double getCoverageAmount() {
        return coverageAmount;
    }

    public void setCoverageAmount(double coverageAmount) {
        this.coverageAmount = coverageAmount;
    }
}
/src/main/java/com/insurance/repository/PolicyRepository.java
        java
Copy code
package com.insurance.repository;

import com.insurance.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<Policy, Long> {
}
/src/main/java/com/insurance/service/PolicyService.java
        java
Copy code
package com.insurance.service;

import com.insurance.dto.PolicyDTO;
import com.insurance.entity.Policy;
import com.insurance.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    public List<PolicyDTO> getAllPolicies() {
        return policyRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public PolicyDTO getPolicyById(Long id) {
        return policyRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("Policy not found"));
    }

    public PolicyDTO createPolicy(PolicyDTO policyDTO) {
        Policy policy = convertToEntity(policyDTO);
        Policy savedPolicy = policyRepository.save(policy);
        return convertToDTO(savedPolicy);
    }

    private PolicyDTO convertToDTO(Policy policy) {
        return new PolicyDTO(policy.getId(), policy.getPolicyNumber(), policy.getPolicyHolderName(), policy.getCoverageAmount());
    }

    private Policy convertToEntity(PolicyDTO policyDTO) {
        return new Policy(policyDTO.getId(), policyDTO.getPolicyNumber(), policyDTO.getPolicyHolderName(), policyDTO.getCoverageAmount());
    }
}
/src/main/java/com/insurance/dto/PolicyDTO.java
        java
Copy code
package com.insurance.dto;

public class PolicyDTO {

    private Long id;
    private String policyNumber;
    private String policyHolderName;
    private double coverageAmount;

    // Constructors, getters, and setters

    public PolicyDTO() {
    }

    public PolicyDTO(Long id, String policyNumber, String policyHolderName, double coverageAmount) {
        this.id = id;
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.coverageAmount = coverageAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public void setPolicyHolderName(String policyHolderName) {
        this.policyHolderName = policyHolderName;
    }

    public double getCoverageAmount() {
        return coverageAmount;
    }

    public void setCoverageAmount(double coverageAmount) {
        this.coverageAmount = coverageAmount;
    }
}




