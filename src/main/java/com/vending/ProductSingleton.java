package com.vending;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Observable;

public class ProductSingleton extends Observable {

    private static ProductSingleton productSingleton;
    ObservableList<Product> products = FXCollections.observableArrayList();

    private ProductSingleton() {}

    public static ProductSingleton getInstance() {
        if (productSingleton == null) {
            productSingleton = new ProductSingleton();
        }

        return productSingleton;
    }

    public void addProducts() {
        setChanged();
        notifyObservers();
    }

}
