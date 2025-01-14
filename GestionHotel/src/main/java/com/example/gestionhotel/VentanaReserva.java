package com.example.gestionhotel;

import controlador.ReservaController;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import modelo.Reserva;

public class VentanaReserva {
    private BorderPane layout;
    private TableView<Reserva> tablaReservas;
    private ReservaController reservaController;

    public VentanaReserva() {
        this.layout = new BorderPane();
        this.tablaReservas = new TableView<>();
        this.reservaController = new ReservaController();

        // Configurar tabla de reservas
        TableColumn<Reserva, String> colFecha = new TableColumn<>("Fecha Entrada");
        colFecha.setCellValueFactory(data -> data.getValue().getFechaEntrada().toString());

        TableColumn<Reserva, String> colTipo = new TableColumn<>("Tipo Habitacion");
        colTipo.setCellValueFactory(data -> data.getValue().getTipoHabitacion());

        tablaReservas.getColumns().addAll(colFecha, colTipo);
        layout.setCenter(tablaReservas);
    }

    public BorderPane getLayout() {
        return layout;
    }
}
