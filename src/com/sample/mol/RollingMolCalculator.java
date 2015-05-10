package com.sample.mol;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.comparators.NullComparator;
import org.apache.commons.lang.time.DateUtils;

import com.sample.mol.model.Customer;
import com.sample.mol.model.MaxOrderLimitType;
import com.sample.mol.model.OpenOrdersData;
import com.sample.mol.model.Order;
import com.sample.mol.model.RollingPeriod;

/**
 * Created by fgallois on 6/30/14.
 */
public class RollingMolCalculator implements Calculator {

    private static final NullComparator NULL_COMPARATOR = new NullComparator(true);

    private static final Comparator<MolResult> REMAINING_NUMBER_OF_PURCHASE_COMPARATOR = new Comparator<MolResult>() {
        @Override
        public int compare(final MolResult molResult1, final MolResult molResult2) {
            return molResult1 == null ? (molResult2 == null ? 0 : Integer.MIN_VALUE)
                    : (molResult2 == null ? Integer.MAX_VALUE : NULL_COMPARATOR.compare(
                            molResult1.getRemainingNumberOfPurchases(), molResult2.getRemainingNumberOfPurchases()));
        }
    };

    private static final Comparator<MolResult> AVAILABLE_ORDER_DATE_COMPARATOR = new Comparator<MolResult>() {
        @Override
        public int compare(final MolResult molResult1, final MolResult molResult2) {
            return molResult1 == null ? (molResult2 == null ? 0 : Integer.MIN_VALUE)
                    : (molResult2 == null ? Integer.MAX_VALUE : NULL_COMPARATOR.compare(
                            molResult1.getNextAvailableOrderDate(), molResult2.getNextAvailableOrderDate()));
        }
    };

    private static final Comparator<MolResult> OPEN_ORDER_COMPARATOR = new Comparator<MolResult>() {
        @Override
        public int compare(final MolResult molResult1, final MolResult molResult2) {
            return molResult1 == null ? (molResult2 == null ? 0 : Integer.MIN_VALUE)
                    : (molResult2 == null ? Integer.MAX_VALUE : NULL_COMPARATOR.compare(
                            molResult1.getNumberOfOpenOrders(), molResult2.getNumberOfOpenOrders()));
        }
    };

    @Override
    public AbstractResult execute(final Customer customer) {
        return execute(customer, null);
    }

    @Override
    public AbstractResult execute(final Customer customer, final Order orderToExclude) {
        List<MolResult> results = new ArrayList<MolResult>();
        for (RollingPeriod period : customer.getClient().getRollingPeriods()) {
            if (isActivePeriod(period)) {
                results.add(getMolResultForPeriod(customer.getCustomerID(), period, orderToExclude));
            }
        }

        return cleanMolResults(customer.getCustomerID(), results);
    }

    private boolean isActivePeriod(final RollingPeriod period) {
        boolean result = false;

        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMdd");
        if (dateFormatter.format(new Date()).compareTo(dateFormatter.format(period.getStartDate())) >= 0
                && dateFormatter.format(new Date()).compareTo(dateFormatter.format(period.getEndDate())) <= 0) {
            result = true;
        }

        return result;
    }

    private MolResult getMolResultForPeriod(final String customerId, final RollingPeriod period,
            final Order orderToExclude) {
        MolResult result;
        // Service call to retrieve OpenOrderData has been removed for the sample.
        OpenOrdersData openOrdersData = new OpenOrdersData();

        if (openOrdersData.getOrderscount() >= period.getMaxNumberOfOrders()) {
            Date nextAvailableOrderDate = DateUtils.addDays(openOrdersData.getOrderoldestdate(),
                    period.getTimePeriodInDays() + 1);
            result = MolResult.getInstance(customerId, 0, openOrdersData.getOrderscount().intValue(),
                    nextAvailableOrderDate, MaxOrderLimitType.ROLLING);
        } else {
            result = MolResult.getInstance(customerId, period.getMaxNumberOfOrders()
                    - openOrdersData.getOrderscount().intValue(), openOrdersData.getOrderscount().intValue(), null,
                    MaxOrderLimitType.ROLLING);
        }
        return result;
    }

    private MolResult cleanMolResults(final String customerId, final List<MolResult> molResults) {
        MolResult result;
        if (molResults.size() <= 0) {
            result = MolResult.getInstance(customerId, 0, 0, null, MaxOrderLimitType.ROLLING);
        } else {

            MolResult minRemainingPurchase = Collections.min(molResults, REMAINING_NUMBER_OF_PURCHASE_COMPARATOR);
            MolResult soonestAvailableOrder = Collections.min(molResults, AVAILABLE_ORDER_DATE_COMPARATOR);
            MolResult maxOpenOrder = Collections.max(molResults, OPEN_ORDER_COMPARATOR);

            result = MolResult.getInstance(customerId, minRemainingPurchase.getRemainingNumberOfPurchases(),
                    maxOpenOrder.getNumberOfOpenOrders(), soonestAvailableOrder.getNextAvailableOrderDate(),
                    MaxOrderLimitType.ROLLING);
        }
        return result;
    }
}
