package com.example.pulsadorfxml.controller;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ControladorPulsador {
    public IntegerProperty numPulsaciones = new SimpleIntegerProperty();


    @FXML
    private void setContador() {
        contador.setText(String.valueOf(numPulsaciones.get()));
    }

    @FXML
    private void suma() {
        numPulsaciones.set(numPulsaciones.get() + 1);
        setContador();
        modificaBarra();
    }

    @FXML
    private void resta() {
        numPulsaciones.set(numPulsaciones.get() - 1);
        setContador();
        modificaBarra();
    }

    @FXML
    private void resetea() {
        numPulsaciones.set(0);
        setContador();
        modificaBarra();
    }

    @FXML
    private void ponerContador() {
        int nuevoValor = Integer.parseInt(manual.getText());
        numPulsaciones.set(nuevoValor);
        setContador();
        modificaBarra();
    }

    @FXML
    private void modificaBarra() {
        int maxValor = 50;
        double progreso = (double) numPulsaciones.get() / maxValor; // Calcula el progreso
        barra.setProgress(progreso); // Actualiza el progreso de la barra
    }

    @FXML
    private TextField manual;

    @FXML
    private ProgressBar barra;
    @FXML
    private Scene escena;

    @FXML
    private VBox raiz;

    @FXML
    private Label contador;

    @FXML
    private Button bt1, bt2, bt3;

    @FXML
    private void initialize() {
        contador.setText(String.valueOf(numPulsaciones.get()));
        numPulsaciones.addListener((observable, oldVal, newVal) -> {
            contador.setText(String.valueOf(newVal));
            modificaBarra();
        });

    }
    public IntegerProperty numProperty() {
        return numPulsaciones;
    }
}