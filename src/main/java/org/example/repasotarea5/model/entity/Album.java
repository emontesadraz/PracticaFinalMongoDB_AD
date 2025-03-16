package org.example.repasotarea5.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "albums") // Esta anotación se utiliza para indicar que esta clase es un documento de Spring
public class Album {

    @Id // Esta anotación se utiliza para indicar que el atributo es una clave primaria
    private String id; // Se declara una variable de tipo String llamada id

    @JsonProperty("grupo_id") // Esta anotación se utiliza para indicar que el atributo es un campo JSON
    private String grupo_id; // Se declara una variable de tipo String llamada grupo_id

    @JsonProperty("titulo") // Esta anotación se utiliza para indicar que el atributo es un campo JSON
    private String titulo; // Se declara una variable de tipo String llamada título

    @JsonProperty("data_lanzamento") // Esta anotación se utiliza para indicar que el atributo es un campo JSON
    @JsonFormat(pattern = "yyyy-MM-dd") // Esta anotación se utiliza para indicar el formato de la fecha
    private LocalDate data_lanzamento; // Se declara una variable de tipo LocalDate llamada data_lanzamento

    @JsonProperty("puntuacion") // Esta anotación se utiliza para indicar que el atributo es un campo JSON
    private float puntuacion; // Se declara una variable de tipo float llamada puntuacion

    /**
     * Constructor de la clase
     *
     * @param id              la clave primaria
     * @param grupo_id        el ID del grupo
     * @param titulo          el titulo del album
     * @param data_lanzamento la fecha de lanzamiento del album
     * @param puntuacion      la puntuacion del album
     */
    public Album(String id, String grupo_id, String titulo, LocalDate data_lanzamento, float puntuacion) {
        this.id = id;
        this.grupo_id = grupo_id;
        this.titulo = titulo;
        this.data_lanzamento = data_lanzamento;
        this.puntuacion = puntuacion;
    }

    public Album() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGrupo_id() {
        return grupo_id;
    }

    public void setGrupo_id(String grupo_id) {
        this.grupo_id = grupo_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getData_lanzamento() {
        return data_lanzamento;
    }

    public void setData_lanzamento(LocalDate data_lanzamento) {
        this.data_lanzamento = data_lanzamento;
    }

    public float getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(float puntuacion) {
        this.puntuacion = puntuacion;
    }
}