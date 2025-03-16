package org.example.repasotarea5.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "grupos")
public class Grupo {

    @Id
    private String id;

    @JsonProperty("nome") // Esta anotación se utiliza para indicar que el atributo es un campo JSON
    private String nome;

    @JsonProperty("xenero") // Esta anotación se utiliza para indicar que el atributo es un campo JSON
    private String xenero;

    @JsonProperty("dataFormacion") // Esta anotación se utiliza para indicar que el atributo es un campo JSON
    @JsonFormat(pattern = "yyyy-MM-dd") // Esta anotación se utiliza para indicar el formato de la fecha
    private LocalDate dataFormacion;


    /**
     * Constructor de la clase
     * @param id la clave primaria
     * @param nome el nombre del grupo
     * @param xenero el género del grupo
     * @param dataFormacion la fecha de formacion del grupo
     */
    public Grupo(String id, String nome, String xenero, LocalDate dataFormacion) {
        this.id = id;
        this.nome = nome;
        this.xenero = xenero;
        this.dataFormacion = dataFormacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getXenero() {
        return xenero;
    }

    public void setXenero(String xenero) {
        this.xenero = xenero;
    }

    public LocalDate getDataFormacion() {
        return dataFormacion;
    }

    public void setDataFormacion(LocalDate dataFormacion) {
        this.dataFormacion = dataFormacion;
    }
}
