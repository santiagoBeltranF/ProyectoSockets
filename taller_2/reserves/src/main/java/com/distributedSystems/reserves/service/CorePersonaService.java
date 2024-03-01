package com.distributedSystems.reserves.service;

import com.distributedSystems.reserves.models.entity.CorePersona;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The interface Core persona service.
 */
public interface CorePersonaService {

    /**
     * Find all list.
     *
     * @return the list
     */
    @Transactional(readOnly = true)
    public List<CorePersona> findAll();


    /**
     * Save core persona.
     *
     * @param persona the persona
     * @return the core persona
     */
    @Transactional
    public CorePersona save(CorePersona persona);

    /**
     * Find by id core destinos.
     *
     * @param id the id
     * @return the core destinos
     */
    @Transactional(readOnly = true)
    public CorePersona findById(Integer id);


    /**
     * Delete.
     *
     * @param id the id
     */
    public void delete(Integer id);
}
