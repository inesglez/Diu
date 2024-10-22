package com.example.conversor;

import Modelo.ExcepcionMoneda;
import Modelo.MonedaVO;
import Modelo.repository.impl.MonedaRepositoryImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Iterator;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, ExcepcionMoneda {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent root = fxmlLoader.load();
        HelloController controller = fxmlLoader.getController();
        modelo modelo= new modelo();
        MonedaRepositoryImpl monedaRepository = new MonedaRepositoryImpl();
        modelo.setMonedaRepository(monedaRepository);
        controller.setModelo(modelo);
        controller.getMultiplicador();

        stage.setTitle("Conversor");
        stage.setScene(new Scene(root));
        stage.show();
    }


    public HelloApplication() {
    }

    public static void main(String[] args) {
        launch();
    }
}

