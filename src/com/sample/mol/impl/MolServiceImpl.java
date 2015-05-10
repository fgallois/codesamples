package com.sample.mol.impl;

import com.sample.mol.AbstractResult;
import org.springframework.beans.factory.annotation.Autowired;

import com.sample.mol.Calculator;
import com.sample.mol.MolProvider;
import com.sample.mol.MolService;
import com.sample.mol.model.Customer;
import com.sample.mol.model.Order;

/**
 * Created by fgallois on 6/25/14.
 */
public class MolServiceImpl implements MolService {

    @Autowired
    private MolProvider molProvider;

    @Override
    public AbstractResult performMolCalculation(final Customer customer, final Order orderToExclude) {
        Calculator calculator = molProvider.getMolCalculator(customer.getClient().getMaxOrderLimitType());

        return calculator.execute(customer, orderToExclude);
    }
}
