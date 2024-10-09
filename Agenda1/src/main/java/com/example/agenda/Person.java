package com.example.agenda;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for a Person.
 *
 * @author Marco Jakob
 */
public class Person {

    private final StringProperty Nombre;
    private final StringProperty Apellidos;
    private final StringProperty Calle;
    private final IntegerProperty CodigoPostal;
    private final StringProperty Ciudad;
    private final ObjectProperty<LocalDate> FechaNacimiento;

    /**
     * Default constructor.
     */
    public Person() {
        this(null, null);
    }

    /**
     * Constructor with some initial data.
     *
     * @param Nombre
     * @param Apellidos
     */
    public Person(String Nombre, String Apellidos) {
        this.Nombre = new SimpleStringProperty(Nombre);
        this.Apellidos = new SimpleStringProperty(Apellidos);

        // Some initial dummy data, just for convenient testing.
        this.Calle = new SimpleStringProperty("some street");
        this.CodigoPostal = new SimpleIntegerProperty(1234);
        this.Ciudad = new SimpleStringProperty("some city");
        this.FechaNacimiento = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
    }

    public String getNombre() {
        return Nombre.get();
    }

    public void setNombre(String Nombre) {
        this.Nombre.set(Nombre);
    }

    public StringProperty NombreProperty() {
        return Nombre;
    }

    public String getApellidos() {
        return Apellidos.get();
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos.set(Apellidos);
    }

    public StringProperty ApellidosProperty() {
        return Apellidos;
    }

    public String getCalle() {
        return Calle.get();
    }

    public void setCalle(String street) {
        this.Calle.set(street);
    }

    public StringProperty CalleProperty() {
        return Calle;
    }

    public int getCodigoPostal() {
        return CodigoPostal.get();
    }

    public void setCodigoPostal(int CodigoPostal) {
        this.CodigoPostal.set(CodigoPostal);
    }

    public IntegerProperty CodigoPostalProperty() {
        return CodigoPostal;
    }

    public String getCiudad() {
        return Ciudad.get();
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad.set(Ciudad);
    }

    public StringProperty CiudadProperty() {
        return Ciudad;
    }

    public LocalDate getFechaNacimiento() {
            return FechaNacimiento.get();
    }

    public void setFechaNacimiento(LocalDate FechaNacimiento) {
        this.FechaNacimiento.set(FechaNacimiento);
    }

    public ObjectProperty<LocalDate> FechaNacimientoProperty() {
        return FechaNacimiento;
    }
}