package modelo;

import java.time.LocalDate;

public class Reserva {
    private int id;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private String tipoHabitacion;
    private boolean fumador;
    private String regimen;

    // Constructor
    public Reserva(int id, LocalDate fechaEntrada, LocalDate fechaSalida, String tipoHabitacion, boolean fumador, String regimen) {
        this.id = id;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.tipoHabitacion = tipoHabitacion;
        this.fumador = fumador;
        this.regimen = regimen;
    }

    // Getters y Setters
    // ... similar a la clase Cliente
}
