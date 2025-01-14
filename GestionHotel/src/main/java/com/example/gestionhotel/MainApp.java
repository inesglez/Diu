package com.example.gestionhotel;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
            BorderPane root = ventanaPrincipal.getLayout();
            Scene scene = new Scene(root, 800, 600);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Gestión de Hotel");
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
