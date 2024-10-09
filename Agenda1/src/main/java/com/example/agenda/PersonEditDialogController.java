package com.example.agenda;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * Dialog to edit details of a person.
 *
 * @author Marco Jakob
 */
public class PersonEditDialogController {

    @FXML
    private TextField NombreField;
    @FXML
    private TextField ApellidosField;
    @FXML
    private TextField CalleField;
    @FXML
    private TextField CodigoPostalField;
    @FXML
    private TextField CiudadField;
    @FXML
    private TextField FechaNacimientoField;


    private Stage dialogStage;
    private Person person;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the person to be edited in the dialog.
     *
     * @param person
     */
    public void setPerson(Person person) {
        this.person = person;

        NombreField.setText(person.getNombre());
        ApellidosField.setText(person.getApellidos());
        CalleField.setText(person.getCalle());
        CodigoPostalField.setText(Integer.toString(person.getCodigoPostal()));
        CiudadField.setText(person.getCiudad());
        FechaNacimientoField.setText(DateUtil.format(person.getFechaNacimiento()));
        FechaNacimientoField.setPromptText("dd.mm.yyyy");
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            person.setNombre(NombreField.getText());
            person.setApellidos(ApellidosField.getText());
            person.setCalle(CalleField.getText());
            person.setCodigoPostal(Integer.parseInt(CodigoPostalField.getText()));
            person.setCiudad(CiudadField.getText());
            person.setFechaNacimiento(DateUtil.parse(FechaNacimientoField.getText()));

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (NombreField.getText() == null || NombreField.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (ApellidosField.getText() == null || ApellidosField.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }
        if (CalleField.getText() == null || CalleField.getText().length() == 0) {
            errorMessage += "No valid street!\n";
        }

        if (CodigoPostalField.getText() == null || CodigoPostalField.getText().length() == 0) {
            errorMessage += "No valid postal code!\n";
        } else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(CodigoPostalField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid postal code (must be an integer)!\n";
            }
        }

        if (CiudadField.getText() == null || CiudadField.getText().length() == 0) {
            errorMessage += "No valid city!\n";
        }

        if (FechaNacimientoField.getText() == null || FechaNacimientoField.getText().length() == 0) {
            errorMessage += "No valid birthday!\n";
        } else {
            if (!DateUtil.validDate(FechaNacimientoField.getText())) {
                errorMessage += "No valid birthday. Use the format dd.mm.yyyy!\n";
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("Ninguna persona selecionada");
            alert.setContentText("Por favor seleciona una persona de la tabla.");
            alert.showAndWait();
            return false;
        }
    }
}