package com.distributedSystems.reserves.controller;

import com.distributedSystems.reserves.models.dto.CoreDestinosDTO;
import com.distributedSystems.reserves.models.entity.CoreDestinos;
import com.distributedSystems.reserves.service.CoreDestinosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class CoreDestinosController {

    @Autowired
    private CoreDestinosService destinosService;

    @GetMapping("/get-destinos")
    public ResponseEntity<List<CoreDestinos>> findAll() {
        List<CoreDestinos> lstDestinos = destinosService.findAll();
        return ResponseEntity.ok(lstDestinos);
    }


    @PostMapping("/save-destinos")
    public ResponseEntity<CoreDestinos> save(@RequestBody CoreDestinosDTO destinosDTO){
        CoreDestinos destinos = destinosService.save(destinosService.factory(destinosDTO));
        return ResponseEntity.ok(destinos);
    }

    @DeleteMapping("/delete-destinos/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Integer id){
        destinosService.delete(id);
        return ResponseEntity.ok("El destino se ha eliminado correctamente!");
    }

}
