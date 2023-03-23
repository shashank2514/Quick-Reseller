package com.example.quickresellerproject;

public class ReadWriteItemDetails {
    public   String name,description,price,Image_url;

    public ReadWriteItemDetails(String name, String description, String price, String image_url) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.Image_url=image_url;
    }
    public ReadWriteItemDetails(){

    }
}


