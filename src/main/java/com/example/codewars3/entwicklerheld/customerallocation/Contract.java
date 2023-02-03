package com.example.codewars3.entwicklerheld.customerallocation;

import java.util.Map;

public class Contract {
    public Contract(String contractIdentifier) {
        this.contractIdentifier = contractIdentifier;
    }

    private String contractIdentifier;
    private Map<Role, Customer> roles = new java.util.HashMap<>();

    public String getContractIdentifier() {
        return contractIdentifier;
    }

    public void setContractIdentifier(String contractIdentifier) {
        this.contractIdentifier = contractIdentifier;
    }

    public Map<Role, Customer> getRoles() {
        return roles;
    }

    public void setRoles(Map<Role, Customer> roles) {
        this.roles = roles;
    }

    public void addRole(Role role, Customer customer) {
        customer.addContract(this);
        roles.put(role, customer);
    }
}
