package com.vending;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer {

    @FXML
    public Label itemName;

    @FXML
    public Label price;

    @FXML
    private ListView<Product> listView;

    @FXML
    private MenuBar menuBar;

    @FXML
    private void initialize() {

        setItems();

        listView.setCellFactory(new ProductCellFactory());
        MultipleSelectionModel<Product> selectionModel = listView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        selectionModel.selectedItemProperty().addListener((observableValue, oldProduct, product) -> {

            itemName.setText(product.getItemName());
            price.setText(product.getPrice());
        });

        Menu menu = menuBar.getMenus().get(0);
        ObservableList<MenuItem> menus = menu.getItems();

        MenuItem addProducts = menus.get(0);
        addProducts.setOnAction(actionEvent -> {
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File("src"));
            fileChooser.setInitialFileName("myfile.txt");

            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Text Files", "*.txt")
                    ,new FileChooser.ExtensionFilter("HTML Files", "*.htm")
            );

            Button button = new Button("Select File");
            button.setOnAction(e -> {
                File selectedFile = fileChooser.showOpenDialog(stage);
                StringBuilder line = new StringBuilder();
                try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                    String tmp;
                    while ((tmp = reader.readLine()) != null)
                        line.append(tmp);


                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                Gson gson = new Gson();

                List<Product> products = gson.fromJson(String.valueOf(line), new TypeToken<List<Product>>(){}.getType());

                ProductSingleton.getInstance().products.clear();
                ProductSingleton.getInstance().products.addAll(products);
                ProductSingleton.getInstance().addProducts();

                stage.close();
            });

            VBox vBox = new VBox(button);
            Scene scene = new Scene(vBox, 600, 600);
            stage.setScene(scene);
            stage.show();
        });

        MenuItem reset = menus.get(1);
        reset.setOnAction(actionEvent -> {
            listView.getItems().clear();
            setItems();
        });

        ProductSingleton.getInstance().addObserver(this);
    }

    private void setItems() {
        ProductSingleton.getInstance().products.clear();
        ObservableList<Product> wordsList = ProductSingleton.getInstance().products;
        wordsList.add(new Product("Banana 1KG Packed", "RM 4.00","description", 0));
        wordsList.add(new Product("Apple 1KG Packed", "RM 4.00","description", 1));
        wordsList.add(new Product("Orange 1KG Packed", "RM 4.00","description", 2));
        wordsList.add(new Product("Banana 1KG Packed", "RM 4.00","description", 0));
        wordsList.add(new Product("Apple 1KG Packed", "RM 4.00","description", 1));
        wordsList.add(new Product("Orange 1KG Packed", "RM 4.00","description", 2));
        wordsList.add(new Product("Banana 1KG Packed", "RM 4.00","description", 0));
        wordsList.add(new Product("Apple 1KG Packed", "RM 4.00","description", 1));
        wordsList.add(new Product("Orange 1KG Packed", "RM 4.00","description", 2));
        listView.getItems().addAll(wordsList);
    }

    @Override
    public void update(Observable o, Object arg) {
        listView.getItems().clear();
        listView.getItems().addAll(ProductSingleton.getInstance().products);
    }
}
