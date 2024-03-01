package com.distributedSystems.reserves.service.impl;

import com.distributedSystems.reserves.models.entity.CorePaqueteTuristico;
import com.distributedSystems.reserves.repository.CorePaqueteTuristicoRepository;
import com.distributedSystems.reserves.service.CorePaquetesTuristicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Core paquete turistico service.
 */
@Service
public class CorePaqueteTuristicoServiceImpl implements CorePaquetesTuristicosService {

    @Autowired
    private CorePaqueteTuristicoRepository paqueteTuristicoRepository;

    @Override
    public List<CorePaqueteTuristico> findAll() {
        return paqueteTuristicoRepository.findAll();
    }

    @Override
    public CorePaqueteTuristico save(CorePaqueteTuristico paqueteTuristico) {
        return paqueteTuristicoRepository.save(paqueteTuristico);
    }

    @Override
    public CorePaqueteTuristico findById(Integer id) {
        return paqueteTuristicoRepository.findById(id).orElse(null);
    }



    @Override
    public void delete(Integer id) {
        paqueteTuristicoRepository.deleteById(id);
    }
}
