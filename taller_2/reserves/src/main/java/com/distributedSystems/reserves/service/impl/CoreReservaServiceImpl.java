package com.distributedSystems.reserves.service.impl;

import com.distributedSystems.reserves.models.dto.CoreReservaDTO;
import com.distributedSystems.reserves.models.entity.CorePaqueteTuristico;
import com.distributedSystems.reserves.models.entity.CorePersona;
import com.distributedSystems.reserves.models.entity.CoreReserva;
import com.distributedSystems.reserves.repository.CoreReservaRepository;
import com.distributedSystems.reserves.service.CorePaquetesTuristicosService;
import com.distributedSystems.reserves.service.CorePersonaService;
import com.distributedSystems.reserves.service.CoreReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoreReservaServiceImpl implements CoreReservaService {

    @Autowired
    private CoreReservaRepository reservaRepository;

    @Autowired
    private CorePersonaService personaService;

    @Autowired
    private CorePaquetesTuristicosService paquetesTuristicosService;

    @Override
    public List<CoreReserva> findAll() {
        return reservaRepository.findAll();
    }

    @Override
    public CoreReserva save(CoreReserva reserva) {
        return reservaRepository.save(reserva);
    }

    @Override
    public CoreReserva findById(Integer id) {
        return reservaRepository.findById(id).orElse(null);
    }

    @Override
    public CoreReserva factory(CoreReservaDTO reservaDTO) {
        CoreReserva reserva = new CoreReserva();
        reserva.setFecha(reserva.getFecha());
        CorePersona persona = personaService.findById(reservaDTO.getPersonaId());
        reserva.setPersona(persona);
        reserva.setNumeroPersonas(reservaDTO.getNumeroPersonas());
        reserva.setFecha(reservaDTO.getFecha());
        CorePaqueteTuristico paqueteTuristico = paquetesTuristicosService.findById(reservaDTO.getPaqueteTuristicoId());
        reserva.setPaqueteTuristico(paqueteTuristico);
        return reserva;
    }

    @Override
    public void delete(Integer id) {
        reservaRepository.deleteById(id);
    }
}
