package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Transactions {
    //properties and fields
    private String LocalDate;

    private String LocalTime;

    private String description;

    private String vendor;

    private double amount;


    public Transactions(String LocalDate, String LocalTime, String description, String vendor, double amount) {
        this.LocalDate = LocalDate;
        this.LocalTime = LocalTime;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public String getLocalDate() {
        return LocalDate;
    }

    public void setLocalDate(String LocalDate) {
        this.LocalDate = LocalDate;
    }

    public String getLocalTime() {
        return LocalTime;
    }

    public void setLocalTime(String LocalTime) {
        this.LocalTime = LocalTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
