package com.distributedSystems.reserves.service.impl;

import com.distributedSystems.reserves.models.entity.CorePersona;
import com.distributedSystems.reserves.repository.CorePersonaRepository;
import com.distributedSystems.reserves.service.CorePersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Core persona service.
 */
@Service
public class CorePersonaServiceImpl implements CorePersonaService {

    @Autowired
    private CorePersonaRepository personaRepository;

    @Override
    public List<CorePersona> findAll() {
        return personaRepository.findAll();
    }

    @Override
    public CorePersona save(CorePersona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public CorePersona findById(Integer id) {
        return personaRepository.findById(id).orElse(null);
    }



    @Override
    public void delete(Integer id) {
        personaRepository.deleteById(id);
    }
}
