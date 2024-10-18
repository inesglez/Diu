package com.example.conversor;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;

public class HelloController {

    @FXML
    private TextArea eurosTextArea;

    @FXML
    private TextArea dolaresTextArea;

    @FXML
    private Button convertirButton;

    // Conversión de euros a dólares (puedes ajustar el multiplicador)
    private final float conversionRate = 1.2F;

    @FXML
    public void initialize() {
        convertirButton.setOnAction(event -> convertirMoneda());
    }

    private void convertirMoneda() {
        try {
            // Obtener valor del área de texto de Euros
            String eurosText = eurosTextArea.getText();

            // Si el campo está vacío, mostrar mensaje de error
            if (eurosText.isEmpty()) {
                dolaresTextArea.setText("Ingrese una cantidad válida.");
                return;
            }

            // Convertir el texto de euros a float
            float euros = Float.parseFloat(eurosText);

            // Realizar la conversión de euros a dólares
            float dolares = euros * conversionRate;

            // Mostrar el resultado en el área de texto de Dólares
            dolaresTextArea.setText(String.format("%.2f", dolares));
        } catch (NumberFormatException e) {
            // Si el formato es incorrecto, mostrar un error
            dolaresTextArea.setText("Formato inválido.");
        }
    }
}
