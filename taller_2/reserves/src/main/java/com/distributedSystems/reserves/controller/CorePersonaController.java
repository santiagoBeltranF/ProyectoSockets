package com.distributedSystems.reserves.controller;

import com.distributedSystems.reserves.models.entity.CorePaqueteTuristico;
import com.distributedSystems.reserves.models.entity.CorePersona;
import com.distributedSystems.reserves.service.CorePersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class CorePersonaController {

    @Autowired
    private CorePersonaService personaService;

    @GetMapping("/get-personas")
    public ResponseEntity<List<CorePersona>> findAll() {
        List<CorePersona> lstPersonas = personaService.findAll();
        return ResponseEntity.ok(lstPersonas);
    }

    @PostMapping("/save-personas")
    public ResponseEntity<CorePersona> save(@RequestBody CorePersona persona){
        CorePersona personaAux = personaService.save(persona);
        return ResponseEntity.ok(personaAux);
    }

    @DeleteMapping("/delete-persona/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Integer id){
        personaService.delete(id);
        return ResponseEntity.ok("La persona ha sido eliminada correctamente!");
    }
}
