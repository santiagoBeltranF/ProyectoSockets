package com.distributedSystems.reserves.service.impl;

import com.distributedSystems.reserves.models.dto.CoreDestinosDTO;
import com.distributedSystems.reserves.models.entity.CoreDestinos;
import com.distributedSystems.reserves.models.entity.CorePaqueteTuristico;
import com.distributedSystems.reserves.repository.CoreDestinosRepository;
import com.distributedSystems.reserves.service.CoreDestinosService;
import com.distributedSystems.reserves.service.CorePaquetesTuristicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Core destinos service.
 */
@Service
public class CoreDestinosServiceImpl implements CoreDestinosService {

    @Autowired
    private CoreDestinosRepository destinosRepository;

    @Autowired
    private CorePaquetesTuristicosService paquetesTuristicosService;


    @Override
    public List<CoreDestinos> findAll() {
        return destinosRepository.findAll();
    }

    @Override
    public CoreDestinos save(CoreDestinos destinos) {
        return destinosRepository.save(destinos);
    }

    @Override
    public CoreDestinos findById(Integer id) {
        return destinosRepository.findById(id).orElse(null);
    }

    @Override
    public CoreDestinos factory(CoreDestinosDTO destinosDTO) {
        CoreDestinos destinos = new CoreDestinos();
        destinos.setFoto(destinosDTO.getFoto());
        destinos.setNombre(destinosDTO.getNombre());
        CorePaqueteTuristico paqueteTuristico = paquetesTuristicosService.findById(destinosDTO.getPaqueteTuristicoId());
        destinos.setPaqueteTuristico(paqueteTuristico);
        return destinos;
    }

    @Override
    public void delete(Integer id) {
        destinosRepository.deleteById(id);
    }
}
