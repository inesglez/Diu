package com.example.agenda.controller;
import javafx.fxml.FXML;
import com.example.agenda.MainApp;

public class RootLayoutController {

    private MainApp mainApp=new MainApp();

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    /**
     * Opens the birthday statistics.
     */
    @FXML
    private void handleShowBirthdayStatistics() {
        mainApp.showBirthdayStatistics();
    }
}