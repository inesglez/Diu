package com.example.conversor;

public class ExcepcionMoneda extends Exception {
    public ExcepcionMoneda(String mensaje) {
        super(mensaje);
    }

    public ExcepcionMoneda(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

    public String imprimirMensaje() {
        return getMessage();
    }
}
