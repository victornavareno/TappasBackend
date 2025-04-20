package com.victor.excelmongoapp.service;

import com.victor.excelmongoapp.model.Restaurante;
import com.victor.excelmongoapp.repository.RestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.*;

import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@RequiredArgsConstructor // inyecta el repo sin usar @Autowired
public class ExcelService {

    private final RestauranteRepository restauranteRepository;

    private String getCellString(Row row, int index) {
        try {
            return Optional.ofNullable(row.getCell(index))
                    .map(cell -> cell.getCellType() == CellType.STRING ? cell.getStringCellValue() : cell.toString())
                    .orElse("");
        } catch (Exception e) {
            return "";
        }
    }

    private double getCellNumeric(Row row, int index) {
        try {
            return Optional.ofNullable(row.getCell(index))
                    .filter(cell -> cell.getCellType() == CellType.NUMERIC)
                    .map(org.apache.poi.ss.usermodel.Cell::getNumericCellValue)
                    .orElse(0.0);
        } catch (Exception e) {
            return 0.0;
        }
    }

    private LocalDate getCellAsLocalDate(Row row, int index) {
        Cell cell = row.getCell(index);
        if (cell == null) return null;

        try {
            if (cell.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(cell)) {
                return cell.getLocalDateTimeCellValue().toLocalDate();
            } else if (cell.getCellType() == CellType.STRING) {
                String value = cell.getStringCellValue().trim();
                if (!value.isEmpty()) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Ajusta según sea necesario
                    return LocalDate.parse(value, formatter);
                }
            }
        } catch (Exception e) {
            System.err.println("Fecha inválida en fila " + row.getRowNum() + ": " + e.getMessage());
        }

        return null;
    }

    private double parseValoracion(Cell cell) {
        if (cell == null) return 0.0;
        try {
            String raw = cell.toString().replace(",", ".").trim();
            return Double.parseDouble(raw);
        } catch (Exception e) {
            return 0.0;
        }
    }


    public List<Restaurante> importarExcel(MultipartFile file) {
        List<Restaurante> lista = new ArrayList<>();

        try (InputStream is = file.getInputStream(); Workbook workbook = WorkbookFactory.create(is)) {
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // Saltar encabezado

                Restaurante r = new Restaurante();

                r.setProvincia(getCellString(row, 0));
                r.setModalidad(getCellString(row, 1));
                r.setTipoRecurso(getCellString(row, 2));
                r.setCategoria(getCellString(row, 3));
                r.setFechaApertura(getCellAsLocalDate(row, 4));
                r.setNombre(getCellString(row, 5));
                r.setMunicipio(getCellString(row, 6));
                r.setDireccion(getCellString(row, 7));
                r.setCodigoPostal((int) getCellNumeric(row, 8));
                r.setWeb("SI".equalsIgnoreCase(getCellString(row, 9)));
                r.setPlazas((int) getCellNumeric(row, 10));

                r.setPlatos(Arrays.asList(getCellString(row, 11).split(",")));
                r.setMejoresPlatos(Arrays.asList(getCellString(row, 12).split(",")));

                r.setValoracion(parseValoracion(row.getCell(13)));

                lista.add(r);
            }

            return restauranteRepository.saveAll(lista);

        } catch (Exception e) {
            throw new RuntimeException("Error procesando el archivo", e);
        }
    }

}