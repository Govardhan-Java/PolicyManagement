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
