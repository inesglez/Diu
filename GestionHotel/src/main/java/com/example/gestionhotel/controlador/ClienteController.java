package com.example.gestionhotel.controlador;

import com.example.gestionhotel.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    private List<Cliente> clientes;

    public ClienteController() {
        this.clientes = new ArrayList<>();
    }

    public void addCliente(Cliente cliente) {
        clientes.add(Cliente);
        // Añadir cliente a la BBDD
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public Cliente buscarPorDni(String dni) {
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                return cliente;
            }
        }
        return null;
    }
}
