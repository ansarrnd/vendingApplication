package com.vending;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Product implements Comparable<Product> {

    private String itemName;
    private String price;
    private String description;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product(String itemName, String price, String description, int priority) {
        this.itemName = itemName;
        this.price = price;
        this.description = description;
    }

    public Product(String itemName, String price, String description, int priority, String date, boolean state, boolean visible) {
        this.itemName = itemName;
        this.price = price;
        this.description = description;
    }

    private static String setCreationDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return sdf.format(date);
    }

    @Override
    public String toString() {
        return "Task{" +
                "itemName='" + itemName + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(itemName, product.itemName) && Objects.equals(price, product.price) && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, price, description);
    }

    @Override
    public int compareTo( Product product) {
        return this.getItemName().compareTo(product.getItemName());
    }
}