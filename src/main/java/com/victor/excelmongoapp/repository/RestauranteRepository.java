package com.victor.excelmongoapp.repository;

import com.victor.excelmongoapp.model.Restaurante;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestauranteRepository extends MongoRepository<Restaurante, String> {
    List<Restaurante> findDistinctByMunicipio(String municipio);
}
