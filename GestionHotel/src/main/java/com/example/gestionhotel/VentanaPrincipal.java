package com.example.gestionhotel;

import controlador.ClienteController;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import com.example.gestionhotel.modelo.Cliente;

public class VentanaPrincipal {
    private BorderPane layout;
    private TableView<Cliente> tablaClientes;
    private ClienteController clienteController;

    public VentanaPrincipal() {
        this.layout = new BorderPane();
        this.tablaClientes = new TableView<>();
        this.clienteController = new ClienteController();

        // Configurar tabla de clientes
        TableColumn<Cliente, String> colDni = new TableColumn<>("DNI");
        colDni.setCellValueFactory(data -> data.getValue().getDni());

        TableColumn<Cliente, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(data -> data.getValue().getNombre());

        tablaClientes.getColumns().addAll(colDni, colNombre);
        layout.setCenter(tablaClientes);

        // Configurar detalles de cliente
        Label lblDni = new Label("DNI:");
        TextField txtDni = new TextField();
        Button btnBuscar = new Button("Buscar");

        btnBuscar.setOnAction(e -> {
            Cliente cliente = clienteController.buscarPorDni(txtDni.getText());
            if (cliente != null) {
                // Mostrar detalles
            }
        });

        layout.setRight(new VBox(10, lblDni, txtDni, btnBuscar));
        BorderPane.setMargin(tablaClientes, new Insets(10));
    }

    public BorderPane getLayout() {
        return layout;
    }
}
