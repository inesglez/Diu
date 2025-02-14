package com.example.Agenda.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.ArrayList;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonaVO {
    @Id
    private String id;
    private String nombre;
    private String apellidos;
    private String calle;
    private Integer codigoPostal;
    private String ciudad;
    private LocalDate cumpleanos;
    private ArrayList<String> tutorials;
}

