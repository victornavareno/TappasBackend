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

    public List<Restaurante> getRestaurantesPorMunicipio(String municipio){
        return restauranteRepository.findDistinctByMunicipio(municipio);
    }

}
