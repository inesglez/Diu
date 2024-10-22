package com.example.conversor;
import Modelo.ExcepcionMoneda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField euros;

    @FXML
    private TextField dolares;

    @FXML
    private Button convertirButton;

    private modelo modelo;
    float multiplicador;

    @FXML
//    public void initialize() {
//        convertirButton.setOnAction(event -> modelo.ConversorMoneda());
//    }
    public float getMultiplicador () throws ExcepcionMoneda {
        multiplicador = modelo.RecuperarMultiplicador();
        return multiplicador;
    }

    public void setModelo(modelo modelo) {
        this.modelo = modelo;
    }

    public void boton (){
        float cantidadIngresada = Float.parseFloat(euros.getText());
        float cantidadDolares;
        cantidadDolares = modelo.ConversorMoneda(multiplicador, cantidadIngresada);
        dolares.setText(String.format("%.2f", cantidadDolares));



}
}
