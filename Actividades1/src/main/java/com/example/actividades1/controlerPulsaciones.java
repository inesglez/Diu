package com.example.actividades1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class controlerPulsaciones extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(controlerPulsaciones.class.getResource("/com/example/actividades1/ContadorPulsaciones.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Contador");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}