package com.distributedSystems.reserves.controller;

import com.distributedSystems.reserves.models.dto.CoreDestinosDTO;
import com.distributedSystems.reserves.models.entity.CoreDestinos;
import com.distributedSystems.reserves.models.entity.CorePaqueteTuristico;
import com.distributedSystems.reserves.service.CorePaquetesTuristicosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/admin")
public class CorePaqueteTuristicoController {

    @Autowired
    private CorePaquetesTuristicosService paquetesTuristicosService;

    @GetMapping("/get-paquetes-turisticos")
    public ResponseEntity<List<CorePaqueteTuristico>> findAll() {
        List<CorePaqueteTuristico> lstPaquetesTuristicos = paquetesTuristicosService.findAll();
        return ResponseEntity.ok(lstPaquetesTuristicos);
    }

    @PostMapping("/save-paquetes-turisticos")
    public ResponseEntity<CorePaqueteTuristico> save(@RequestBody CorePaqueteTuristico paqueteTuristico){
        CorePaqueteTuristico paqueteTuristicoAux = paquetesTuristicosService.save(paqueteTuristico);
        return ResponseEntity.ok(paqueteTuristicoAux);
    }

    @GetMapping("/get-paquetes-turisticos-by-id/{id}")
    public ResponseEntity<CorePaqueteTuristico> getById(@PathVariable(value = "id") Integer id){
        CorePaqueteTuristico paqueteTuristico = paquetesTuristicosService.findById(id);
        return ResponseEntity.ok(paqueteTuristico);
    }

    @DeleteMapping("/delete-paquetes-turisticos/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Integer id){
        paquetesTuristicosService.delete(id);
        return ResponseEntity.ok("El paquete turistico eliminado correctamente!");
    }

}
