package com.example.quickresellerproject;

public class AdminItem {
    private String itemName;
    private String itemDescription;
    private String itemPrice;
    private String itemDate;

    public AdminItem(String itemName, String itemDescription, String itemPrice, String itemDate) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.itemDate = itemDate;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public String getItemDate() {
        return itemDate;
    }
}