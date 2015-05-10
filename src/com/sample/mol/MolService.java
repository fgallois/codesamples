package com.sample.mol;

import com.sample.mol.model.Customer;
import com.sample.mol.model.Order;

/**
 * Created by fgallois on 6/25/14.
 */
public interface MolService {
    AbstractResult performMolCalculation(final Customer customer, final Order orderToExclude);
}
