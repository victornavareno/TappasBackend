package com.victor.excelmongoapp.service;

import com.victor.excelmongoapp.model.Restaurante;
import com.victor.excelmongoapp.repository.RestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class RestauranteService {

    private final MongoTemplate mongoTemplate;
    private final RestauranteRepository restauranteRepository;

    public List<String> getCiudadesUnicas(){
        return mongoTemplate.query(Restaurante.class).distinct("municipio").as(String.class).all();
    }

    public List<String> getTapasUnicas(){
        return mongoTemplate.query(Restaurante.class).distinct("platos").as(String.class).all();
    }

    public List<Restaurante> getRestaurantesPorMunicipio(String municipio){
        return restauranteRepository.findDistinctByMunicipio(municipio);
    }

    public List<Restaurante> getTop3Restaurantes(String ciudad, String tapa){
        List<Restaurante> restaurantes = restauranteRepository.findByMunicipioAndPlatosContainingIgnoreCase(ciudad, tapa);
        restaurantes.sort((r1, r2) -> Double.compare(r2.getRating(), r1.getRating()));
        return restaurantes.stream().limit(3).toList();
    }
}
