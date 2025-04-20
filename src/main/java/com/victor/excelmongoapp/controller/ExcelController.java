package com.victor.excelmongoapp.controller;

import com.victor.excelmongoapp.ExcelService;
import com.victor.excelmongoapp.model.Restaurante;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/excel")
@RequiredArgsConstructor
public class ExcelController {

    private final ExcelService excelService;

    @PostMapping("/importar")
    public ResponseEntity<String> importarExcel(@RequestParam("file") MultipartFile file) {
        try {
            List<Restaurante> restaurantes = excelService.importarExcel(file);
            return ResponseEntity.ok("Importados " + restaurantes.size() + " restaurantes correctamente.");
        } catch (Exception e) {
            e.printStackTrace(); // MUY importante para que lo veas en consola
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al importar el Excel: " + e.getMessage());
        }
    }

}
