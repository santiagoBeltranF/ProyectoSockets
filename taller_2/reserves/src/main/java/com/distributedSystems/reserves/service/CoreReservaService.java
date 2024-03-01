package com.distributedSystems.reserves.service;

import com.distributedSystems.reserves.models.dto.CoreReservaDTO;
import com.distributedSystems.reserves.models.entity.CoreReserva;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The interface Core reserva service.
 */
public interface CoreReservaService {

    /**
     * Find all list.
     *
     * @return the list
     */
    @Transactional(readOnly = true)
    public List<CoreReserva> findAll();


    /**
     * Save core reserva.
     *
     * @param reserva the reserva
     * @return the core reserva
     */
    @Transactional
    public CoreReserva save(CoreReserva reserva);

    /**
     * Find by id core destinos.
     *
     * @param id the id
     * @return the core destinos
     */
    @Transactional(readOnly = true)
    public CoreReserva findById(Integer id);

    /**
     * Factory core reserva.
     *
     * @param reservaDTO the reserva dto
     * @return the core reserva
     */
    @Transactional
    public CoreReserva factory(CoreReservaDTO reservaDTO);

    /**
     * Delete.
     *
     * @param id the id
     */
    public void delete(Integer id);
}
