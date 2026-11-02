package com.pluralsight;

public class Transaction {
    private String vendorInfo;
    private String description;
    private int deposit;
    private int payments;

    public Transaction(String vendorInfo, String description, int deposit, int payments) {
        this.vendorInfo = vendorInfo;
        this.description = description;
        this.deposit = deposit;
        this.payments = payments;
    }

    public String getVendorInfo() {
        return vendorInfo;
    }

    public void setVendorInfo(String vendorInfo) {
        this.vendorInfo = vendorInfo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getPayments() {
        return payments;
    }

    public void setPayments(int payments) {
        this.payments = payments;
    }
}
