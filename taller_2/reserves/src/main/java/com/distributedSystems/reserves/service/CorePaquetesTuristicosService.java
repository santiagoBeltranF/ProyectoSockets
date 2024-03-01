package com.distributedSystems.reserves.service;

import com.distributedSystems.reserves.models.entity.CorePaqueteTuristico;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The interface Core paquetes turisticos service.
 */
public interface CorePaquetesTuristicosService {

    /**
     * Find all list.
     *
     * @return the list
     */
    @Transactional(readOnly = true)
    public List<CorePaqueteTuristico> findAll();


    /**
     * Save core paquete turistico.
     *
     * @param paqueteTuristico the paquete turistico
     * @return the core paquete turistico
     */
    @Transactional
    public CorePaqueteTuristico save(CorePaqueteTuristico paqueteTuristico);

    /**
     * Find by id core destinos.
     *
     * @param id the id
     * @return the core destinos
     */
    @Transactional(readOnly = true)
    public CorePaqueteTuristico findById(Integer id);



    /**
     * Delete.
     *
     * @param id the id
     */
    public void delete(Integer id);
}
