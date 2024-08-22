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
