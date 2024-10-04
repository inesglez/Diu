package com.example.actividades1;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.File;
import javafx.fxml.FXMLLoader;


public class ContadorPulsaciones3 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(new File("/home/usuario/Diu/Actividades1/src/main/resources/com.example.actividades1/ContadorPulsaciones.fxml").toURI().toURL());

        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Contador");
        primaryStage.setScene(scene);
        primaryStage.show();
}
}
