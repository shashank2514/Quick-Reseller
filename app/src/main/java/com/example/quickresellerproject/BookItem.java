package com.example.quickresellerproject;

public class BookItem {
    private String itemName;
    private String itemDescription;
    private String itemPrice;
    private String itemDate;

    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BookItem(String itemName, String itemDescription, String itemPrice, String itemDate, String imageUrl) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.itemDate = itemDate;
        this.imageUrl=imageUrl;
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
