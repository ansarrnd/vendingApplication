package com.vending;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

/**
 * JavaFX App
 */
public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("/customer.fxml");
        loader.setLocation(xmlUrl);
        Parent root = loader.load();

        stage.setTitle("Vending Machine");
        stage.setScene(new Scene(root));
        stage.show();
    }

}