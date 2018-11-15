package com.millenniumit.cdraggregation.itemprocessor;

import java.util.List;

import com.millenniumit.cdraggregation.dao.CustomerDao;
import com.millenniumit.cdraggregation.item.Customer;
import org.springframework.batch.item.ItemWriter;

public class Writer implements ItemWriter<Customer> {

    private final CustomerDao customerDao;

    public Writer(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void write(List<? extends Customer> customers) throws Exception {
        customerDao.insert(customers);
    }
}