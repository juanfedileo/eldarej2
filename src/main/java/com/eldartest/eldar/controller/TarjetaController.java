package com.eldartest.eldar.controller;

import com.eldartest.eldar.exceptions.InvalidAmountException;
import com.eldartest.eldar.service.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/tarjetas")
public class TarjetaController {
    @Autowired
    private TarjetaService tarjetaService;
    @GetMapping("/tasa")
    public ResponseEntity<?> obtenerTasa(@RequestParam String marca, @RequestParam int importe) {
        try {
            double tasa = tarjetaService.calcularTasa(marca, importe);
            Map<String, Object> response = new HashMap<>();
            response.put("marca", marca.toUpperCase());
            response.put("importe", importe);
            response.put("tasa", tasa);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException | InvalidAmountException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
