package com.vending;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class ProductCellFactory implements Callback<ListView<Product>, ListCell<Product>> {

    @Override
    public ListCell<Product> call(ListView<Product> param) {
        return new ProductCell();
    }
}