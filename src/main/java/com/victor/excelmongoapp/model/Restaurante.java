package com.victor.excelmongoapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "restaurantes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurante {
    @Id
    private String id;

    // atributos del dataset
    private String provincia;
    private String modalidad;
    private String tipoRecurso;
    private String categoria;
    private LocalDate fechaApertura;
    private String nombre;
    private String municipio;
    private String direccion;
    private int codigoPostal;
    private boolean web;
    private int plazas;
    private List<String> platos;
    private List<String> mejoresPlatos;
    private double rating;
    private String imagen;
}
