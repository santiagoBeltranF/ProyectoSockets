package com.distributedSystems.reserves.service;

import com.distributedSystems.reserves.models.dto.CoreDestinosDTO;
import com.distributedSystems.reserves.models.entity.CoreDestinos;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The interface Core destinos service.
 */
public interface CoreDestinosService {

    /**
     * Find all list.
     *
     * @return the list
     */
    @Transactional(readOnly = true)
    public List<CoreDestinos> findAll();

    /**
     * Save core destinos.
     *
     * @param destinos the destinos
     * @return the core destinos
     */
    @Transactional
    public CoreDestinos save(CoreDestinos destinos);

    /**
     * Find by id core destinos.
     *
     * @param id the id
     * @return the core destinos
     */
    @Transactional(readOnly = true)
    public CoreDestinos findById(Integer id);

    /**
     * Factory core destinos.
     *
     * @param destinosDTO the destinos dto
     * @return the core destinos
     */
    @Transactional
    public CoreDestinos factory(CoreDestinosDTO destinosDTO);

    /**
     * Delete.
     *
     * @param id the id
     */
    public void delete(Integer id);
}
