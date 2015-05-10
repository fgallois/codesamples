package com.sample.mol.model;

/**
 * Created by fgallois on 5/5/15.
 */
public class Customer {
    private String customerID;
    private Client client;

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(final String customerID) {
        this.customerID = customerID;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(final Client client) {
        this.client = client;
    }
}
