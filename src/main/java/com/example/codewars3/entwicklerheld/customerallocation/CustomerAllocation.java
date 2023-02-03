package com.example.codewars3.entwicklerheld.customerallocation;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CustomerAllocation {
    public static Set<Set<Customer>> listOverlaps(Set<Customer> set1, Set<Customer> set2) {

        Set<Customer> set1Members = extractAllCustomers(set1);


        //1 list of Customer objects which are in both sets and have a relation to each other
        //All customers that are in a relation to each other should be in the same set of the result set.
        // implement me
        return null;
    }

    private static Set<Customer> extractAllCustomers(Set<Customer> set1) {
        Set<Customer> result = new HashSet<>();
        for (Customer each : set1) {
            result.add(each);
        }
        return Collections.emptySet();
    }
}
