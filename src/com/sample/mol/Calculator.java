package com.sample.mol;

import com.sample.mol.model.Customer;
import com.sample.mol.model.Order;

/**
 * Created by fgallois on 6/25/14.
 */
public interface Calculator {
    AbstractResult execute(Customer customer);

    AbstractResult execute(Customer customer, Order orderToExclude);
}
