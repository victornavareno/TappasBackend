package com.victor.excelmongoapp.controller;

import com.victor.excelmongoapp.model.Restaurante;
import com.victor.excelmongoapp.repository.RestauranteRepository;
import com.victor.excelmongoapp.service.RestauranteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/restaurantes")
@RequiredArgsConstructor
public class RestauranteController {

    private final RestauranteRepository restauranteRepository;
    private final RestauranteService restauranteService;

    @GetMapping("/ciudades")
    public List<String> listaCiudades() {
        return restauranteService.getCiudadesUnicas();
    }

    @GetMapping("/tapas")
    public List<String> listaTapas() {
        return restauranteService.getTapasUnicas();
    }

    @GetMapping("/{ciudad}")
    public List<Restaurante> listaRestaurantesMunicipio(@PathVariable String ciudad) {
        String ciudadMayuscula = ciudad.toUpperCase();
        return restauranteService.getRestaurantesPorMunicipio(ciudadMayuscula);
    }

    @GetMapping("/top3/{tapa}/{ciudad}")
    public List<Restaurante> listaRestaurantesTop3(@PathVariable String tapa, @PathVariable String ciudad){
        String ciudadMayuscula = ciudad.toUpperCase();
        return restauranteService.getTop3Restaurantes(ciudadMayuscula, tapa);
    }

    @GetMapping("/id/{id}")
    public Restaurante buscaRestaurante(@PathVariable String id) {
        return restauranteService.getRestaurantById(id);
    }


}
