package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    private LocalDate date;
    private LocalTime time;
    private String vendorInfo;
    private String description;
    private int amount;

    public Transaction(LocalDate date, LocalTime time, String vendorInfo, String description, int amount) {
        this.date = date;
        this.time = time;
        this.vendorInfo = vendorInfo;
        this.description = description;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
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
