package com.example.pulsadorfxml;

import com.example.pulsadorfxml.controller.ControladorPulsador;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Pulsador extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Pulsador.class.getResource("pulsador.fxml"));
        Scene escena = new Scene(fxmlLoader.load(), 600, 400);
        ControladorPulsador controlador1 = fxmlLoader.getController();
        stage.setTitle("Contador 1");
        stage.setScene(escena);
        stage.setX(50);
        stage.show();

        FXMLLoader loader = new FXMLLoader(Pulsador.class.getResource("pulsador.fxml"));
        Scene escena2 = new Scene(loader.load(), 600, 400);
        ControladorPulsador controlador2 = loader.getController();
        Stage stage2 = new Stage();
        stage2.setTitle("Contador 2");
        stage2.setScene(escena2);
        stage2.setX(800);
        stage2.show();
        System.out.println("SSSSSSSSSSSSSSSSSSS"+controlador1);
        controlador1.numProperty().bindBidirectional(controlador2.numProperty());

    }
    public static void main(String[] args) {
        launch(args);
    }
}