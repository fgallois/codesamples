package com.sample.mol;

import java.util.Date;

import com.sample.mol.model.MaxOrderLimitType;

/**
 * Created by fgallois on 6/26/14.
 */
public final class MolResult extends AbstractResult {

    private String customerId;
    private Integer remainingNumberOfPurchases;
    private Integer numberOfOpenOrders;
    private Date nextAvailableOrderDate;
    private MaxOrderLimitType type;

    private MolResult() {
        setCheckable(new CheckableMol());
    }

    public static MolResult getInstance(final String customerId, final Integer remainingNumberOfPurchases,
            final Integer numberOfOpenOrders, final Date nextAvailableOrderDate, final MaxOrderLimitType type) {
        MolResult molResult = new MolResult();

        molResult.customerId = customerId;
        molResult.remainingNumberOfPurchases = remainingNumberOfPurchases;
        molResult.numberOfOpenOrders = numberOfOpenOrders;
        molResult.nextAvailableOrderDate = nextAvailableOrderDate;
        molResult.type = type;

        return molResult;
    }

    public Integer getRemainingNumberOfPurchases() {
        return remainingNumberOfPurchases;
    }

    public Integer getNumberOfOpenOrders() {
        return numberOfOpenOrders;
    }

    public Date getNextAvailableOrderDate() {
        return nextAvailableOrderDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public MaxOrderLimitType getType() {
        return type;
    }
}
