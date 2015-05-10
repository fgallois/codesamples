package com.sample.mol.model;

import java.util.Date;

/**
 * Created by fgallois on 5/5/15.
 */
public class RollingPeriod {
    private Date startDate;
    private Date endDate;
    private Integer maxNumberOfOrders;
    private Integer timePeriodInDays;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(final Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(final Date endDate) {
        this.endDate = endDate;
    }

    public Integer getMaxNumberOfOrders() {
        return maxNumberOfOrders;
    }

    public void setMaxNumberOfOrders(final Integer maxNumberOfOrders) {
        this.maxNumberOfOrders = maxNumberOfOrders;
    }

    public Integer getTimePeriodInDays() {
        return timePeriodInDays;
    }

    public void setTimePeriodInDays(final Integer timePeriodInDays) {
        this.timePeriodInDays = timePeriodInDays;
    }
}
