package com.vending;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.Objects;

public class ProductCell extends ListCell<Product> {

    @FXML
    private Label itemName;

    @FXML
    private Label price;

    @FXML
    private ImageView productImage;

    public ProductCell() {
        loadFXML();
    }

    private void loadFXML() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/product.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void updateItem(Product item, boolean empty) {
        super.updateItem(item, empty);

        if(empty || item == null) {
            setText(null);
            setContentDisplay(ContentDisplay.TEXT_ONLY);
        }
        else {
            itemName.setText(item.getItemName());
            price.setText(item.getPrice());
            Image fruitImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(getItemName(getIndex()+1))));
            productImage.setImage(fruitImage);

            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        }
    }

    private String getItemName(int position) {
        if (position % 3 == 1)
            return "/img/bananas.png";
        else if (position % 3 == 2)
            return "/img/apple.png";
        else
            return "/img/orange.png";
    }
}