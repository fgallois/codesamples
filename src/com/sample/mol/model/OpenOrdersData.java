package com.sample.mol.model;

import java.util.Date;

/**
 * Created by fgallois on 5/5/15.
 */
public class OpenOrdersData {
    private Integer orderscount;
    private Date orderoldestdate;

    public Integer getOrderscount() {
        return orderscount;
    }

    public void setOrderscount(final Integer orderscount) {
        this.orderscount = orderscount;
    }

    public Date getOrderoldestdate() {
        return orderoldestdate;
    }

    public void setOrderoldestdate(final Date orderoldestdate) {
        this.orderoldestdate = orderoldestdate;
    }
}
