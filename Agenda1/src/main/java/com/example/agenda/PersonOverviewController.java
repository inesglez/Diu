package com.example.agenda;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class PersonOverviewController {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> NombreColumn;
    @FXML
    private TableColumn<Person, String> ApellidosColumn;

    @FXML
    private Label NombreLabel;
    @FXML
    private Label ApellidosLabel;
    @FXML
    private Label CalleLabel;
    @FXML
    private Label CodigoPostalLabel;
    @FXML
    private Label CiudadLabel;
    @FXML
    private Label FechaNacimientoLabel;

    // Reference to the main application.
    private Agenda agenda;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public PersonOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        NombreColumn.setCellValueFactory(cellData -> cellData.getValue().NombreProperty());
        ApellidosColumn.setCellValueFactory(cellData -> cellData.getValue().ApellidosProperty());
        // Clear person details.
        showPersonDetails(null);

        // Listen for selection changes and show the person details when changed.
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));

    }



    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param agenda
     */
    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;

        // Add observable list data to the table
        personTable.setItems(agenda.getPersonData());
    }
    /**
     * Fills all text fields to show details about the person.
     * If the specified person is null, all text fields are cleared.
     *
     * @param person the person or null
     */
    private void showPersonDetails(Person person) {
        if (person != null) {
            // Fill the labels with info from the person object.
            NombreLabel.setText(person.getNombre());
            ApellidosLabel.setText(person.getApellidos());
            CalleLabel.setText(person.getCalle());
            CodigoPostalLabel.setText(Integer.toString(person.getCodigoPostal()));
            CiudadLabel.setText(person.getCiudad());
            FechaNacimientoLabel.setText(DateUtil.format(person.getFechaNacimiento()));

        } else {
            // Person is null, remove all the text.
            NombreLabel.setText("");
            ApellidosLabel.setText("");
            CalleLabel.setText("");
            CodigoPostalLabel.setText("");
            CiudadLabel.setText("");
            FechaNacimientoLabel.setText("");
        }
    }
    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeletePerson() {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            personTable.getItems().remove(selectedIndex);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("Ninguna persona selecionada");
            alert.setContentText("Por favor seleciona una persona de la tabla.");
            alert.showAndWait();
        }
    }
    }