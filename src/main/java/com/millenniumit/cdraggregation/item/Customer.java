package com.millenniumit.cdraggregation.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
    private long id;
    private String firstName;
    private String lastName;

    public Customer() {
    }

    public Customer(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%d , firstName='%s', lastName='%s']", id, firstName, lastName);
    }
}
