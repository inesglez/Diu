package com.example.actividades1;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContadorPulsaciones extends Application {
    private int contador = 0; // Variable del contador
    private Label etiquetaContador;

    @Override
    public void start(Stage escenarioPrincipal) {
        try {
            // Contenedor principal
            VBox raiz = new VBox();
            raiz.setPadding(new Insets(20, 20, 20, 20));
            raiz.setSpacing(20);
            raiz.setAlignment(Pos.CENTER);
            raiz.setStyle("-fx-background-color: red");


            // HBox para botones
            HBox botones = new HBox();
            botones.setSpacing(10);
            botones.setAlignment(Pos.CENTER);

            // Botones para sumar, restar y reiniciar
            Button botonSumar = new Button("+");
            Button botonRestar = new Button("-");
            Button botonReiniciar = new Button("0");

            // Estilo para el botón de reiniciar
            botonReiniciar.setStyle("-fx-background-color: black; -fx-text-fill: white;");

            // Añadir funcionalidad a los botones
            botonSumar.setOnAction(e -> sumar());
            botonRestar.setOnAction(e -> restar());
            botonReiniciar.setOnAction(e -> reiniciar());

            // Añadir botones al HBox
            botones.getChildren().addAll(botonSumar, botonRestar, botonReiniciar);

            // Etiqueta para mostrar el valor del contador
            etiquetaContador = new Label(String.valueOf(contador));
            etiquetaContador.setFont(Font.font("Arial", 40));
            etiquetaContador.setTextFill(Color.BLUE); // Texto en azul
            etiquetaContador.setStyle(" -fx-text-fill: blue; -fx-alignment: center;");
            etiquetaContador.setMinWidth(100);  // Anchura mínima de la etiqueta
            etiquetaContador.setMinHeight(60);  // Altura mínima de la etiqueta
            etiquetaContador.setAlignment(Pos.CENTER); // Alineación centrada

            // Añadir botones y etiqueta al contenedor principal
            raiz.getChildren().addAll(botones, etiquetaContador);

            // Configuración de la escena
            Scene escena = new Scene(raiz, 300, 200);
            escenarioPrincipal.setTitle("Contador");
            escenarioPrincipal.setScene(escena);
            escenarioPrincipal.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para sumar al contador
    private void sumar() {
        contador++;
        actualizarEtiqueta();
    }

    // Método para restar al contador
    private void restar() {
        contador--;
        actualizarEtiqueta();
    }

    // Método para reiniciar el contador
    private void reiniciar() {
        contador = 0;
        actualizarEtiqueta();
    }

    // Método para actualizar la etiqueta
    private void actualizarEtiqueta() {
        etiquetaContador.setText(String.valueOf(contador));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
