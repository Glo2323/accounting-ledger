package com.pluralsight;

public class Transaction {
    private String vendorInfo;
    private String description;
    private int amount;

    public Transaction(String vendorInfo, String description, int amount) {
        this.vendorInfo = vendorInfo;
        this.description = description;
        this.amount = amount;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
