package com.sample.mol.model;

import java.util.List;

/**
 * Created by fgallois on 5/5/15.
 */
public class Client {
    private List<RollingPeriod> rollingPeriods;
    private MaxOrderLimitType maxOrderLimitType;
    private Integer maxOrdersAllowed;

    public List<RollingPeriod> getRollingPeriods() {
        return rollingPeriods;
    }

    public void setRollingPeriods(final List<RollingPeriod> rollingPeriods) {
        this.rollingPeriods = rollingPeriods;
    }

    public MaxOrderLimitType getMaxOrderLimitType() {
        return maxOrderLimitType;
    }

    public void setMaxOrderLimitType(final MaxOrderLimitType maxOrderLimitType) {
        this.maxOrderLimitType = maxOrderLimitType;
    }

    public Integer getMaxOrdersAllowed() {
        return maxOrdersAllowed;
    }
}
