package com.vending;

import atlantafx.base.theme.PrimerDark;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;

public class BaseApplication extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        Application.setUserAgentStylesheet(new PrimerDark().getUserAgentStylesheet());

        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("/customer.fxml");
        loader.setLocation(xmlUrl);
        Parent root = loader.load();

        stage.setTitle("Vending Machine");
        stage.setScene(new Scene(root));
        stage.show();
        stage.setAlwaysOnTop(true);
        stage.requestFocus();
        stage.toFront();
        stage.setAlwaysOnTop(false);
    }
}
