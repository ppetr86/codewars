package com.example.entwicklerheld.customerallocation;

import java.util.*;

public class Customer {
    private final Map<RelationshipType, List<Customer>> relationships;
    private final Set<Contract> contracts;
    private final String first_name;
    private final String last_name;

    public Customer(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.relationships = new HashMap<>();
        this.contracts = new HashSet<>();
    }

    public String toString() {
        return first_name + " " + last_name;
    }

    public void addRelationship(RelationshipType relationshipType, Customer customer) {
        List<Customer> customers = relationships.get(relationshipType);
        if (customers == null) {
            customers = new ArrayList<>();
            relationships.put(relationshipType, customers);
        }
        customers.add(customer);
    }

    public List<Customer> getRelationships(RelationshipType relationshipType) {
        return relationships.getOrDefault(relationshipType, Collections.emptyList());
    }

    public void addContract(Contract contract) {
        contracts.add(contract);
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getFirst_name() {
        return first_name;
    }


    public List<Customer> getParents() {
        return getRelationships(RelationshipType.PARENT);
    }

    public List<Customer> getChildren() {
        return getRelationships(RelationshipType.CHILD);
    }

    public List<Customer> getPartners() {
        return getRelationships(RelationshipType.PARTNER);
    }

    public void addParent(Customer parent) {
        addRelationship(RelationshipType.PARENT, parent);
        parent.addRelationship(RelationshipType.CHILD, this);
    }

    public void addChild(Customer child) {
        addRelationship(RelationshipType.CHILD, child);
        child.addRelationship(RelationshipType.PARENT, this);
    }

    public void addPartner(Customer partner) {
        addRelationship(RelationshipType.PARTNER, partner);
        partner.addRelationship(RelationshipType.PARTNER, this);
    }

    public void addSibling(Customer sibling) {
        addRelationship(RelationshipType.SIBLING, sibling);
        sibling.addRelationship(RelationshipType.SIBLING, this);
    }

    public List<Customer> getSiblings() {
        return getRelationships(RelationshipType.SIBLING);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first_name, last_name);
    }
}
