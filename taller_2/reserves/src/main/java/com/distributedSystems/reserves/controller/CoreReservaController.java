package com.distributedSystems.reserves.controller;

import com.distributedSystems.reserves.models.dto.CoreReservaDTO;
import com.distributedSystems.reserves.models.entity.CoreReserva;
import com.distributedSystems.reserves.service.CoreReservaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class CoreReservaController {

    @Autowired
    private CoreReservaService reservaService;

    @GetMapping("/get-reservas")
    public ResponseEntity<List<CoreReserva>> findAll() {
        List<CoreReserva> lstReservas = reservaService.findAll();
        return ResponseEntity.ok(lstReservas);
    }

    @PostMapping("/save-reserva")
    public ResponseEntity<CoreReserva> save(@RequestBody CoreReservaDTO reservaDTO){
        CoreReserva reservaAux = reservaService.save(reservaService.factory(reservaDTO));
        return ResponseEntity.ok(reservaAux);
    }

    @DeleteMapping("/delete-reserva/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Integer id){
        reservaService.delete(id);
        return ResponseEntity.ok("La reserva ha sido eliminada correctamente!");
    }

}
