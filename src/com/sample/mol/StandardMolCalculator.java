package com.sample.mol;

import com.sample.mol.model.Customer;
import com.sample.mol.model.MaxOrderLimitType;
import com.sample.mol.model.Order;

/**
 * Created by fgallois on 6/25/14.
 */
public class StandardMolCalculator implements Calculator {

    // Commented out for code samples
    // @Autowired
    // private CustomerCredit customerCredit;

    @Override
    public AbstractResult execute(final Customer customer) {
        return execute(customer, null);
    }

    @Override
    public AbstractResult execute(final Customer customer, final Order orderToExclude) {
        final Integer maxOrdersAllowed = customer.getClient().getMaxOrdersAllowed();
        // final Integer numberOfOpenOrders = customerCredit.getOpenOrdersCount(customer.getCustomerID(),
        // orderToExclude);
        final Integer numberOfOpenOrders = 2;

        final Integer numberOfRemainingOrders = (maxOrdersAllowed - numberOfOpenOrders > 0) ? maxOrdersAllowed
                - numberOfOpenOrders : 0;

        return MolResult.getInstance(customer.getCustomerID(), numberOfRemainingOrders, numberOfOpenOrders, null,
                MaxOrderLimitType.STANDARD);
    }
}
