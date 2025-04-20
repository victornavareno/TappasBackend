package com.victor.excelmongoapp.controller;

import com.victor.excelmongoapp.model.Restaurante;
import com.victor.excelmongoapp.repository.RestauranteRepository;
import com.victor.excelmongoapp.service.RestauranteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/restaurantes")
@RequiredArgsConstructor
public class RestauranteController {

    private final RestauranteRepository restauranteRepository;
    private final RestauranteService restauranteService;

    //ENDPOINTS:

    // DEVUELVE TODAS LAS CIUDADES DISPONIBLES EN NUESTRA BASE DE DATOS (SIN REPETICION)
    @GetMapping("/ciudades")
    public List<String> listaCiudades(){
        return restauranteService.getCiudadesUnicas();
    }

    //DEVUELVE TODAS LOS RESTAURANTES EN UN MUNICIPIO ESPECIFICADO EN LA URL
    @GetMapping("/{municipio}")
    public List<Restaurante> listaRestaurantesMunicipio(@PathVariable String municipio){
        return restauranteService.getRestaurantesPorMunicipio(municipio);
    }
}
