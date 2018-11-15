package com.millenniumit.cdraggregation.dao;

import com.millenniumit.cdraggregation.item.Customer;

import java.util.List;

public interface CustomerDao {
    public void insert(List<? extends Customer> customers);
    List<Customer> loadAllCustomers();
}
