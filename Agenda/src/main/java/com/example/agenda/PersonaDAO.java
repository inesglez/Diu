package com.example.agenda;

import com.example.agenda.Persona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaDAO {
    private ObservableList<Persona> cachedPersonas; // Para almacenar una lista en caché de personas

    public PersonaDAO() {
        this.cachedPersonas = FXCollections.observableArrayList();
    }

    // Método para agregar una persona a la base de datos
    public void addPersona(Persona persona) {
        String sql = "INSERT INTO personas(first_name, last_name, street, postal_code, city, birthday) VALUES(?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, persona.getFirstName());
            pstmt.setString(2, persona.getLastName());
            pstmt.setString(3, persona.getStreet());
            pstmt.setInt(4, persona.getPostalCode());
            pstmt.setString(5, persona.getCity());
            pstmt.setString(6, persona.getBirthday() != null ? persona.getBirthday().toString() : null);
            pstmt.executeUpdate();
            cachedPersonas.add(persona); // Agrega la persona a la lista en caché
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener todas las personas de la base de datos
    public ObservableList<Persona> getAllPersonas() {
        if (!cachedPersonas.isEmpty()) {
            return cachedPersonas; // Devuelve la lista en caché si no está vacía
        }

        String sql = "SELECT * FROM personas";
        try (Connection conn = DatabaseConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Persona persona = new Persona();
                persona.setFirstName(rs.getString("first_name"));
                persona.setLastName(rs.getString("last_name"));
                persona.setStreet(rs.getString("street"));
                persona.setPostalCode(rs.getInt("postal_code"));
                persona.setCity(rs.getString("city"));
                persona.setBirthday(rs.getDate("birthday") != null ? rs.getDate("birthday").toLocalDate() : null);

                cachedPersonas.add(persona); // Agrega a la lista en caché
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cachedPersonas;
    }

    // Getter para cachedPersonas
    public ObservableList<Persona> getCachedPersonas() {
        return cachedPersonas;
    }

    // Setter para cachedPersonas (si es necesario)
    public void setCachedPersonas(ObservableList<Persona> cachedPersonas) {
        this.cachedPersonas = cachedPersonas;
    }
}
